package sujin.Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q15486 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] days = new int[n+1];
		int[] cost = new int[n+1];
		int[] dp = new int[n+2]; // n+1일때 n+2 땡겨와야 하므로
		
		// input
		for (int i = 1; i <= n; i++) {
			String[] line = br.readLine().split(" ");
			days[i] = Integer.parseInt(line[0]);
			cost[i] = Integer.parseInt(line[1]);
		}
		
		// sol
		for (int i = days.length-1; i > 0; i--) {
			if (i + days[i] > n+1) { // 범위를 벗어난 경우 = 이미 퇴사한 경우
				dp[i] = dp[i+1];
			}
			else { // 퇴사 하기 전
				dp[i] = Math.max(dp[i+1], dp[i+days[i]] + cost[i]);
			}
		}
		
		// output
		System.out.println(dp[1]);
	}
}
