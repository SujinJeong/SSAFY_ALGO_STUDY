package study_0208;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1303 {
	static int N, M, W, B;
	static int[] dy = {1,0,-1,0};
	static int[] dx = {0,1,0,-1};
	static char[][] arr;
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[M][N];
		visit = new boolean[M][N];
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		// 풀이
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(!visit[i][j]) {
					if(arr[i][j] == 'W') {
						W += Math.pow(dfs(i,j), 2);
					}else {
						B += Math.pow(dfs(i,j), 2);
					}
				}
			}
		}
		// 출력
		System.out.println(W + " " + B);
	}

	private static int dfs(int y, int x) {
		visit[y][x] = true;
		int cnt = 1;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
				continue;
			}
			if (!visit[ny][nx] && arr[ny][nx] == arr[y][x]) {
				cnt += dfs(ny, nx);
			}
		}
		return cnt;
	}
}
