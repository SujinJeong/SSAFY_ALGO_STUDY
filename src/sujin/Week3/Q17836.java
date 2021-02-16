package sujin.Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
1. 객체에 x, y, 시간, sword 갖고있는지 저장
2. dfs 수행~
	if (공주 만났으면 시간 return)
	for (4방향 움직이기)
		 if(유효성검사, sword 아직 못가졌을때)
		 	if (벽이 아니고, 방문하지 않았을때)
		 		visit[0]좌표 true
		 		if (만약 sword면)
		 		else sword 아님
		 else ( 유효성검사, sword 있을떄 visit[1]좌표 true
		 
 */
public class Q17836 {
	static int n, m, limit, rslt;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dy = {1, 0, -1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	public static class Prince {
		int x, y, time;
		boolean sword;

		public Prince(int x, int y, int time, boolean sword) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
			this.sword = sword;
		}
		
		
	}
	public static void bfs() {
		Queue<Prince> q = new LinkedList<Prince>();
		visited[0][0][0] = true;
		q.offer(new Prince(0, 0, 0, false));
		
		while (!q.isEmpty()) {
			Prince p = q.poll();
			
			if (p.x == n-1 && p.y == m-1) {
				rslt = p.time;
				break;
			}
			
			if (map[p.x][p.y] == 2)
				p.sword = true;
			
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
					// sword 없을때
					if (!p.sword) {
							// 벽, 방문 둘다 고려
							if (!visited[0][nx][ny] && map[nx][ny] != 1) {
								visited[0][nx][ny] = true;
								q.offer(new Prince(nx, ny, p.time+1, p.sword));
							}
					}
					// sword 있을때
					else {
						// 검 있으므로 방문만 고려
						if (!visited[1][nx][ny]) {
							visited[1][nx][ny] = true;
							q.offer(new Prince(nx, ny, p.time+1, p.sword));
						}
					}
				}
			}
			
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		limit = Integer.parseInt(line[2]);
		map = new int[n][m];
		visited = new boolean[2][n][m];
		
		for (int i = 0; i < n; i++) {
			String[] line2 = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(line2[j]);
			}
		}
		
		bfs();
		if (0 < rslt && rslt <= limit) System.out.println(rslt);
		else System.out.println("Fail");
	}

}
