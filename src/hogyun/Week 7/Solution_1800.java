package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1800 {
	static int N, P, K;
	static int[] cost;
	static int[] parent;
	static final int INF = 987654321;
	static ArrayList<Info>[] arr;

	static class Info implements Comparable<Info> {
		int end, weight;

		public Info(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Info a) {
			return weight - a.weight;
		}
	}

	public static boolean bfs(int mid) {
		PriorityQueue<Info> pq = new PriorityQueue<>();
		pq.add(new Info(1, 0));

		cost = new int[N + 1];
		Arrays.fill(cost, INF);
		cost[1] = 0;
		while (!pq.isEmpty()) {
			Info now = pq.poll();
			for (int i = 0; i < arr[now.end].size(); ++i) {
				int next = arr[now.end].get(i).end;
				int nextCost = arr[now.end].get(i).weight;
				if (nextCost > mid)
					nextCost = 1;
				else
					nextCost = 0;
				if (cost[next] > now.weight + nextCost) {
					cost[next] = now.weight + nextCost;
					pq.add(new Info(next, cost[next]));
				}
			}
		}
		if (cost[N] <= K)
			return true;
		else
			return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; ++i) 
			arr[i] = new ArrayList<>();
		int low = 0;
		int high = 0;
		for (int i = 0; i < P; ++i) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr[u].add(new Info(v, w));
			arr[v].add(new Info(u, w));
			high = Math.max(high, w);
		}
		int res = -1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (bfs(mid)) {
				high = mid - 1;
				res = mid;
			} else {
				low = mid + 1;
			}
		}
		System.out.println(res);
	}
}
