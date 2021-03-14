package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_11779 {
	static int N, M, start, end;
	static final int INF = 987654321;
	static ArrayList<Info>[] arr;
	static int[] cost;
	static int[] parent;
	static Stack<Integer> stk = new Stack<>();

	static class Info implements Comparable<Info> {
		int end, weight;

		public Info(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Info b) {
			return weight - b.weight;
		}
	}

	public static void bfs() {
		boolean[] visited = new boolean[N + 1];
		PriorityQueue<Info> pq = new PriorityQueue<>();
		pq.add(new Info(start, 0));
		cost[start] = 0;
		while (!pq.isEmpty()) {
			Info now = pq.poll();
			if (visited[now.end])
				continue;
			visited[now.end] = true;
			for (int i = 0; i < arr[now.end].size(); ++i) {
				int next = arr[now.end].get(i).end;
				int nextCost = arr[now.end].get(i).weight;
				if (cost[next] > cost[now.end] + nextCost) {
					cost[next] = cost[now.end] + nextCost;
					pq.add(new Info(next, cost[next]));
					parent[next] = now.end;
				}
			}
		}

		int tmp = end;
		stk.add(end);
		while (parent[tmp] != 0) {
			stk.add(parent[tmp]);
			tmp = parent[tmp];
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		arr = new ArrayList[N + 1];
		cost = new int[N + 1];
		parent = new int[N + 1];
		for (int i = 0; i < N + 1; ++i) {
			arr[i] = new ArrayList<>();
		}
		Arrays.fill(cost, INF);
		for (int i = 0; i < M; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr[s].add(new Info(e, w));
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		bfs();
		System.out.println(cost[end]);
		System.out.println(stk.size());
		int stkSize = stk.size();
		for (int i = 0; i < stkSize; ++i) {
			sb.append(stk.peek() + " ");
			stk.pop();
		}
		System.out.println(sb.toString());
	}
}
