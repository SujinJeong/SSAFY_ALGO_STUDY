package study_0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9252 {
	static int[][] dp;
	static String[][] ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s1 = br.readLine();
		String s2 = br.readLine();
		int l1 = s1.length();
		int l2 = s2.length();
		dp = new int[l1 + 1][l2 + 1];
		ans = new String[l1 + 1][l2 + 1];
		for (int i = 0; i < l1; i++) {
			for (int j = 0; j < l2; j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					dp[i + 1][j + 1] = dp[i][j] + 1;
					if(ans[i][j] == null) ans[i][j] = "";
					ans[i + 1][j + 1] = ans[i][j] + s1.charAt(i);
				} else {
					if (dp[i][j + 1] > dp[i + 1][j]) {
						dp[i + 1][j + 1] = dp[i][j + 1];
						ans[i + 1][j + 1] = ans[i][j + 1];
					}else {
						dp[i + 1][j + 1] = dp[i + 1][j];
						ans[i + 1][j + 1] = ans[i + 1][j];
					}
				}
			}
		}
		
		sb.append(dp[l1][l2] + "\n");
		if(dp[l1][l2] != 0) {
			sb.append(ans[l1][l2]);
		}
		System.out.println(sb);
	}
}
