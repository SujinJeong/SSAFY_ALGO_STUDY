package donggil.Week7;

import java.io.*;
import java.util.*;

//Logic
//Dijkstra 알고리즘으로 해결할 수 있는 문제
//시작지와 도착지가 주어지기에 다익스트라 알고리즘이 돌아가는 동안 탐색하는 최적의 경로에 대해 Queue로 넣어준다
//도착지에 도달하면 탐색길이와 경로큐를 정답큐와 정답길이에 넣어주고 마지막에 출력
//풀이 시간 : 20분
public class boj_11779 {
    private static class Info {
        int[] nodeInfo = new int[2];
        Queue<Integer> Q = new LinkedList<>();
        public Info(int node, int weight, Queue<Integer> Q) {
            this.nodeInfo[0] = node;
            this.nodeInfo[1] = weight;
            this.Q.addAll(Q);
            this.Q.add(node);
        }
    }
    private static ArrayList<int[]> Map[];
    private static int[] answer;
    private static int answerLength = Integer.MAX_VALUE;
    private static Queue<Integer> answerQ = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine()), M = Integer.parseInt(br.readLine());
        Map = new ArrayList[N + 1];
        answer = new int[N + 1];

        for(int i = 0; i <= N; i++) {
            Map[i] = new ArrayList<>();
            answer[i] = Integer.MAX_VALUE;
        }

        StringTokenizer stk;
        while(M --> 0) {
            stk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            int weight = Integer.parseInt(stk.nextToken());

            Map[start].add(new int[]{end, weight});
        }

        stk = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(stk.nextToken());
        int end = Integer.parseInt(stk.nextToken());
        Dijkstra(start, end);

        sb.append(answer[end]).append("\n");
        sb.append(answerLength).append("\n");
        while(!answerQ.isEmpty()) {
            sb.append(answerQ.poll()).append(" ");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static void Dijkstra(int start, int end) {
        answer[start] = 0;
        PriorityQueue<Info> Q = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o1.nodeInfo[1] - o2.nodeInfo[1];
            }
        });
        Queue<Integer> first = new LinkedList<>();
        Q.add(new Info(start, 0, first));
        while(!Q.isEmpty()) {
            Info elem = Q.poll();
            int curNode = elem.nodeInfo[0], curDist = elem.nodeInfo[1];
            if(curNode == end && curDist <= answer[end]) {
                answerLength = elem.Q.size();
                answerQ.clear();
                answerQ.addAll(elem.Q);
            }
            if(curDist > answer[curNode]) continue;
            for(int i = 0; i < Map[curNode].size(); i++) {
                int[] nextElem = Map[curNode].get(i);

                int nextNode = nextElem[0];
                int nextDist = curDist + nextElem[1];

                if(answer[nextNode] > nextDist) {
                    answer[nextNode] = nextDist;
                    Q.add(new Info(nextNode, nextDist, elem.Q));
                }
            }
        }
    }
}
