package sujin.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
1. lcs 길이 찾기
s1[n], s2[k]가 같다면 : [n, k] == [n-1, k-1] + 1
s1[n], s2[k]가 다르면 : [n, k] == [n-1, k]와 [n, k-1] 중 큰 값

2. lcs 문자열 찾기
[n-1, k]와 [n, k-1] 중 [n, k]와 같은 숫자 찾기
-> 있다면 그리로 이동, 없다면 대각선 왼쪽으로 이동 [n-1, k-1]로
-> 종료조건: dp값이 0일때 그리고 뒤부터 찾았으므로 reverse
 */
public class Q9252 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		StringBuilder sb = new StringBuilder();
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		
		// lcs 길이 찾기
		for (int i = 1; i <= s1.length(); i++) {
			String tmp = s1.substring(i-1, i);
			for (int j = 1; j <= s2.length(); j++) {
				if (tmp.equals(s2.substring(j-1, j))) { // 같은 문자
					// 같으면 lcs 길이 +1 증가
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				else { // 다른문자
					// 문자가 다르면 lcs 길이는 늘어나지 않지만 a 문자열 붙이거나 b 문자열 붙인거 중에 더 긴것 저장
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		// lcs 문자열 찾기 위해 백트래킹
		int x = s1.length(), y = s2.length();
		while (dp[x][y] != 0) {
			
			// 같은 숫자 하나라도 있으면 같은 쪽으로 이동
			if (dp[x-1][y] == dp[x][y]) x--;
			else if (dp[x][y-1] == dp[x][y]) y--;
			else { // 위와 왼쪽 모두 다를 경우 lcs 문자열 추가 -> 대각선으로 이동
				sb.append(s1.substring(x-1, x));
				x--; y--;
			}
			
		}

		System.out.println(dp[s1.length()][s2.length()]);
		if (sb != null)
			System.out.println(sb.reverse());

	}

}
