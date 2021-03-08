package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_10924 {
	static int N, M;
	static int[] arr;
	static int[][] dp;

	public static int calc(int s, int e) {
		if (s >= e)
			return 1;

		if (arr[s] != arr[e])
			return 0;

		if (dp[s][e] != -1)
			return dp[s][e];
		
		dp[s][e] = calc(s + 1, e - 1);
		
		return dp[s][e];
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		dp = new int[N + 1][N + 1];
		for (int i = 0; i < N + 1; ++i) {
			Arrays.fill(dp[i], -1);
			dp[i][i] = 1;
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());			
			int maxNum = Math.max(S, E);
			int minNum = Math.min(S, E);
			sb.append(calc(minNum, maxNum) + "\n");
		}
		System.out.println(sb.toString());
	}
}
