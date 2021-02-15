package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_9466 {
	static int T, N, res;
	static int[] arr;
	static boolean[] visited, circle;

	public static void dfs(int idx) {
		visited[idx] = true;
		int next = arr[idx];
		if (!visited[next])
			dfs(next);
		if (!circle[next]) {
			for (int i = next; arr[i] != next; i = arr[i]) {
				res++;
			}
			res++;
		}
		circle[idx] = true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; ++tc) {
			N = Integer.parseInt(br.readLine());
			visited = new boolean[N + 1];
			circle = new boolean[N + 1];
			arr = new int[N + 1];
			res = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 1; i <= N; ++i) {
				dfs(i);
			}
			sb.append(N - res + "\n");
		}
		System.out.println(sb.toString());
	}
}
