package study_0215;

import java.io.*;

public class BOJ_5904 {
	static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new int[28];
		dp[0] = 3;
		int idx = 0;
		for (int i = 1; i <= 27; i++) {
			dp[i] = dp[i - 1] * 2 + (i + 3);
			if (dp[i] >= N) {
				idx = i;
				break;
			}
		}
		sol(N, idx);
	}

	private static void sol(int n, int idx) {
		if (idx == 0) {
			if (n == 1) {
				System.out.println("m");
			} else {
				System.out.println("o");
			}
		}
		if (n <= dp[idx - 1]) {
			
		}else if(n <= dp[idx - 1] + idx + 3) {
			if(n == dp[idx - 1] + 1) {
				System.out.println("m");
			}else {
				System.out.println("o");
			}
		}
	}
}
