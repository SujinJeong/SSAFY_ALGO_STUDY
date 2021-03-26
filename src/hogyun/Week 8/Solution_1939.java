package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1939 {
	static int N, M, start, end;
	static ArrayList<Info>[] arr;
	static boolean[] visited;

	static class Info {
		int end, weight;

		public Info(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}
	}

	public static boolean bfs(int mid) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		while (!q.isEmpty()) {
			int now = q.poll();
			if (now == end)
				return true;
			for (int i = 0; i < arr[now].size(); ++i) {
				int next = arr[now].get(i).end;
				int nextCost = arr[now].get(i).weight;
				if (!visited[next] && mid <= nextCost) {
					visited[next] = true;
					q.add(next);
				}
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; ++i)
			arr[i] = new ArrayList<>();
		int low = 987654321;
		int high = 0;
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			arr[A].add(new Info(B, C));
			arr[B].add(new Info(A, C));
			low = Math.min(low, C);
			high = Math.max(high, C);
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		while (low <= high) {
			visited = new boolean[N + 1];
			int mid = (low + high) / 2;
			if (bfs(mid))
				low = mid + 1;
			else
				high = mid - 1;
		}
		System.out.println(high);
	}
}
