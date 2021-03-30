package donggil.Week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//Logic
//전형적인 Bellman-Ford 문제이다
//다만 벨만 포드의 경우에는 최적비용 배열 => 즉 정답 배열에 대해서 Long형으로 해줘야한다
//음수값이 너무 클 경우 한번의 갱신만으로도 음수값이 제대로 입력되어지지 않는 경우가 생길 수 있기 때문이다.
public class boj_11657 {
    public static void main(String[] args) throws IOException {
        init();
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        final long max = 987654321;

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int[][] busList = new int[M][3];
        long[] optimalArr = new long[N + 1];

        Arrays.fill(optimalArr, max);

        for(int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            busList[i][0] = Integer.parseInt(stk.nextToken());
            busList[i][1] = Integer.parseInt(stk.nextToken());
            busList[i][2] = Integer.parseInt(stk.nextToken());
        }

        if(!bf(N, max, busList, optimalArr)) {
            for(int i = 2; i <= N; i++) {
                if(optimalArr[i] == max) {
                    sb.append(-1);
                } else {
                    sb.append(optimalArr[i]);
                }
                sb.append("\n");
            }
        } else {
            sb.append(-1);
        }
        System.out.println(sb);
    }
    private static boolean bf(int N, long max, int[][] busList, long[] optimalArr) {
        optimalArr[1] = 0;

        for(int i = 0; i < N - 1; i++) {
            for(int[] elem : busList) {
                if(optimalArr[elem[0]] == max) continue;

                if(optimalArr[elem[1]] > optimalArr[elem[0]] + elem[2]) {
                    optimalArr[elem[1]] = optimalArr[elem[0]] + elem[2];
                }
            }
        }

        for(int[] elem : busList) {
            if(optimalArr[elem[0]] == max) continue;
            if(optimalArr[elem[1]] > optimalArr[elem[0]] + elem[2]) {
                return true;
            }
        }
        return false;
    }
}
