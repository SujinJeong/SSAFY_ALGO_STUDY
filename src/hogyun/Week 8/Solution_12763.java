package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_12763 {
	static int N, T, M, L, res;
	static ArrayList<Info>[] arr;
	static int[] cost;
	static int[] time;
	static final int INF = 987654321;

	static class Info implements Comparable<Info> {
		int end, time, cost;

		public Info(int end, int time, int cost) {
			super();
			this.end = end;
			this.time = time;
			this.cost = cost;
		}

		@Override
		public int compareTo(Info a) {
			return cost - a.cost;
		}
	}

	public static void bfs() {
		Queue<Info> pq = new LinkedList<>();
		pq.add(new Info(1, 0, 0));
		cost[1] = 0;
		time[1] = 0;
		while (!pq.isEmpty()) {
			Info now = pq.poll();
			if (now.end == N) {
				res = Math.min(res, cost[now.end]);
			}
			for (int i = 0; i < arr[now.end].size(); ++i) {
				int next = arr[now.end].get(i).end;
				int nextCost = arr[now.end].get(i).cost;
				int nextTime = arr[now.end].get(i).time;
				if (cost[next] <= cost[now.end] + nextCost && time[next] <= time[now.end] + nextTime)
					continue;
				if (cost[now.end] + nextCost > M || time[now.end] + nextTime > T)
					continue;
				cost[next] = cost[now.end] + nextCost;
				time[next] = time[now.end] + nextTime;
				pq.add(new Info(next, time[now.end], cost[now.end]));
			}
		}
	}
	
	public static void dfs(int start) {
		if(start == N) {
			res = Math.min(res, cost[start]);
			return;
		}
		for(int i=0; i<arr[start].size(); ++i) {
			int next = arr[start].get(i).end;
			int nextCost = arr[start].get(i).cost;
			int nextTime = arr[start].get(i).time;
			if (cost[next] <= cost[start] + nextCost && time[next] <= time[start] + nextTime)
				continue;
			if (cost[start] + nextCost > M || time[start] + nextTime > T)
				continue;
			cost[next] = cost[start] + nextCost;
			time[next] = time[start] + nextTime;
			dfs(next);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(br.readLine());
		arr = new ArrayList[N + 1];
		cost = new int[N + 1]; // 1 ~ N + 1
		time = new int[N + 1];
		Arrays.fill(cost, INF);
		Arrays.fill(time, INF);
		for (int i = 0; i < N + 1; ++i)
			arr[i] = new ArrayList<>();

		for (int i = 0; i < L; ++i) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			arr[start].add(new Info(end, time, cost));
			arr[end].add(new Info(start, time, cost));
		}
		res = 987654321;
		cost[1] = 0;
		time[1] = 0;
		dfs(1); //bfs로 하면 안됨.
		if (res > M)
			System.out.println(-1);
		else
			System.out.println(res);
	}
}
