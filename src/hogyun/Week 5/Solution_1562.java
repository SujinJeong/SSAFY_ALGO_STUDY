package bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1562 {
	static int N, res;
	static int[][][] dp;
	static final int MOD = 1000000000;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1][10][1 << 10];

		for (int i = 1; i <= 9; i++) {
			res += sol(1, i, 1 << i);
			res %= MOD;
		}
		System.out.println(res);
	}

	private static int sol(int len, int num, int bit) {
		if (len == N) {
			if (bit == (1 << 10) - 1)
				return 1;
			return 0;
		}

		if (dp[len][num][bit] != 0)
			return dp[len][num][bit];

		if (num + 1 < 10)
			dp[len][num][bit] += sol(len + 1, num + 1, bit | (1 << num + 1));
		if (num - 1 >= 0)
			dp[len][num][bit] += sol(len + 1, num - 1, bit | (1 << num - 1));

		dp[len][num][bit] %= MOD;
		return dp[len][num][bit];
	}
}
