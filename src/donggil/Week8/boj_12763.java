package donggil.Week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//Logic
//다익스트라로 해결할 수 있는 문제이다.
//핵심은 두가지
    //1. 다음 노드 선택할때 시간이 덜 걸리는데 돈은 더 많이 드는 경우
    //2. 다음 노드 선택할때 시간은 더 걸리는데 돈은 덜 드는 경우
//다익을 돌면서 다음 노드에 대해서 가격이나 시간에 대해서 조건을 달아 갱신시키는게 아니라 무조건 갱신시켜주되
//다음 노드 전까지의 시간과 가격이 다음 노드의 최적보다 다 높은 경우에는 탐색 중지

//그리고 계속 틀렸던 요인은 위와같이 로직을 짜면 시간과 가격을 독맂벚ㄱ으로 생각하는 것이기 때문에 도착지에 어떻게든 도달할 수 있는 경우가
//생길수도 있음 => 이렇게되면 도착지의 최적 비용에 대해서 -1 출력여부를 결정해줘야힘, 갱신 되었는지에 대한 것이 아니라

//풀이 시간 : 40분
public class boj_12763 {
    private static void dijk(int N, int T, int M, ArrayList<int[]>[] adj) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    return o1[2] - o1[2];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        pq.add(new int[]{1, 0, 0});

        int[] costArr = new int[N + 1];
        int[] timeArr = new int[N + 1];
        costArr[1] = 0;
        timeArr[1] = 0;

        Arrays.fill(costArr, 987654321);
        Arrays.fill(timeArr, 987654321);

        while(!pq.isEmpty()) {
            int[] node = pq.poll();
            int startNode = node[0], time = node[1], cost = node[2];

            if(time > T || cost > M) continue;

            for(int[] elem : adj[startNode]) {

                if(time + elem[1] > T) continue;

                if(timeArr[elem[0]] < time && costArr[elem[0]] < cost) continue;

                if(cost + elem[2] < costArr[elem[0]]) costArr[elem[0]] = cost + elem[2];
                if(time + elem[1] < timeArr[elem[0]]) timeArr[elem[0]] = time + elem[1];
                pq.add(new int[]{elem[0], time + elem[1], cost + elem[2]});
            }
        }
        if(costArr[N] > M) System.out.println(-1);
        else System.out.println(costArr[N]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int N = Integer.parseInt(br.readLine());
        ArrayList<int[]>[] adj = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        stk = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(stk.nextToken()), M = Integer.parseInt(stk.nextToken());
        int L = Integer.parseInt(br.readLine());

        for(int i = 0; i < L; i++) {
            stk = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(stk.nextToken()), endNode = Integer.parseInt(stk.nextToken());
            int time = Integer.parseInt(stk.nextToken()), cost = Integer.parseInt(stk.nextToken());

            adj[startNode].add(new int[]{endNode, time, cost});
            adj[endNode].add(new int[]{startNode, time, cost});
        }

        dijk(N, T, M, adj);
    }
}
