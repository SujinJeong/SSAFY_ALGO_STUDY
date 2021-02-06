package sujin.Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
1. 첫번째 찾은 1(익은토마토) 기준으로 너비우선탐색
2. 0일 경우 큐에 추가 (익어야하는 경우 모두 계산하기 위해)
3. 익은 토마토 값 = 이전에 익은 토마토값 +1 => 총 일수 계산을 위해서
4. 만약 최대값이 -1이면 익지 않은 토마토가 있음, 최대값이 0이라면 원래부터 익어있었음, 아닐 경우 총일수
 */

public class Q7576 {

	static public int[] dy = { -1, 1, 0, 0 };
	static public int[] dx = { 0, 0, -1, 1 };
	static int min_day = Integer.MIN_VALUE;
	static Queue<Location> q = new LinkedList<Location>();;
	static int N, M;
	static int[][] map;
	
	// 1(익은 토마토) 위치 저장을 위한 객체
	static class Location {
		public int x;
		public int y;
		
		public Location(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	static int bfs() {
		while (!q.isEmpty()) {
			Location l = q.poll();
			int cx = l.x;
			int cy = l.y;
			for (int i = 0; i < 4; i++) {
				int ny = cy + dy[i];
				int nx = cx + dx[i];
				// 탐색할 위치가 범위 내에 있고 안익은 토마토면
				if (nx < N && nx >= 0 && ny < M && ny >=0 )
					if (map[nx][ny] == 0) {
						q.offer(new Location(nx, ny));
						map[nx][ny] = map[cx][cy] + 1;
					}
			}
		}
		
		
		// 일수 계산
		for (int x = 0; x < N; x++)
			for (int y = 0; y < M; y++) {
				// bfs를 마쳤으나 안익은 토마토가 있는 경우
				if (map[x][y] == 0) return -1;
				// 정상적인 경우 최소 일수 구하기
				min_day = Math.max(min_day, map[x][y]);
			}
		
		// 토마토가 이미 익어있던 경우에는 -1과 1으로만 이루어져 있으므로
		if (min_day == 1) return 0;
		// 처음에 1부터 더했으니까 -1해주기
		return min_day-1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		// input
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 첫번째 index 기준으로 탐색 시작
				if (map[i][j] == 1) q.offer(new Location(i, j));
			}
		}
		
		// output
		System.out.println(bfs());
	}

}
