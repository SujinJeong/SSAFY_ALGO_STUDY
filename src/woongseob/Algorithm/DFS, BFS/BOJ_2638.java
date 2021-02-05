package study_0201;

import java.io.*;
import java.util.*;

public class BOJ_2638 {
	static int N, M;
	static int[][] cheeze;
	static boolean[][] visit;
	static int dy[] = { 0, 0, 1, -1 };
	static int dx[] = { 1, -1, 0, 0 };
	static Queue<POS> q = new LinkedList<POS>();

	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cheeze = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				cheeze[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 풀이
		int time = 0;
		while (remain()) {
			time++;
			// 외부 공기 체크
			dfs(0, 0);
			// 치즈 체크
			// memset(visit, false, sizeof(visit));
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					visit[i][j] = false;
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (cheeze[i][j] == 1) {
						q.offer(new POS(i, j));
					}
				}
			}
			bfs();
			// 초기화
			init();
		}
		// 출력
		System.out.println(time);
	}

	public static void dfs(int y, int x) {
		cheeze[y][x] = -1;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny < 0 || ny >= N || nx < 0 || nx >= M)
				continue;
			if (!visit[ny][nx] && cheeze[ny][nx] == 0) {
				visit[ny][nx] = true;
				dfs(ny, nx);
			}
		}
	}

	public static void bfs() {
		while (!q.isEmpty()) {
			POS temp = q.poll();
			int y = temp.y;
			int x = temp.x;
			int cnt = 0;
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (ny < 0 || ny >= N || nx < 0 || nx >= M)
					continue;
				if (cheeze[ny][nx] == -1) {
					cnt++;
				}
			}
			if (cnt >= 2) {
				cheeze[y][x] = 0;
			}
		}
	}

	public static void init() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (cheeze[i][j] == -1) {
					cheeze[i][j] = 0;
				}
			}
		}
	}

	public static boolean remain() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (cheeze[i][j] == 1) {
					return true;
				}
			}
		}
		return false;
	}

	public static class POS {
		int y;
		int x;

		public POS(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
}
