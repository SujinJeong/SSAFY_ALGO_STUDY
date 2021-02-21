package study_0215;

import java.io.*;
import java.util.*;

public class BOJ_2098 {
	static int N;
	static int[][] W, dp;
	static final int INF = 987654321;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		W = new int[N][N];
		dp = new int[N][1<<N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0 ; i < N; i++) {
			Arrays.fill(dp[i], -1);
		}
		System.out.println(TSP(0, 1));
	}

	private static int TSP(int node, int bit) {
		if (bit == (1 << N) - 1) {
			if(W[node][0] == 0) {
				return INF;
			}
			return W[node][0];
		}
		
		if(dp[node][bit] != -1) return dp[node][bit];
		dp[node][bit] = INF;
		for(int i = 0; i < N; i++) {
			if((bit & (1 << i)) != 0|| W[node][i] == 0) continue;
			int cost = TSP(i, (bit | (1 << i))) + W[node][i];
			dp[node][bit] = Math.min(dp[node][bit], cost);
		}
		return dp[node][bit];
	}
}
