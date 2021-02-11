package sujin.Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Q17391 {

	static int n, m;
	static int map[][];
	static boolean[][] visited;
	static int[] dy = {1, 0};
	static int[] dx = {0, 1};
	
	public static class Cart {
		int x;
		int y;
		int val;
		
		public Cart(int x, int y, int val) {
			super();
			this.x = x;
			this.y = y;
			this.val = val;
		}
		
	}
	
	public static int bfs() {
		Queue<Cart> q = new LinkedList<>();
		
		// Cart 내에 val은 현재 몇번째 방문한 격자인지 저장
		q.offer(new Cart(0, 0, 0));
		visited[0][0] = true;
		
		
		while(!q.isEmpty()) {
			Cart c = q.poll();
			int x = c.x;
			int y = c.y;
			int val = c.val;
			
			// 끝까지 왔으므로 종료
			if (x == n-1 && y == m-1) return val;
			
			for (int i = 0; i < 2; i++) {
				// map[x][y]의 값만큼 반복해서 움직이기 1부터~해당값까지 다해봐야함!
				for (int j = 1; j <= map[x][y]; j++) {
					int nx = x + dx[i] * j;
					int ny = y + dy[i] * j;
					
					if (nx < n && nx >= 0 && ny < m && ny >= 0 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						q.offer(new Cart(nx, ny, val+1));
					}
					
				}
			}
		}
		
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String[] line = br.readLine().split(" ");
			n = Integer.parseInt(line[0]);
			m = Integer.parseInt(line[1]);
			
			map = new int[n][m];
			for (int i = 0; i < n; i++) {
				String[] line2 = br.readLine().split(" ");
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(line2[j]);
				}
			}
			
			visited = new boolean[n][m];
			
			System.out.println(bfs());
	}

}
