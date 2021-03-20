package donggil.Week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2098 {
    private static int N;
    private static int[][] Map, DP;
    private static final int max = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Map = new int[N][N];
        DP = new int[(1 << N)][N];

        StringTokenizer stk;
        for(int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                Map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        for(int i = 0; i < DP.length; i++) {
            Arrays.fill(DP[i], max);
        }

        TSP(1, 0);
        System.out.println(DP[1][0]);
    }
    private static int TSP(int visited, int curNode) {
        if(visited == (( 1 << N ) - 1)) {
            if(Map[curNode][0] != 0) return Map[curNode][0];
            else return max;
        }

        if(DP[visited][curNode] != max) return DP[visited][curNode];

        for(int i = 0; i < N; i++) {
            if((visited & (1 << i)) != 0 || Map[curNode][i] == 0) continue;
            DP[visited][curNode] = Math.min(DP[visited][curNode], TSP(visited | (1 << i), i) + Map[curNode][i]);
        }

        return DP[visited][curNode];
    }
}
