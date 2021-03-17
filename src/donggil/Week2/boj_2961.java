package donggil.Week2;

import java.io.*;
import java.util.StringTokenizer;

public class boj_2961 {
    private static int N;
    private static int[] arr1, arr2;
    private static boolean[] visited;
    private static long answer = Long.MAX_VALUE;
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer stk;
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        arr1 = new int[N];
        arr2 = new int[N];
        for(int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            arr1[i] = Integer.parseInt(stk.nextToken());
            arr2[i] = Integer.parseInt(stk.nextToken());
        }

        Logic(0,0, 1, 0);
        sb.append(answer);
        bw.write(String.valueOf(sb));
        bw.close();
        br.close();
    }
    private static void Logic(int cnt, int idx, int sum1, int sum2) {
        if(cnt > 0)
            answer = Math.min(Math.abs(sum1 - sum2), answer);

        for(int i = idx; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                Logic(cnt + 1, i, sum1 * arr1[i], sum2 + arr2[i]);
                visited[i] = false;
            }

        }
    }
}
