package sujin.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
1. 다음 수는 이전 수 * 2 이상
2. 같은 수 두장이상 x 방법의 수만큼 로또 구매.
3. 앞의 수 중에서 현재수/2보다 작은 수들의 경우의 수를 모두 더함
 */
public class Q2758 {
//	public static int solve(int[][] dp, int n, int m) {
//		solve(dp, n, m/2);
//		return 0;
//	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= tc; t++) {
			
			String[] line = br.readLine().split(" ");
			int n = Integer.parseInt(line[0]);
			int m = Integer.parseInt(line[1]);
			int[][] dp = new int[n+1][m+1];
			
			for (int i = 1; i <= n; i++)
				for (int j = 1; j <= m; j++) {
					for (int k = 1; k <= j/2; k++) {
						
					}
						// dp에 저장되는 값 : dp[i-1][k]
				}
			//sb.append(solve(dp, n, m)+"\n");
		}
		System.out.println(sb);
	}

}
