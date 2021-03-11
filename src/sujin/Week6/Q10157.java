package sujin.Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q10157 {
	static int r, c, num;
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static class Info {
		int x,y, cnt;

		public Info(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
	}
	public static void bfs() {
		Queue<Info> q = new LinkedList<Info>();
		boolean[][] visited = new boolean[r][c];
		
		q.offer(new Info(0, 0, 1));
		visited[0][0] = true;
		int d = 0;
		
		while(!q.isEmpty()) {
			
			Info i = q.poll();
			
			if (i.cnt == num) {
				System.out.println((i.y+1) + " " + (i.x+1));
				return;
			}
			int nx = i.x + dr[d];
			int ny = i.y + dc[d];
			
			if (nx < r && nx >=0 && ny < c && ny >=0 && !visited[nx][ny]) {
					q.offer(new Info(nx, ny, i.cnt+1));
					visited[nx][ny] = true;
			}
			else  {
				d = (d+1) % 4;
				nx = i.x + dr[d];
				ny = i.y + dc[d];
				q.offer(new Info(nx, ny, i.cnt+1));
				visited[nx][ny] = true;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		c = Integer.parseInt(line[0]);
		r = Integer.parseInt(line[1]);
		
		num = Integer.parseInt(br.readLine());
		
		if (r*c < num)
			System.out.println(0);
		else bfs();
	}

}
