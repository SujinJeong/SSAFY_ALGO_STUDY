package donggil.Week6;

import java.io.*;
import java.util.StringTokenizer;
//Logic
//DP로 해결할 수 있는 문제
//DP[i][j]는 (1 ~ i-1)까지의 모든 배차들에 대해서 최대로 인원을 끌 수 있는 상태에 현재 i번째 배차가 승객을 선택했을 시 최대값을 저장
//고로 DP[i][j]의 값에는 i번째 차가 DP[i][j - 1](현재 배차 경우의 수 이전) 와 현재값을 넣고 i-1번 배차를 고려했을시 최대값을 넣어야한다
//승객 수는 그때그때 for문으로 도는 것이 아니라 부분합으로 시간 복잡도 최소화

//풀이 시간 : 40분
public class boj_2616 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[][] DP = new int[4][N + 1];

        for(int i = 1; i <= N; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(stk.nextToken());
        }

        for(int i = 1; i <= 3; i++) {
            for(int j = M * i; j <= N; j++) {
                DP[i][j] = Math.max(DP[i][j - 1], DP[i - 1][j - M] + (arr[j] - arr[j - M]));
            }
        }
        sb.append(DP[3][N]);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
