package donggil.Week6;

import java.io.*;
import java.util.StringTokenizer;

//Logic
//투포인터 문제이다
//문제 제대로 읽고 실수를 줄이자... sum이 S와 동일한 경우가 아니라 sum이 S보다 크거나 같은 경우이다
//풀이 시간 : 30분

public class boj_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int S = Integer.parseInt(stk.nextToken());
        int[] arr = new int[N];
        stk = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        int start = 0, end = 0, answer = 987654321;
        int sum = arr[0];

        while(true) {
            if(sum >= S) {
                int width = end - start + 1;
                if(answer > width) answer = width;
                sum -= arr[start];
                start++;
            } else if(sum < S) {
                end++;
                if(end == N) break;
                sum += arr[end];
            }
        }
        if(answer == 987654321) answer = 0;
        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}
