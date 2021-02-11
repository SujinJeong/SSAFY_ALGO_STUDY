package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_14503 {
	static int N, M, startX, startY, startD, res, resTmp;
	static boolean check;
	static int[][] arr;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void dfs(int x, int y, int d) {
		if (arr[x][y] == 0) {
			arr[x][y] = 2;
			resTmp++;
		}
		for (int i = 0; i < 4; ++i) {
			int nd = (d - i + 3) % 4;
			int nx = x + dx[nd];
			int ny = y + dy[nd];
			if (nx < 0 || ny < 0 || nx >= N || ny >= M)
				continue;
			if (arr[nx][ny] == 1 || arr[nx][ny] == 2) {
				continue;
			} else if (arr[nx][ny] == 0) {
				dfs(nx, ny, nd);
				break;
			}
		}
		if (arr[x + dx[(d + 2) % 4]][y + dy[(d + 2) % 4]] == 2)
			dfs(x + dx[(d + 2) % 4], y + dy[(d + 2) % 4], d);
		else {
			if (!check) { // 바로 종료가 안 돼서 이렇게 처음 후진 못 할때를 저장해줬음.
				res = resTmp;
				check = true;
				return;
			}else
				return;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];

		st = new StringTokenizer(br.readLine());
		startX = Integer.parseInt(st.nextToken());
		startY = Integer.parseInt(st.nextToken());
		startD = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		res = 0;
		resTmp = 0;
		dfs(startX, startY, startD);
		System.out.println(res);
	}
}
