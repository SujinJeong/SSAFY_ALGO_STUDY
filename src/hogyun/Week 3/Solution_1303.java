package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1303 {
	static int N, M, resB, resW;
	static char[][] arr;
	static boolean[][] visited;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static ArrayList<Integer> listB = new ArrayList<>();
	static ArrayList<Integer> listW = new ArrayList<>();

	public static void dfs(int x, int y, char data) {
		visited[x][y] = true;
		if (data == 'W')
			resW++;
		else
			resB++;
		for (int i = 0; i < 4; ++i) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || ny < 0 || nx >= M || ny >= N)
				continue;
			if (arr[nx][ny] == data && !visited[nx][ny]) {
				dfs(nx, ny, arr[nx][ny]);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //가로
		M = Integer.parseInt(st.nextToken()); //세로
		arr = new char[M][N];
		visited = new boolean[M][N];
		for (int i = 0; i < M; ++i) {
			String s = br.readLine();
			for (int j = 0; j < N; ++j) {
				arr[i][j] = s.charAt(j);
			}
		}
		for (int i = 0; i < M; ++i) {
			for (int j = 0; j < N; ++j) {
				if (!visited[i][j]) {
					resW = 0;
					resB = 0;
					dfs(i, j, arr[i][j]);
					if(arr[i][j] == 'W')
						listW.add(resW);
					else
						listB.add(resB);
				}
			}
		}
		int sumB = 0;
		int sumW = 0;
		for (int i = 0; i < listW.size(); ++i) {
			sumW += listW.get(i) * listW.get(i);
		}
		for (int i = 0; i < listB.size(); ++i) {
			sumB += listB.get(i) * listB.get(i);
		}
		System.out.println(sumW + " " + sumB);
	}
}
