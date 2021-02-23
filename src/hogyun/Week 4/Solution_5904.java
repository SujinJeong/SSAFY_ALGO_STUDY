package divideandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_5904 {
	static int N, cnt;
	static int[] dp;

	public static char calc(int n) {
		if(n == 1)
			return 'm';
		if(n == 2 || n == 3)
			return 'o';
		int idx = 0;
		while(dp[idx] < n)
			idx++;
		if(dp[idx] == n)
			return 'o';
		if (n - dp[idx - 1] == 1) return 'm'; // 다음 칸
        if (n - dp[idx - 1] <= idx + 3) return 'o'; //  moo.... 에서 o 해당하는 칸
 
        return calc((n - dp[idx - 1] - (idx + 3)));
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		dp = new int[30];
		dp[0] = 3;
		for (int i = 1; i < 30; ++i) {
			dp[i] = dp[i - 1] * 2 + i + 3;
		}
		System.out.println(calc(N));
	}
}
