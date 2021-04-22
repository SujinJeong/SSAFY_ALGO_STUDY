package sujin.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q2178 {
	static int[][] map;
	static boolean[][] visited;
	static Queue<Info> q;
	static int n, m;
	static int[] dy = {1, 0, -1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	public static class Info {
		int x;
		int y;
		
		public Info(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	public static void bfs() {
		
		
		while (!q.isEmpty()) {
			Info i = q.poll();
			int x = i.x;
			int y = i.y;
			
			for (int idx = 0; idx < 4; idx++) {
				int nx = x + dx[idx];
				int ny = y + dy[idx];
				
				if (nx <= n && nx > 0 && ny <= m && ny > 0)
					if (!visited[nx][ny] && map[nx][ny] == 1) {
						visited[nx][ny] = true;
						map[nx][ny] = map[x][y] + 1;
						q.offer(new Info(nx, ny));
				}
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		q = new LinkedList<Info>();
		
		// input
		String[] line = br.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		
		map = new int[n+1][m+1];
		visited = new boolean[n+1][m+1];
		
		for (int i = 1; i <= n; i++) {
			String line2 = br.readLine();
			for (int j = 1; j <= m; j++) {
				map[i][j] = line2.charAt(j-1)- '0';
			}
		}
		
		// sol
		visited[1][1] = true;
		q.offer(new Info(1, 1));
		bfs();
		
		System.out.println(map[n][m]);
	}

}
