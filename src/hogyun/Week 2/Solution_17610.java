package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_17610 {
	public static int K, S;
	public static int[] arr;
	public static boolean[][] dp;

	public static void Recursion(int cnt, int weight) {
		if (cnt > K || dp[cnt][weight])
			return;
		dp[cnt][weight] = true;
		Recursion(cnt + 1, weight + arr[cnt]);
		Recursion(cnt + 1, Math.abs(weight - arr[cnt]));
		Recursion(cnt + 1, weight);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		arr = new int[14];
		dp = new boolean[14][2600001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
			S += arr[i];
		}
		int res = 0;
		Recursion(0, 0);
		for (int i = 1; i <= S; ++i) {
			if (!dp[K][i])
				res++;
		}
		System.out.println(res);
	}
}
