package sujin.LCA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q11437 {
	static int[] depth, parent;
	static ArrayList<Integer>[] adj;

	public static void fillInfo(int curNode, int curDepth, int curParent) {
		parent[curNode] = curParent;
		depth[curNode] = curDepth;

		// 현재 노드에 연결되어 있는 노드들 설정
		for (int i = 0; i < adj[curNode].size(); i++) {
			int nextNode = adj[curNode].get(i);
			if (nextNode != curParent) { // 아래로 내려가야하는데 자식->부모 찾는 경우
				fillInfo(nextNode, curDepth + 1, curNode);
			}
		}

	}

	public static int checkLCA(int a, int b) {

		int a_depth = depth[a];
		int b_depth = depth[b];

		// a가 더 밑에 있을 경우
		while (a_depth > b_depth) {
			a = parent[a];
			a_depth--;
		}
		// b가 더 밑에 있는경우
		while (a_depth < b_depth) {
			b = parent[b];
			b_depth--;
		}
		// 높이 맞춰줬으니 하나씩 따라올라가면서 공통조상 찾기
		while (a != b) {
			a = parent[a];
			b = parent[b];
		}
		return a;
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		depth = new int[n + 1];
		parent = new int[n + 1];

		adj = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}

		// 현재 index, depth, parent 정보로 dfs 탐색
		fillInfo(1, 1, 0);

		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(checkLCA(a, b) + "\n");
		}

		System.out.println(sb);

	}

}
