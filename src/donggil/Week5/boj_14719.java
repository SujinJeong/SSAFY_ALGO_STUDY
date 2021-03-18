package donggil.Week5;

import java.io.*;
import java.util.StringTokenizer;

public class boj_14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int answer = 0;
        int[] arr = new int[M];

        stk = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        int diffLeft = 0, diffRight = 0;
        for(int i = 1; i < M - 1; i++) {
            //왼쪽 탐색
            int left = 0, right = 0;
            for(int j = i - 1; j >= 0; j--) {
                if(left < arr[j]) left = arr[j];
            }

            //오른쪽 탐색
            for(int j = i + 1; j < M; j++) {
                if(right < arr[j]) right = arr[j];
            }
            diffLeft = left - arr[i];
            diffRight = right - arr[i];
            if(diffLeft <= 0 || diffRight <= 0) continue;
            if(left < right) {
                answer += diffLeft;
            } else {
                answer += diffRight;
            }
        }
        sb.append(answer);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
