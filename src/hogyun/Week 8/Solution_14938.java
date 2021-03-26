package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_14938 {
	static int N, M, R;
	static int[] cost, itemList;
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

	public static int dijkstra(int start) {
		cost = new int[N + 1];
		Arrays.fill(cost, INF);
		cost[start] = 0;
		PriorityQueue<Info> pq = new PriorityQueue<>();
		pq.add(new Info(start, 0));
		while (!pq.isEmpty()) {
			int now = pq.peek().end;
			pq.poll();
			for (int i = 0; i < arr[now].size(); ++i) {
				int next = arr[now].get(i).end;
				int nextCost = arr[now].get(i).weight;
				if (cost[next] > cost[now] + nextCost) {
					if (cost[now] + nextCost <= M) {
						cost[next] = cost[now] + nextCost;
						pq.add(new Info(next, cost[next]));
					}
				}
			}
		}
		int sum = 0;
		for (int i = 1; i <= N; ++i) {
			if (cost[i] != INF) {
				sum += itemList[i];
			}
		}
		return sum;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; ++i) {
			arr[i] = new ArrayList<>();
		}
		itemList = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; ++i) {
			itemList[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < R; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			arr[a].add(new Info(b, l));
			arr[b].add(new Info(a, l));
		}
		int res = 0;
		for (int i = 1; i <= N; ++i)
			res = Math.max(dijkstra(i), res);
		System.out.println(res);
	}
}
