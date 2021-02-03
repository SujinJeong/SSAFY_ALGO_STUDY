package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_7576 {
	public static int M, N, checkArea;
	public static int[][] arr;
	public static int[] dx = { 0, 1, 0, -1 };
	public static int[] dy = { 1, 0, -1, 0 };
	public static Queue<Info> q = new LinkedList<>();

	static class Info {
		int x, y;

		public Info(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void dfs(int x, int y) {
		for (int i = 0; i < 4; ++i) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || ny < 0 || nx >= M || ny >= N)
				continue;

			if (arr[nx][ny] == 0) {
				arr[nx][ny] = 1;
				q.add(new Info(nx, ny));
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 가로 6
		M = Integer.parseInt(st.nextToken()); // 세로 4
		arr = new int[M][N];

		int minus = 0;
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1)
					q.add(new Info(i, j));
				else if (arr[i][j] == -1)
					minus++;
			}
		}
		int day = -1;
		checkArea = 0;
		while (!q.isEmpty()) {
			day++;
			int qSize = q.size();
			for (int i = 0; i < qSize; ++i) {
				dfs(q.peek().x, q.peek().y);
				checkArea++;
				q.poll();
			}
		}
		if (checkArea + minus != N * M) {
			System.out.println(-1);
		} else {
			System.out.println(day);
		}
	}
}
