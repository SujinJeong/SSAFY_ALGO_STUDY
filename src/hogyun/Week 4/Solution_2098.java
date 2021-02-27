package tsp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2098 {
	static int N;
	static int[][] arr, dp;

	public static int dfs(int node, int bit) {
		if (bit == (1 << N) - 1) {
			if (arr[node][0] == 0)
				return 987654321;
			return arr[node][0];
		}
		if (dp[node][bit] != -1)
			return dp[node][bit];
		
		dp[node][bit] = 987654321;
		for (int i = 0; i < N; ++i) {
			if (arr[node][i] == 0 || (bit & (1 << i)) != 0) 
				continue;
			dp[node][bit] = Math.min(dp[node][bit], dfs(i, (bit | (1 << i))) + arr[node][i]);
		}
		return dp[node][bit];
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		dp = new int[N][1 << N];
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; ++i) {
			Arrays.fill(dp[i], -1);
		}
		System.out.println(dfs(0, 1));
	}
}
