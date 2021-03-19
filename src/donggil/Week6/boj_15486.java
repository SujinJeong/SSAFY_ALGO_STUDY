package donggil.Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Logic
//DP 문제
//현재의 위치에서 상담 종료일의 최대값을 DP로 도출
//이때까지의 max값에다가 현재 상담을 넣냐 마냐가 관건
//또한 상담 종료일 다음날이 최대값이 될 수 있음 => end가 N + 1인 경우
//이를 위해 모든 상담에 대한 DP종료 후 N + 1의 값이 이때까지의 max값보다 큰지 확인
public class boj_15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int N = Integer.parseInt(br.readLine());
        int[] DP = new int[N + 2];
        int answer = 0;

        for(int i = 1; i <= N; i++) {
            stk = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(stk.nextToken());
            int pay = Integer.parseInt(stk.nextToken());
            int end = i + day;
            if(answer < DP[i]) answer = DP[i];
            if(end <= N + 1) {
                DP[end] = Math.max(answer + pay, DP[end]);
            }
        }
        if(DP[N + 1] > answer) answer = DP[N + 1];
        System.out.println(answer);
    }
}
