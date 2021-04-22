package sujin.Floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14938 {
	static int n, m, r;
	static int[][] adj;
	static int[] item;

	public static void init() {
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= n; j++) {
				if (i == j)
					continue;
				if (adj[i][j] == 0)
					adj[i][j] = 987654321;
			}
	}

	public static void floyd() {

		// k : 거쳐가는 노드
		for (int k = 1; k <= n; k++)
			// i : 출발 노드
			for (int i = 1; i <= n; i++)
				// j : 도착 노드
				for (int j = 1; j <= n; j++)
					if (adj[i][k] + adj[k][j] < adj[i][j])
						adj[i][j] = adj[i][k] + adj[k][j];

	}

	public static void calMax() {
		int max = 0;

		for (int i = 1; i <= n; i++) {
			int sum = 0;
			for (int j = 1; j <= n; j++) {
				if (adj[i][j] <= m) {
					sum += item[j];
				}
			}
			max = Math.max(sum, max);
		}

		System.out.println(max);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		item = new int[n + 1];
		adj = new int[n + 1][n + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adj[from][to] = weight;
			adj[to][from] = weight;
		}

		init();
		floyd();
		calMax();
	}
}
