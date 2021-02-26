package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_20304 {
	static int N, M, res;
	static int[] arr;
	static boolean[] visited;
	static Queue<Info> q = new LinkedList<>();

	static class Info {
		int num, size;

		public Info(int num, int size) {
			super();
			this.num = num;
			this.size = size;
		}
	}

	public static void bfs() {
		while (!q.isEmpty()) {
			Info hq = q.poll();
			res = hq.size;

			int size = 1;
			while (N > (1 << size))
				size++;

			for (int i = 0; i < size; ++i) {
				int tmp = hq.num ^ (1 << i);
				if (tmp > N)
					continue;
				if (!visited[tmp]) {
					visited[tmp] = true;
					q.add(new Info(tmp, hq.size + 1));
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		arr = new int[M];
		visited = new boolean[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
			q.add(new Info(arr[i], 0));
			visited[arr[i]] = true;
		}
		bfs();
		System.out.println(res);
	}
}
