package study_0201;

import java.io.*;
import java.util.*;

public class BOJ_7576 {
	static int M, N, ans;
	static int[][] box;
	static boolean[][] visit;
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };
	static Queue<Tomato> q = new LinkedList<Tomato>();

	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		box = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 1) {
					q.offer(new Tomato(i, j, 0));
					visit[i][j] = true;
				}
			}
		}
		// 풀이
		bfs();
		// 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 0) {
					ans = -1;
					break;
				}
			}
		}
		System.out.println(ans);
	}

	static public class Tomato {
		int y;
		int x;
		int day;

		public Tomato(int y, int x, int day) {
			super();
			this.y = y;
			this.x = x;
			this.day = day;
		}
	}

	static public void bfs() {
		while (!q.isEmpty()) {
			Tomato tmp = q.poll();
			int y = tmp.y;
			int x = tmp.x;
			ans = tmp.day;
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (ny < 0 || ny >= N || nx < 0 || nx >= M) {
					continue;
				}
				if(!visit[ny][nx] && box[ny][nx] == 0) {
					box[ny][nx] = 1;
					q.offer(new Tomato(ny, nx, tmp.day + 1));
					visit[ny][nx] = true;
				}
			}
		}
	}
}
