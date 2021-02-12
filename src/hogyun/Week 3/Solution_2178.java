package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2178 {
	static int N, M;
	static int[][] arr;
	static int[][] visited;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	static class Info {
		int x, y;

		public Info(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void bfs(int startX, int startY) {
		visited[startX][startY] = 1;
		Queue<Info> q = new LinkedList<>();
		q.add(new Info(startX, startY));

		while (!q.isEmpty()) {
			int hx = q.peek().x;
			int hy = q.peek().y;
			q.poll();
			if (hx == N - 1 && hy == M - 1) {
				return;
			}
			for (int i = 0; i < 4; ++i) {
				int nx = hx + dx[i];
				int ny = hy + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				if (arr[nx][ny] == 1 && visited[nx][ny] == 0) {
					visited[nx][ny] = visited[hx][hy] + 1;
					q.add(new Info(nx, ny));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new int[N][M];
		
		for (int i = 0; i < N; ++i) {
			String str = br.readLine();
			for (int j = 0; j < M; ++j) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		bfs(0, 0);
		System.out.println(visited[N - 1][M - 1]);
	}
}
