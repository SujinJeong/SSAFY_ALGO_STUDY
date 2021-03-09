package study_0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10942 {
	static int N, T, s, e;
	static int[] arr;
	static boolean[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr = new int[N + 1];
		for(int i = 1 ; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		T = Integer.parseInt(br.readLine());
		
		dp = new boolean[N + 1][N + 1];
		// 1자리
		for(int i = 1; i <= N; i++) {
			dp[i][i] = true;
		}
		// 2자리
		for(int i = 1; i < N; i++) {
			if(arr[i] == arr[i + 1]) {
				dp[i][i+1] = true;
			}
		}
		// 그 이상
		// 중간의 길이
		for(int i = 1; i <= N; i++) {
		// 시작점~ 끝점
			for(int j = 1; j <= N; j++) {
				if(i + j + 1 > N) continue;
				if(arr[j] == arr[j + i + 1] && dp[j + 1][j + i]) {
					dp[j][j + i + 1] = true;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			if(dp[s][e]) {
				sb.append("1\n");
			}
			else {
				sb.append("0\n");
			}
		}
		System.out.println(sb);
	}
}
