package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_17836 {
	static int N, M, T, res;
	static int swordTime = 987654321;
	static int[][] arr;
	static int[][][] visited;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	static class Info {
		int x, y, t, sword;

		public Info(int x, int y, int t, int sword) {
			this.x = x;
			this.y = y;
			this.t = t;
			this.sword = sword;
		}
	}

	public static void bfs(int x, int y) {
		Queue<Info> q = new LinkedList<>();
		q.add(new Info(x, y, 0, 0));
		visited[x][y][0] = 0;
		while (!q.isEmpty()) {
			int hx = q.peek().x;
			int hy = q.peek().y;
			int ht = q.peek().t;
			int hsword = q.peek().sword;

			q.poll();
			if (hx == N - 1 && hy == M - 1) {
				res = ht;
				break;
			}
			if (arr[hx][hy] == 2)
				hsword = 1;

			for (int i = 0; i < 4; ++i) {
				int nx = hx + dx[i];
				int ny = hy + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				if (hsword == 0) {
					if (arr[nx][ny] != 1 && visited[nx][ny][hsword] == 0) {
						visited[nx][ny][hsword] = ht + 1;
						q.add(new Info(nx, ny, ht + 1, hsword));
					}
				} else {
					if (visited[nx][ny][hsword] == 0) {
						visited[nx][ny][hsword] = ht + 1;
						q.add(new Info(nx, ny, ht + 1, hsword));
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
		T = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new int[N][M][2];
		for(int i=0; i<N; ++i) {
			for(int j=0; j<M; ++j) {
				for(int k=0; k<2; ++k) {
					visited[i][j][k] = 0;
				}
			}
		}
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs(0, 0);
		if(res >=1 && res<= T)
			System.out.println(res);
		else
			System.out.println("Fail");
	}
}
