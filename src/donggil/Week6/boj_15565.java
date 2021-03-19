package donggil.Week6;

import java.io.*;
import java.util.StringTokenizer;
//Logic

// Two Pointer를 가지고 처음과 끝을 이동하여주며 라이언의 개수를 목표치만큼 가지되 가장 짧은 길이의 구간을 출력해준다
// 풀이 시간 : 30분
public class boj_15565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken()), K = Integer.parseInt(stk.nextToken());
        int start = 0, end = 0;
        String[] arr = br.readLine().split(" ");

        int cnt = 0;
        final int max = 987654321;
        int answer = max;

        while(end <= N) {
            if(cnt == K) {
                int width = end - start;
                if(answer > width) answer = width;
            }
            if(cnt < K) {
                if(end == N) break;
                if(arr[end++].equals("1")) cnt++;
            } else {
                if(arr[start++].equals("1")) cnt--;
            }
        }
        if(answer == max) {
            answer = -1;
        }
        sb.append(answer);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
