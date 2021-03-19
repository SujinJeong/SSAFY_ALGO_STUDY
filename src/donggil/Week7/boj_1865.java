package donggil.Week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_1865 {
    //Logic
    //Bellman-Ford 알고리즘으로 풀 수 있는 문제이다
    //풀이 시간 : 70분
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        final int INF = 987654321;
        int TC = Integer.parseInt(br.readLine()), N, M, W;

        while (TC-- > 0) {
            //N, M, W 입력
            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            M = Integer.parseInt(input[1]);
            W = Integer.parseInt(input[2]);
            int[][] Map = new int[M * 2 + W][3];
            int[] dist = new int[N + 1];
            init(br, Map, dist, M, W, INF);
            if (Bellman(Map, dist, N))
                sb.append("YES").append("\n");
            else
                sb.append("NO").append("\n");
        }

        System.out.println(sb);
    }

    private static boolean Bellman(int[][] Map, int[] dist, int N) {
        boolean updated;
        int mapLength = Map.length, curNode, nextNode, time;
        dist[1] = 0;

        //N번 라운드를 수행
        for (int i = 1; i <= N; i++) {
            updated = false;
            //모든 간선정보를 가지고 최소간선 정보 갱신
            for (int j = 0; j < mapLength; j++) {
                curNode = Map[j][0];
                nextNode = Map[j][1];
                time = Map[j][2];

                if (dist[curNode] + time < dist[nextNode]) {
                    dist[nextNode] = dist[curNode] + time;
                    updated = true;
                }
            }
            //갱신된 적이 없다면 순환이 존재하지 않는다는 뜻이므로 false리턴
            if (!updated) return updated;
        }
        //N번까지 했는대도 갱신이 되었다면 순환이 존재한단 뜻이므로 true리턴
        return true;
    }
    private static void init(BufferedReader br, int[][] Map, int[] dist, int M, int W, int INF) throws IOException {
        int start, end, time, i;
        String[] input;

        Arrays.fill(dist, INF);

        for (i = 0; i < M * 2; i++) {
            input = br.readLine().split(" ");
            start = Integer.parseInt(input[0]);
            end = Integer.parseInt(input[1]);
            time = Integer.parseInt(input[2]);
            Map[i][0] = start;
            Map[i][1] = end;
            Map[i][2] = time;
            i++;
            Map[i][0] = end;
            Map[i][1] = start;
            Map[i][2] = time;
        }

        while (W-- > 0) {
            input = br.readLine().split(" ");
            start = Integer.parseInt(input[0]);
            end = Integer.parseInt(input[1]);
            time = -Integer.parseInt(input[2]);
            Map[i][0] = start;
            Map[i][1] = end;
            Map[i][2] = time;
            i++;
        }
    }
}
