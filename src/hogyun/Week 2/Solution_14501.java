package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_14501 {
	public static int N;
	public static ArrayList<Info> aL = new ArrayList<>();
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
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			aL.add(new Info(t, p));
		}

		for (int i = 0; i < N; ++i) {
			dp[i + 1] = Math.max(dp[i], dp[i + 1]);
			if (i + aL.get(i).t <= N) 
				dp[i + aL.get(i).t] = Math.max(dp[i + aL.get(i).t], dp[i] + aL.get(i).p);			
		}
		System.out.println(dp[N]);
	}
}
