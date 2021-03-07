package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_9252 {
	static String str1, str2;
	static StringBuilder sb = new StringBuilder();
	static int[][] dp;
	static Stack<Character> stk = new Stack<>();

	public static int LCS(int x, int y) {
		for (int i = 1; i <= str2.length(); ++i) {
			for (int j = 1; j <= str1.length(); ++j) {
				if (str2.charAt(i - 1) == str1.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		int i = x;
		int j = y;
		while (i >= 1 && j >= 1) {
			if (dp[i][j] == dp[i - 1][j])
				i--;
			else if (dp[i][j] == dp[i][j - 1])
				j--;
			else {
				stk.add(str2.charAt(i - 1));
				i--;
				j--;
			}
		}
		return dp[x][y];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str1 = br.readLine();
		str2 = br.readLine();
		int size1 = str1.length();
		int size2 = str2.length();
		dp = new int[size2 + 1][size1 + 1];
		int res = LCS(size2, size1);
		System.out.println(res);
		for (int i = 0; i < res; ++i) {
			System.out.print(stk.peek());
			stk.pop();
		}
	}
}
