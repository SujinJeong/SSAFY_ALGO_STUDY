package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_17391 {
	static int N, M;
	static int[][] arr, visited;
	static int[] dx = { 0, 1 };
	static int[] dy = { 1, 0 };

	static class Info {
		int x, y, size, cnt;

		public Info(int x, int y, int size, int cnt) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.cnt = cnt;
		}
	}

	public static void bfs() {
		Queue<Info> q = new LinkedList<>();
		q.add(new Info(0, 0, arr[0][0], 1));
		visited[0][0] = 1;
		while (!q.isEmpty()) {
			int hx = q.peek().x;
			int hy = q.peek().y;
			int hSize = q.peek().size;
			int hCnt = q.peek().cnt;
			q.poll();
			for (int i = 0; i < 2; ++i) {
				for (int j = 1; j <= hSize; ++j) {
					int nx = hx + j * dx[i];
					int ny = hy + j * dy[i];
					if (nx < 0 || ny < 0 || nx >= N || ny >= M)
						continue;
					if(visited[nx][ny] == 987654321) {
						visited[nx][ny] = hCnt+1;
						q.add(new Info(nx, ny, arr[nx][ny], visited[nx][ny]));
					}else {
						if(visited[nx][ny] > hCnt+1) {
							visited[nx][ny] = hCnt+1;
							q.add(new Info(nx, ny, arr[nx][ny], visited[nx][ny]));
						}
					}
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
			for (int j = 0; j < M; ++j) {
				visited[i][j] = 987654321;
			}
		}
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();
		System.out.println(visited[N - 1][M - 1] - 1);
	}
}
