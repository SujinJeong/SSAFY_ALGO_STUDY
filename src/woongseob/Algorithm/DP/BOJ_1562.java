package study_0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1562 {
	static int N;
	static int[][][] dp;
	static final int MOD = 1000000000;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1][10][1 << 10];

		int ans = 0;
		for (int i = 1; i <= 9; i++) {
			ans += sol(1, i, 1 << i);
			ans %= MOD;
		}
		System.out.println(ans);
	}

	private static int sol(int depth, int num, int bit) {
		if (depth == N) {
			if (bit == (1 << 10) - 1) return 1;
			return 0;
		}
		
		if (dp[depth][num][bit] != 0) return dp[depth][num][bit];
		
		if (num + 1 <= 9) dp[depth][num][bit] += sol(depth + 1, num + 1, bit | (1 << num + 1));
		if (num - 1 >= 0) dp[depth][num][bit] += sol(depth + 1, num - 1, bit | (1 << num - 1));
		
		dp[depth][num][bit] %= MOD;

		return dp[depth][num][bit];
	}
}
