package study_0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2758 {
	static int t, n, m;
	static long[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			dp = new long[n + 1][m + 1];
			for(int i = 1; i <= m; i++) {
				dp[1][i] = 1;
			}
			
			for(int i = 1; i < n; i++) {
				for(int j = 1; j <= m; j++) {
					for(int k = j * 2; k <= m; k++) {
						dp[i + 1][k] += dp[i][j];
					}
				}
			}
			
			long ans = 0;
			for(int i = 1; i <= m; i++) {
				ans += dp[n][i];
			}
			System.out.println(ans);
		}
	}
}
