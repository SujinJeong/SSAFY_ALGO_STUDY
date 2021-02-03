package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_2638 {
	public static int N, M;
	public static int[][] arr;
	public static int[] dx = { 0, 1, 0, -1 };
	public static int[] dy = { 1, 0, -1, 0 };
	public static boolean[][] visited;
	public static ArrayList<Info> aL;

	static class Info {
		int x, y;

		public Info(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void dfs(int x, int y) {
		visited[x][y] = true;
		arr[x][y] = 2;
		for (int i = 0; i < 4; ++i) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || ny < 0 || nx >= N || ny >= M)
				continue;
			if (arr[nx][ny] != 1 && !visited[nx][ny]) {
				dfs(nx, ny);
			}
		}
	}

	public static boolean checkTwo(int x, int y) {
		int cnt = 0;
		for (int i = 0; i < 4; ++i) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || ny < 0 || nx >= N || ny >= M)
				continue;
			if (arr[nx][ny] == 2)
				cnt++;
		}
		if (cnt >= 2) {
			arr[x][y] = 0; //2로 하지 않은 이유는 바로 외부공기로 바꾸면 밑에 for문 도는 중에 영향을 끼친다.
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int time = 0;
		aL = new ArrayList<>();
		while (true) {
			boolean check = false;
			visited = new boolean[N][M];
			dfs(0, 0);
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < M; ++j) {
					if (arr[i][j] == 1 && checkTwo(i, j)) {
						check = true;
					}
				}
			}
			if (!check)
				break;
			time++;
		}
		System.out.println(time);
	}
}
