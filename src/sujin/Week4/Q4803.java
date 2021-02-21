package sujin.Week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 트리의 조건
1. 간선 / 2 = 정점 -1
2. 사이클이 없음 - visited로 체크
 */
public class Q4803 {
	static ArrayList<Integer>[] edge;
	static boolean[] visited;
	static int cnt;

	// idx부터 모든 노드 tree인지 확인 0~m-1까지 반복
	public static int findTree(int idx) {
		Queue<Integer> q = new LinkedList<Integer>();
		int n = 0, e = 0;

		q.offer(idx);
		visited[idx] = true;

		while (!q.isEmpty()) {
			int num = q.poll();
			visited[num] = true;
			n++;
			for (int next : edge[num]) {
				e++;
				if (!visited[next])
					q.offer(next);
			}
		}

		// 모든 관계 확인했을 때 정점과 간선의 관계 맞는지 확인(양방향 그래프 기준)
		return (e / 2) + 1 == n ? 1 : 0;
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int t = 1;; t++) {
			int cnt = 0;
			String[] line = br.readLine().split(" ");
			int n = Integer.parseInt(line[0]);
			int m = Integer.parseInt(line[1]);
			if (n == 0 && m == 0)
				break;

			edge = new ArrayList[n + 1];
			for (int i = 1; i <= n; i++) {
				edge[i] = new ArrayList<Integer>();
			}
			for (int i = 1; i <= m; i++) {
				String[] line2 = br.readLine().split(" ");
				int p = Integer.parseInt(line2[0]);
				int c = Integer.parseInt(line2[1]);
				edge[p].add(c);
				edge[c].add(p);
			}

			visited = new boolean[n + 1];
			for (int i = 1; i <= n; i++) {
				if (!visited[i])
					cnt += findTree(i);
			}

			sb.append("Case " + t + ": ");
			if (cnt == 0)
				sb.append("No trees.");
			else if (cnt == 1)
				sb.append("There is one tree.");
			else
				sb.append("A forest of " + cnt + " trees.");
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
