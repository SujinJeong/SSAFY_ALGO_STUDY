package sujin.Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q1303 {
	/*
	 * 1. 우리 병사 하얀 옷, 적국 병사 파란옷
	 */
	static char[][] map;
	static boolean[][] visited;
	static int N, M;
	static Queue<Info> q;
	static int white = 0, blue = 0;
	static int[] dy = { 1, 0, -1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static class Info {
		int x;
		int y;

		public Info(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void bfs(char team) {
		int cnt = 1;
		
		while (!q.isEmpty()) {
			Info i = q.poll();
			
			for (int idx = 0; idx < 4; idx++) {
				int nx = i.x + dx[idx];
				int ny = i.y + dy[idx];
				
				if (nx < N && nx >= 0 && ny < M && ny >=0) {
					if(!visited[nx][ny] && map[nx][ny] == team) {
						visited[nx][ny] = true;
						q.add(new Info(nx, ny));
						cnt++;
				}
			}
			}
		}
			if(team == 'W') white += (cnt*cnt);
			else blue += (cnt*cnt);
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] line = br.readLine().split(" ");
		M = Integer.parseInt(line[0]);
		N = Integer.parseInt(line[1]);

		map = new char[N][M];
		visited = new boolean[N][M];
		q = new LinkedList<Info>();

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j]) {
					q.add(new Info(i, j));
					visited[i][j] = true;
					bfs(map[i][j]);
				}
			}
		}

		sb.append(white + " " + blue);
		System.out.println(sb);
	}

}
