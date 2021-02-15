package sujin.Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class Q2667 {
	static int[][] map;
	static ArrayList<Integer> village;
	static boolean[][] visited; 
	static Queue<Point> q;
	static int[] dy = {1, 0, -1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int n;
	
	public static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	public static int bfs() {
		int cnt = 1;
		while(!q.isEmpty()) {
			
			Point p = q.poll();
			int x = p.x;
			int y = p.y;
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx < n && nx >= 0 && ny < n && ny >=0)
					if (map[nx][ny] == 1 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						q.offer(new Point(nx, ny));
						cnt++;
				}
			}
			
		}
		
		return cnt;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		
		q = new LinkedList<Point>();
		map = new int[n][n];
		visited = new boolean[n][n];
		village = new ArrayList<Integer>();
		
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(s.substring(j,j+1));
			}
		}
		
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					visited[i][j] = true;
					q.offer(new Point(i, j));
					village.add(bfs());
				}
			}
		
		// 오름차순 - naturalorder 내림차순 - reverseorder
		village.sort(Comparator.naturalOrder());
		sb.append(village.size() + "\n");
		for (int v : village)
			sb.append(v + "\n");
		System.out.println(sb);
	}

}
