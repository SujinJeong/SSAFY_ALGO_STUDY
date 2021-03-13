package sujin.Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10942 {
	static boolean[][] dp;

	public static void Palindrome(int[] arr, int n) {
		for (int i = 1; i <= n; i++) {
			// 길이가 1일때는 무조건 true
			dp[i][i] = true;

			if (i == n)
				break;
			// 길이가 2일때
			if (arr[i] == arr[i + 1])
				dp[i][i + 1] = true;
		}
		// 마지막
		// if (arr[n] == arr[n+1]) dp[n][n+1] = true;

		// 길이가 3이상일때 -> 초기값 1+2
		for (int i = 2; i < n; i++) { // 탐색 범위
			// j는 탐색 시작위치
			for (int start = 1; start <= n - i; start++) {
				// 탐색 끝 위치
				int last = i+start;
				// 맨 앞과 맨뒤가 같고, 그 사이 값들이 모두 팰린드롬 true
				if (arr[start] == arr[last] && dp[start + 1][last - 1])
					dp[start][last] = true;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];
		// i~j까지 팰린드롬인지 아닌지 저장
		dp = new boolean[n+1][n+1];

		String[] line = br.readLine().split(" ");
		for (int i = 1; i <= n; i++)
			arr[i] = Integer.parseInt(line[i-1]);

		Palindrome(arr, n);
		int m = Integer.parseInt(br.readLine());

		for (int i = 1; i <= m; i++) {
			line = br.readLine().split(" ");
			int from = Integer.parseInt(line[0]);
			int to = Integer.parseInt(line[1]);

			if (dp[from][to])
				sb.append("1" + "\n");
			else
				sb.append("0" + "\n");
		}

		System.out.println(sb);
	}
	
	
}