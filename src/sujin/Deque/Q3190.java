package sujin.Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q3190 {
	
	// 좌하우상
	private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};
    private static int[][] map;
	private static Map<Integer, String> direction;
	
	public static class Pos {
		int x, y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	public static void solve( ) {
		Deque<Pos> snake = new ArrayDeque<Pos>();
		// 1,1에서 시작
		snake.add(new Pos(1, 1));
		
		int time = 0;
		int dir = 2;
		
		while (true) {
			// 1초 지날때마다
			time++;
			
			// 일단 머리 한번 위치시켜보기
			Pos head = snake.peekLast();
			
			// 만약 이동한 칸에 사과가 있다면, 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않는다.
			int nx = head.x + dx[dir];
			int ny = head.y + dy[dir];
			
			// 벽 만나거나 자기 자신의 몸 만나면 종료
			if (map[nx][ny] == 1) break;
			
			// 사과가 있음
			if (map[nx][ny] == 2) {
				map[nx][ny] = 0;
			}
			// 사과가 없음
			else {
				Pos tail = snake.pollFirst();
				// 꼬리가 위치한 칸 비워주기
				map[tail.x][tail.y] = 0;
			}
			
			// 조건 만족해줬으니 head 설정
			snake.addLast(new Pos(nx, ny));
			map[nx][ny] =1 ;
			
			// 방향을 바꿔야할 시간이 된다면
			if (direction.containsKey(time)) {
				// 왼쪽으로 90도
				if (direction.get(time).equals("L")) dir = (dir+1)%4;
				else dir = (dir+3)%4;
			}
		}
		
		System.out.println(time);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		direction = new HashMap<Integer, String>();
		
		int n = Integer.parseInt(br.readLine());
		map = new int[n+2][n+2];
		
		int k = Integer.parseInt(br.readLine());
		
		// 벽 설정
		for (int i = 0; i < n+2; i++) {
			map[0][i] = 1;
			map[i][0] = 1;
			map[n+1][i] = 1;
			map[i][n+1] = 1;
		}
		
		
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			// 사과가 위치한 곳은 2로
			map[x][y] = 2;
		}
		
		int l = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			direction.put(time, dir);
		}
		
		solve();
		
	}

}
