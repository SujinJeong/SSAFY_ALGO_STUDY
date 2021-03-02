package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_15683 {
	static int N, M;
	static int res = 987654321;
	static int[][] arr;
	static int[][] copy;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static ArrayList<Info> cctv = new ArrayList<>();

	static class Info {
		int x, y, num, dir;

		public Info(int x, int y, int num, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
			this.dir = dir;
		}
	}

	public static void move(int x, int y, int num, int dir) {
		int nx = x;
		int ny = y;
		if (num == 5) {
			for (int i = 0; i < 4; ++i) {
				nx = x;
				ny = y;
				while (true) {
					nx = nx + dx[(dir + i) % 4];
					ny = ny + dy[(dir + i) % 4];
					if (nx < 0 || ny < 0 || nx >= N || ny >= M)
						break;
					if (copy[nx][ny] == 6)
						break;
					if (copy[nx][ny] == 0)
						copy[nx][ny] = -1;
				}
			}
		} else if (num == 4) {
			for (int i = 0; i < 3; ++i) {
				nx = x;
				ny = y;
				while (true) {
					nx = nx + dx[(dir + i) % 4];
					ny = ny + dy[(dir + i) % 4];
					if (nx < 0 || ny < 0 || nx >= N || ny >= M)
						break;
					if (copy[nx][ny] == 6)
						break;
					if (copy[nx][ny] == 0)
						copy[nx][ny] = -1;
				}
			}
		} else if (num == 3) {
			for (int i = 0; i < 2; ++i) {
				nx = x;
				ny = y;
				while (true) {
					nx = nx + dx[(dir + i) % 4];
					ny = ny + dy[(dir + i) % 4];
					if (nx < 0 || ny < 0 || nx >= N || ny >= M)
						break;
					if (copy[nx][ny] == 6)
						break;
					if (copy[nx][ny] == 0)
						copy[nx][ny] = -1;
				}
			}
		} else if (num == 2) {
			for (int i = 0; i < 3; i += 2) {
				nx = x;
				ny = y;
				while (true) {
					nx = nx + dx[(dir + i) % 4];
					ny = ny + dy[(dir + i) % 4];
					if (nx < 0 || ny < 0 || nx >= N || ny >= M)
						break;
					if (copy[nx][ny] == 6)
						break;
					if (copy[nx][ny] == 0)
						copy[nx][ny] = -1;
				}
			}
		} else if (num == 1) {
			while (true) {
				nx = nx + dx[dir];
				ny = ny + dy[dir];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					break;
				if (copy[nx][ny] == 6)
					break;
				if (copy[nx][ny] == 0)
					copy[nx][ny] = -1;
			}
		}
	}

	public static void copyArr() {
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				copy[i][j] = arr[i][j];
			}
		}
	}

	public static void combination(int idx) {
		if (idx == cctv.size()) {
			copyArr();
			for (int i = 0; i < cctv.size(); ++i)
				move(cctv.get(i).x, cctv.get(i).y, cctv.get(i).num, cctv.get(i).dir);
			int tmpCnt = 0;
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < M; ++j) {
					if (copy[i][j] == 0) {
						tmpCnt++;
					}
				}
			}
			res = Math.min(tmpCnt, res);
			return;
		}
		for (int i = 0; i < 4; ++i) {
			cctv.get(idx).dir = i;
			combination(idx + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		copy = new int[N][M];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] >= 1 && arr[i][j] <= 5) {
					cctv.add(new Info(i, j, arr[i][j], 0));
				}
			}
		}
		combination(0);
		System.out.println(res);
	}
}
