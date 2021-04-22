package sujin.BitMasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
1. 비트마스킹 서쪽/북쪽/동쪽/남쪽 순서
2. &연산자로 벽뚫 0인경우로 dfs -> 크기계산 2번구함
3. dfs에 몇번들어가는지에 따라 1번구함
4. 3번 비트연산 1일때 0 으로 바꿔주면서 다시 bfs 돌아서 max 갱신
 */
public class Q2234 {
	static int[][] map;
	static int room_cnt, max = Integer.MIN_VALUE;
	static int n, m;
	static boolean[][] visited;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static int bfs(Point p) {

		Queue<Point> q = new LinkedList<Point>();
		q.offer(p);
		visited[p.x][p.y] = true;

		int size = 1;

		while (!q.isEmpty()) {
			Point curr = q.poll();
			int x = curr.x;
			int y = curr.y;

			for (int i = 0, bit = 1; i < 4; i++, bit <<= 1) {
				if ((map[x][y] & bit) == 0) { // 벽이 뚫려있는경우
					int nx = x + dx[i];
					int ny = y + dy[i];

					// 유효성검사
					if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny])
						continue;

					visited[nx][ny] = true;
					q.offer(new Point(nx, ny));
					size++;
				}
			}
		}
		// 최대방넓이 구하기 위해
		return size;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] line = br.readLine().split(" ");
		n = Integer.parseInt(line[1]);
		m = Integer.parseInt(line[0]);

		map = new int[n][m];
		visited = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			String[] line2 = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(line2[j]);
			}
		}

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++) {
				if (!visited[i][j]) {
					visited[i][j] = true;
					max = Math.max(max, bfs(new Point(i, j)));
					room_cnt++;
				}
			}

		sb.append(room_cnt + "\n");
		sb.append(max + "\n");

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++) {
				for (int b = 1; b <= 8; b <<= 1) {
					if ((map[i][j] & b) == b) { // 해당 자리가 1일 때 0으로: 벽 하나씩 뚫어보기
						visited = new boolean[n][m];
						map[i][j] -= b;
						max = Math.max(max, bfs(new Point(i, j)));
						map[i][j] += b;
					}
				}
				
			}
		
		sb.append(max + "\n");

		System.out.println(sb);
	}

}
