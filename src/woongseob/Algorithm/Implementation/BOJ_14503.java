package study_0208;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14503 {
	static int N, M, r, c, nr, nc, d, ans;
	static boolean flag;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[][] arr;
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visit = new boolean[N][M];
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while (true) {
			if (!flag) {
				clean1();
			}
			
			if (clean2()) {
				break;
			}
		}
		System.out.println(ans);
	}

	private static void clean1() {
		if (arr[r][c] == 1 || visit[r][c]) {
			return;
		}
		visit[r][c] = true;
		ans++;
		flag = true;
	}

	private static boolean clean2() {
		for (int i = 0; i < 4; i++) {
			d--;
			if (d < 0) {
				d = 3;
			}
			nr = r + dr[d];
			nc = c + dc[d];
			if (nr >= 0 && nc >= 0 && nr < N && nc < M && !visit[nr][nc] && arr[nr][nc] != 1) {
				r = nr;
				c = nc;
				flag = false;
				return false;
			}
		}

		nr = r - dr[d];
		nc = c - dc[d];
		if (nr >= 0 && nc >= 0 && nr < N && nc < M && arr[nr][nc] != 1) {
			r = nr;
			c = nc;
			return false;
		}
		return true;
	}

}
