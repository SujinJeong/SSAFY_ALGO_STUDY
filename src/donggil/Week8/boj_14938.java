package donggil.Week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//Logic
//풀이 방법 2개 하나는 플루이드 하나는 모든정점에 대해서 시작정점으로 해서 다익 돌아주는것
//두번째 방법은 호균이의 코드를 따라했다

public class boj_14938 {
    private static int N, M, R;
    private static int[] cost, itemList;
    private static final int INF = 987654321;
    private static ArrayList<Info>[] arr;

    private static class Info implements Comparable<Info> {
        int end, weight;

        public Info(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Info a) {
            return weight - a.weight;
        }
    }

    private static int dijkstra(int start) {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        cost = new int[N + 1];
        Arrays.fill(cost, INF);
        cost[start] = 0;

        pq.add(new Info(start, 0));

        while (!pq.isEmpty()) {
            int now = pq.poll().end;

            for (int i = 0; i < arr[now].size(); ++i) {
                int next = arr[now].get(i).end;
                int nextCost = arr[now].get(i).weight;

                if (cost[next] > cost[now] + nextCost) {
                    if (cost[now] + nextCost <= M) {
                        cost[next] = cost[now] + nextCost;
                        pq.add(new Info(next, cost[next]));
                    }
                }
            }
        }
        int sum = 0;
        for (int i = 1; i <= N; ++i) {
            if (cost[i] != INF) {
                sum += itemList[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N + 1];
        itemList = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; ++i) {
            arr[i] = new ArrayList<>();
            itemList[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < R; ++i) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            arr[a].add(new Info(b, l));
            arr[b].add(new Info(a, l));
        }

        int res = 0;
        for (int i = 1; i <= N; ++i) {
            int ret = dijkstra(i);
            if(res < ret) res = ret;
        }
        System.out.println(res);
    }
}
//public class boj_14938 {
//    private static void floyd(int N, int M, int[] itemArr, int[][] Map) {
//        for(int k = 1; k <= N; k++) {
//            for(int i = 1; i <= N; i++) {
//                for(int j = 1; j <= N; j++) {
//                    if(Map[i][j] > Map[i][k] + Map[k][j])
//                        Map[i][j] = Map[i][k] + Map[k][j];
//                }
//            }
//        }
//        int answer = -1;
//
//        for(int i = 1; i <= N; i++) {
//            int cnt = 0;
//            for(int j = 1; j <= N; j++) {
//                if(Map[i][j] <= M) cnt += itemArr[j];
//            }
//            answer = Math.max(answer, cnt);
//        }
//        System.out.println(answer);
//    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer stk = new StringTokenizer(br.readLine());
//        int N = Integer.parseInt(stk.nextToken());
//        int M = Integer.parseInt(stk.nextToken());
//        int R = Integer.parseInt(stk.nextToken());
//        int[] itemArr = new int[N + 1];
//        int[][] Map = new int[N + 1][N + 1];
//
//        stk = new StringTokenizer(br.readLine());
//
//        for(int i = 1; i <= N; i++) {
//            itemArr[i] = Integer.parseInt(stk.nextToken());
//            for(int j = 1; j <= N; j++) {
//                if(i == j) Map[i][j] = 0;
//                else Map[i][j] = 987654321;
//            }
//        }
//        for(int i = 0; i < R; i++) {
//            stk = new StringTokenizer(br.readLine());
//            int start = Integer.parseInt(stk.nextToken());
//            int end = Integer.parseInt(stk.nextToken());
//            int dist = Integer.parseInt(stk.nextToken());
//
//            Map[start][end] = dist;
//            Map[end][start] = dist;
//        }
//
//        floyd(N, M, itemArr, Map);
//    }
//}