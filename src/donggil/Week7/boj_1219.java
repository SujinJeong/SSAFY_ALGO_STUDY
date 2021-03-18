package donggil.Week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken()),
            startNode = Integer.parseInt(stk.nextToken()),
            endNode = Integer.parseInt(stk.nextToken()),
            M = Integer.parseInt(stk.nextToken());
        long[] optimalMoney = new long[N];
        int[] money = new int[N];
        ArrayList<int[]> Map = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            optimalMoney[i] = Long.MIN_VALUE;
        }

        for(int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stk.nextToken()),
                end = Integer.parseInt(stk.nextToken()),
                pay = -Integer.parseInt(stk.nextToken());

            Map.add(new int[]{start, end, pay});
        }

        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(stk.nextToken());
        }
        // 입력부 끝
        // ---------------------------------------------------------------------------------------------------

        //Bellman-Ford 알고리즘을 통해 최소값 갱신을 해준다
        ArrayList<Integer> list = new ArrayList<>();
        bf(startNode, N, M, money, optimalMoney, list, Map);

        //도착 지점이 갱신된 적이 없으면 시작지점에서 도착지점까지 연결될 수 없으므로 gg 출력
        if(optimalMoney[endNode] == Long.MIN_VALUE) {
            System.out.println("gg");
            return;
        }

        //Bellman-Ford 알고리즘을 통해서 list에는 양의 Cycle 노드들이 저장되어있으므로
        //걔네들로부터 도착지까지 BFS 탐색을 하였을시를 체크하여 Gee 여부를 체크하여준다
        boolean[] visited = new boolean[N];
        if(BFS(list, Map, visited, endNode)) {
            System.out.println("Gee");
        } else {
            System.out.println(optimalMoney[endNode]);
        }
    }
    private static void bf(int startNode, int N, int M, int[] money,
                           long[] optimalMoney, ArrayList<Integer> list, ArrayList<int[]> Map) {
        //Bellman-Ford
        optimalMoney[startNode] = money[startNode];

        for(int i = 0; i < N - 1; i++) {
            for(int j = 0; j < M; j++) {
                int[] Info = Map.get(j);
                if(optimalMoney[Info[0]] == Long.MIN_VALUE) continue;

                if(optimalMoney[Info[1]] < optimalMoney[Info[0]] + money[Info[1]] + Info[2]) {
                    optimalMoney[Info[1]] = optimalMoney[Info[0]] + money[Info[1]] + Info[2];
                }
            }
        }

        for(int i = 0; i < M; i++) {
            int[] Info = Map.get(i);
            if(optimalMoney[Info[0]] == Long.MIN_VALUE) continue;

            if(optimalMoney[Info[1]] < optimalMoney[Info[0]] + money[Info[1]] + Info[2]) {
                list.add(Info[1]);
            }
        }
    }
    private static boolean BFS(ArrayList<Integer> list, ArrayList<int[]> Map, boolean[] visited, int endNode) {
        //사이클 노드를 꺼내와 큐에 넣어준다
        for(int elem : list) {
            if(!visited[elem]) {
                Queue<Integer> Q = new LinkedList<>();
                visited[elem] = true;
                Q.add(elem);
                while(!Q.isEmpty()) {
                    int node = Q.poll();
                    int length = Map.size();
                    //Queue에 들어가있는 현재 노드를 꺼내와서 모든 간선 정보중 start와 일치하는 애를 체크하여 갈 수 있는 노드들 방문여부 true로 변경
                    for(int i = 0; i < length; i++) {
                        int startNode = Map.get(i)[0], nextNode = Map.get(i)[1];
                        if(startNode == node && !visited[nextNode]) {
                            visited[nextNode] = true;
                            Q.add(nextNode);
                        }
                    }
                }
            }
        }
        //endNode의 탐색 여부를 리턴해준다
        //true일 경우 무한한 돈을 가져서 도착할 수 있음
        return visited[endNode];
    }
}
