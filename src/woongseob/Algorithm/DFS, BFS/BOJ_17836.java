package study_0208;

import java.io.*;
import java.util.*;

public class BOJ_17836 {
	static int N, M, T;
	static int[] dy = { 1, 0, -1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static int[][] arr;
	static boolean[][][] visit;

	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visit = new boolean[2][N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = bfs();
		if (ans > T) {
			System.out.println("Fail");
		} else {
			System.out.println(ans);
		}
	}

	static class INFO {
		int y;
		int x;
		int cnt;
		boolean sword;

		public INFO(int y, int x, int cnt, boolean sword) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.sword = sword;
		}
	}

	public static int bfs() {
		Queue<INFO> q = new LinkedList<INFO>();
		q.offer(new INFO(0, 0, 0, false));
		while (!q.isEmpty()) {
			INFO temp = q.poll();
			if (temp.y == N - 1 && temp.x == M - 1) {
				return temp.cnt;
			}
			for (int i = 0; i < 4; i++) {
				int ny = temp.y + dy[i];
				int nx = temp.x + dx[i];
				if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
					continue;
				}
				if (temp.sword) {
					if (!visit[1][ny][nx]){
						visit[1][ny][nx] = true;
						q.offer(new INFO(ny, nx, temp.cnt + 1, temp.sword));
					}
					
				} else {
					if (!visit[0][ny][nx] && arr[ny][nx] != 1) {
						visit[0][ny][nx] = true;
						if (arr[ny][nx] == 2) {
							q.offer(new INFO(ny, nx, temp.cnt + 1, true));
						} else {
							q.offer(new INFO(ny, nx, temp.cnt + 1, temp.sword));
						}
					}
				}
			}
		}
		return -1;
	}

}
