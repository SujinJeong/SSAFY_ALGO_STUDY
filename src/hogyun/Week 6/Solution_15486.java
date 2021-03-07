package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_15486 {
	static int N;
	public static ArrayList<Info> arr = new ArrayList<>();
	public static int[] dp;

	static class Info {
		int t, p;

		public Info(int t, int p) {
			this.t = t;
			this.p = p;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1];
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			arr.add(new Info(T, P));
		}

		for (int i = 0; i < N; ++i) {
			dp[i + 1] = Math.max(dp[i], dp[i + 1]);
			if (i + arr.get(i).t <= N) {
				dp[i + arr.get(i).t] = Math.max(dp[i + arr.get(i).t], dp[i] + arr.get(i).p);
			}
		}
		System.out.println(dp[N]);
	}
}
