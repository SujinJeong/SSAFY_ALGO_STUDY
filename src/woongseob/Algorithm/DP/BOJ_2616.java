package study_0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2616 {
	static int N, P;
	static int[] arr;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());		
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N + 1];
		for(int i = 1 ; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			arr[i] += arr[i - 1];
		}
		P = Integer.parseInt(br.readLine());		
		dp = new int[4][N + 1];
		// https://lyzqm.blogspot.com/2017/03/2616.html // DP[2][M] 6번 90 + 75 (그림 잘못 표기)
		for(int i = 1; i <= 3; i++) {
			for(int j = i * P; j <= N; j++) {
				dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - P] + (arr[j] - arr[j - P]));
			}
		}
		System.out.println(dp[3][N]);
	}
}
