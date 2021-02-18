package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_4803 {
	static int N, V;
	static ArrayList<Integer>[] arr;
	static boolean[] visited;
	static boolean isSurround;

	public static void dfs(int start, int before) {
		visited[start] = true;
		for (int i = 0; i < arr[start].size(); ++i) {
			int next = arr[start].get(i);
			if (next == before)
				continue;
			if(!visited[next])
				dfs(next, start);
			else
				isSurround = true;
		} 
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int tc = 1;
		while (true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());
			if (N == 0 && V == 0)
				break;
			arr = new ArrayList[N + 1];
			visited = new boolean[N + 1];

			for (int i = 0; i <= N; ++i)
				arr[i] = new ArrayList<>();
			for (int i = 0; i < V; ++i) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				arr[u].add(v);
				arr[v].add(u);
			}
			int res = 0;
			for (int i = 1; i <= N; ++i) {
				if (!visited[i]) {
					isSurround = false;
					dfs(i, i);
					if (!isSurround) {
						res++;
					}
				}
			}
			if (res >= 2) {
				sb.append("Case " + tc + ":" + " A forest of " + res + " trees.\n");
			} else if (res == 1) {
				sb.append("Case " + tc + ": There is one tree.\n");
			} else {
				sb.append("Case " + tc + ": No trees.\n");
			}
			tc++;
		}
		System.out.println(sb.toString());
	}
}
