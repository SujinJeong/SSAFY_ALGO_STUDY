package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2758 {
	static int T, N, M;
	static long[][] dp;

	public static long calc(int n, int m) {
		if(n < 1 || m < 1)
			return 0;
		if (dp[n][m] != -1)
			return dp[n][m];
		dp[n][m] = calc(n - 1, m / 2) + calc(n, m - 1);
		return dp[n][m];
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; ++tc) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			dp = new long[N + 1][M + 1];
			for (int i = 0; i < M + 1; ++i) {
				dp[1][i] = i;
			}
			for (int i = 2; i < N + 1; ++i) {
				Arrays.fill(dp[i], -1);
			}
			sb.append(calc(N, M) + "\n");
		}
		System.out.println(sb.toString());
	}
}
