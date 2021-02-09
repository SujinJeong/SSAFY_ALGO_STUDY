package graph;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Solution_2667 {
	static int N;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int cnt;
	static int[] area;
	static ArrayList<Integer> aL = new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; ++i) {
			String s = sc.next();
			for (int j = 0; j < N; ++j) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (arr[i][j] == 1 && !visited[i][j]) {
					cnt = 1;
					dfs(i, j);
					aL.add(cnt);
				}
			}
		}
		System.out.println(aL.size());
		Collections.sort(aL);
		for (int i = 0; i < aL.size(); ++i) {
			System.out.println(aL.get(i));
		}
		sc.close();
	}

	static void dfs(int x, int y) {
		visited[x][y] = true;

		for (int i = 0; i < 4; ++i) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= N || ny < 0 || ny >= N)
				continue;
			if (!visited[nx][ny] && arr[nx][ny] == 1) {
				cnt++;
				dfs(nx, ny);
			}
		}
	}

}
