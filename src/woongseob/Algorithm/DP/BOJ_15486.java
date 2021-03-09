package study_0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15486 {
	static int N;
	static int[] dp;
	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1][2];
		dp = new int[N + 2]; 
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1 ; i <= N; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i]);
			int end = arr[i][0] + i;
			if(end <= N + 1) {
				dp[end] = Math.max(dp[end], dp[i] + arr[i][1]);
			}
		}
		
		int ans = 0;
		for (int i = 1; i <= N + 1; i++) {
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(ans);
	}
}
