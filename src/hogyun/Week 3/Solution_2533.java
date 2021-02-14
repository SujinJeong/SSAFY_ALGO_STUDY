package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_2533 {
	static int N;
	static ArrayList<Integer> arr[];
	static int [][]dp;
	static boolean []visited;
	public static void dfs(int idx) {
		dp[idx][0] = 0;
		dp[idx][1] = 1;
		visited[idx] = true;
		for(int i=0; i<arr[idx].size(); ++i) {
			int tmp = arr[idx].get(i);
			if(!visited[tmp]) {
				dfs(tmp);
				dp[idx][0] += dp[tmp][1];
				dp[idx][1] += Math.min(dp[tmp][0], dp[tmp][1]);
			}
		}
		return;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		arr = new ArrayList[N + 1];
		visited = new boolean[N+1];
		dp = new int[1000001][2];
		for(int i=0; i<2; ++i) {
			for(int j=0;j<1000001;++j) {
				dp[j][i] = -1;
			}
		}
		
		for(int i=0; i<=N; ++i) 
			arr[i] = new ArrayList<Integer>();
		
		for (int i = 0; i < N - 1; ++i) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			arr[u].add(v);
			arr[v].add(u);
		}
		dfs(1);
		System.out.println(Math.min(dp[1][0], dp[1][1]));
	}
}
