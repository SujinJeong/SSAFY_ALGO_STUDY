package donggil.Week2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_14501 {
    static int N;
    static int[][] Tasks;
    static int[] DP;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int ans = Integer.MIN_VALUE;
        N = Integer.parseInt(br.readLine());
        Tasks = new int[N][3];
        DP = new int[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int end, C, T;
            T = Integer.parseInt(stk.nextToken());
            C = Integer.parseInt(stk.nextToken());
            end = i + T;
            if(end <= N) {
                Tasks[i][0] = i + 1;
                Tasks[i][1] = end;
                Tasks[i][2] = C;
            } else {
                Tasks[i][0] = -1;
                Tasks[i][1] = -1;
                Tasks[i][2] = -1;
            }
        }
        Arrays.sort(Tasks, (T1, T2) -> {
            if(T1[1] == T2[1]) {
                return Integer.compare(T2[2], T1[2]);
            } else {
                return Integer.compare(T1[1], T2[1]);
            }
        });

        for(int i = 0; i < N; i++) {
            DP[i] = Tasks[i][2];
        }
        for(int i = 0; i < N; i++) {
            if(DP[i] != -1) {
                for(int j = i + 1; j < N; j++) {
                    if(DP[j] != -1 && (Tasks[i][1] < Tasks[j][0])) {
                        DP[j] = Math.max(DP[j], Tasks[j][2] + DP[i]);
                    }
                }
            }
        }
        for(int i = 0; i < N; i++) {
            if(ans < DP[i]) ans = DP[i];
        }
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            if(Tasks[i][0] == -1) cnt++;
        }
        if(cnt == N) ans = 0;
        if(N == 1) {
            if(Tasks[0][1] == -1) ans = 0;
            else ans = Tasks[0][2];
        }
        sb.append(ans).append("\n");
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
        return;
    }
}
