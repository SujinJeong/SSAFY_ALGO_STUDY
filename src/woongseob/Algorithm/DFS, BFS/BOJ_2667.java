package study_0208;

import java.io.*;
import java.util.*;

public class BOJ_2667 {
	static int N;
	static int[] dy = { 1, 0, -1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static int[][] arr;
	static boolean[][] visit;
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		// 풀이
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j] && arr[i][j] == 1) {
					list.add(dfs(i, j, ++cnt));
				}
			}
		}
		// 출력
		System.out.println(cnt);
		Collections.sort(list);
		for(int i: list) {
			System.out.println(i);
		}
	}

	private static int dfs(int y, int x, int cnt) {
		int num = 1;
		visit[y][x] = true;
		arr[y][x] = cnt;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
				continue;
			}
			if (!visit[ny][nx] && arr[ny][nx] == 1) {
				num += dfs(ny, nx, cnt);
			}
		}
		return num;
	}

}
