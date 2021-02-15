package study_0208;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_9466 {
	static int ans;
	static int[] team;
	static boolean[] visit, cycle;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			team = new int[n + 1];
			visit = new boolean[n + 1];
			cycle = new boolean[n + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				team[i] = Integer.parseInt(st.nextToken());
			}
			ans = 0;
			for (int i = 1; i <= n; i++) {
				if (!visit[i]) {
					dfs(i);
				}
			}
			sb.append((n - ans) + "\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int node) {
		visit[node] = true;
		int next = team[node];
		// 처음 방문 시
		if (!visit[next]) {
			dfs(next);
		} else { // 이미 탐색한 노드 일 경우 (싸이클이 있거나, 싸이클을 만들 수 없거나)
			// 처음 탐색하는 싸이클
			if(!cycle[next]) {
				for(int i = next; i != node; i = team[i]) {
					ans++;
				}
				ans++;
			}
			// 그외 싸이클로 진입하는 숫자는 어짜피 팀을 꾸릴 수 없음
		}
		cycle[node] = true;
	}
}
