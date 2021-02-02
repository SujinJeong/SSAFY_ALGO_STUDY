package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_3190 {
	public static int N, K, L;
	public static int[][] arr;
	public static int[] dx = { 0, 1, 0, -1 };
	public static int[] dy = { 1, 0, -1, 0 };
	public static Queue<Info> q = new LinkedList<Info>();
	public static Queue<sInfo> sq = new LinkedList<sInfo>();

	static class Info {
		int seconds;
		char dir;

		public Info(int seconds, char dir) {
			super();
			this.seconds = seconds;
			this.dir = dir;
		}
	}

	static class sInfo {
		int x;
		int y;

		public sInfo(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static int getSecond(int x, int y, int d) {
		int time = 0;
		arr[x][y] = 1;
		sq.offer(new sInfo(x, y));

		while (true) {
			time++;
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx < 0 || ny < 0 || nx >= N || ny >= N) // 벽 부딪히는 경우
				break;

			if (arr[nx][ny] == -1) {// 사과 먹는 경우
				arr[nx][ny] = 1;
			} else if (arr[nx][ny] == 0) {
				arr[nx][ny] = 1;
				sInfo tmp = sq.poll();
				arr[tmp.x][tmp.y] = 0;
			} else if (arr[nx][ny] == 1) {// 뱀의 몸통에 닿는 경우
				break;
			}
			sq.offer(new sInfo(nx, ny));
			x = nx;
			y = ny;
			if (!q.isEmpty()) { //이 조건문이 없으면 NullPointException이 발생한다.
				if (time == q.peek().seconds) { //비교해줄 때 q가 비어있을 수도 있어서
					if (q.peek().dir == 'D') {
						if (d == 3)
							d = 0; // d %= 4; 이렇게 하면 코드가 더 간결해진다.
						else
							d++;
					} else {
						if (d == 0)
							d = 3;
						else
							d--;
					}
					q.poll();
				}
			}
		}
		return time;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < K; ++i) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x - 1][y - 1] = -1; // 사과 위치 -1 저장
		}
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		for (int i = 0; i < L; ++i) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			String tmp = st.nextToken();
			char dir = tmp.charAt(0);
			q.offer(new Info(time, dir)); // queue에 시간, 방향 저장
		}
		System.out.println(getSecond(0, 0, 0));
		br.close();
	}
}
