package donggil.Week6;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//Logic
//DP[i][j]는 i번째 위치에 j라는 숫자를 선택했을시 만들 수 있는 로또의 개수이다
//로또의 규칙에서 DP[i][j]를 선택하기 위해서는 이전에 고른 숫자보다 2배 이상 커야한다 => DP[i - 1][j / 2] 경우의 수를 더해주면 된다
//또한 DP[i][j]는 j라는 숫자를 선택했을시에 경우의 수라고 말했다싶이 DP[i][j - 1]을 더해주어야한다 => 동일한 번째에 j - 1라는 숫자를 선택했을시에 경우의 수

public class boj_2758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int TestCase = Integer.parseInt(br.readLine());
        StringTokenizer stk;
        long[][] DP = new long[11][2001];

        while(TestCase --> 0) {
            stk = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(stk.nextToken());
            int M = Integer.parseInt(stk.nextToken());

            Arrays.fill(DP[0], 1);

            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= M; j++) {
                    DP[i][j] = DP[i - 1][j / 2] + DP[i][j - 1];
                }
            }
            sb.append(DP[N][M]).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
