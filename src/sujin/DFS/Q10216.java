package sujin.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10216 {
	static Info[] arr;
	static boolean[] visited;

	static class Info {
		int x, y, r;

		public Info(int x, int y, int r) {
			super();
			this.x = x;
			this.y = y;
			this.r = r;
		}

	}

	// 한그룹이 된 경우, 또 타고 들어가서 그룹인지 검사
	public static void dfs(int cur) {
		visited[cur] = true;

		for (int i = 0; i < arr.length; i++) {
			if (!visited[i]) {
				int xd = (int) Math.pow(arr[i].x - arr[cur].x, 2);
				int yd = (int) Math.pow(arr[i].y - arr[cur].y, 2);
				double d = Math.sqrt(xd + yd);

				// 반지름 합 보다 작거나(겹치는 공간 있음) 같으면(한점에서 만남)
				if (d <= arr[i].r + arr[cur].r) {
					dfs(i);
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		while (tc-- > 0) {
			int n = Integer.parseInt(br.readLine());

			// input
			arr = new Info[n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());

				arr[i] = new Info(x, y, r);
			}

			visited = new boolean[n];
			// 그룹갯수 출력
			int rslt = 0;
			for (int i = 0; i < n; i++) {
				if (!visited[i]) {
					// 연결 가능한 모든 경우의 수를 찾으면 탈출
					dfs(i);
					// 한그룹 생성
					rslt++;
				}
			}

			sb.append(rslt + "\n");
		}
		
		System.out.println(sb);
	}

}
