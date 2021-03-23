package study_0316;

import java.io.*;
import java.util.*;

public class BOJ_12763 {
	static final int INF = 987654321;
	static int N, T, M, L, ans = INF;
	static int[] cost, time;
	static ArrayList<ArrayList<Info>> graph = new ArrayList<ArrayList<Info>>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(br.readLine());

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Info>());
		}

		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph.get(from).add(new Info(to, time, cost));
			graph.get(to).add(new Info(from, time, cost));
		}

		cost = new int[N + 1];
		time = new int[N + 1];
		for (int i = 2; i <= N; i++) {
			cost[i] = INF;
			time[i] = INF;
		}
		dfs(1);
		if(ans >= M) {ans = -1;}
		System.out.println(ans);
	}

	private static void dfs(int curr) {
		if(curr == N) {
			ans = Math.min(ans, cost[curr]);
			return;
		}
		for(int i = 0; i < graph.get(curr).size(); i++) {
			int next = graph.get(curr).get(i).next;
			int c = graph.get(curr).get(i).cost;
			int t = graph.get(curr).get(i).time;
			if(cost[next] > cost[curr] + c || time[next] > time[curr] + t) {
				if(cost[curr] + c > M || time[curr] + t > T) continue;
				cost[next] = cost[curr] + c;
				time[next] = time[curr] + t;
				dfs(next);
			}
		}
	}
	
	static class Info {
		int next;
		int time;
		int cost;

		public Info(int next, int time, int cost) {
			super();
			this.next = next;
			this.time = time;
			this.cost = cost;
		}
	}
}
