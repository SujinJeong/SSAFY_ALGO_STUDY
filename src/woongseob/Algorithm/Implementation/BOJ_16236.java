package study_0208;

import java.io.*;
import java.util.*;

public class BOJ_16236 {
	static int N, sharkY, sharkX, sharkSize = 2, res, needToEat;
	static int[][] arr;
	static boolean[][] visit;
	static int[] dy = { 1, 0, -1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static PriorityQueue<FISH> pq = new PriorityQueue<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 9) {
					arr[i][j] = 0;
					sharkY = i;
					sharkX = j;
				}
			}
		}
		// 풀이
		while (true) {
			// 먹잇감을 넣기 위한 bfs
			bfs(sharkY, sharkX);
			// 먹잇감이 없으면
			if (pq.isEmpty()) {
				System.out.println(res);
				break;
			}
			sharkY = pq.peek().y;
			sharkX = pq.peek().x;
			res += pq.peek().dist;
			// 첫 먹이 먹고 그 후 필요 없으므로 pq값 비우기
			pq.clear();
			visit = new boolean[N][N];
			arr[sharkY][sharkX] = 0;
			needToEat++;
			// 아기상어가 커질수 있는지 확인
			if (needToEat == sharkSize) {
				sharkSize++;
				needToEat = 0;
			}
		}
	}

	static class FISH implements Comparable<FISH> {
		int y;
		int x;
		int dist;

		public FISH(int y, int x, int dist) {
			super();
			this.y = y;
			this.x = x;
			this.dist = dist;
		}

		public int compareTo(FISH o) {
			// 거리가 더 작은 순
			if (this.dist < o.dist) {
				return -1;
			} else if (this.dist == o.dist) {
				// 위쪽 좌표가 더 작은 순
				if (this.y < o.y) {
					return -1;
				} else if (this.y == o.y) {
					// 왼쪽 좌표가 더 작은 순
					if (this.x < o.x) {
						return -1;
					} else if (this.x == o.x) {
						return 0;
					} else {
						return 1;
					}
				} else {
					return 1;
				}
			} else {
				return 1;
			}
		}
	}

	private static void bfs(int y, int x) {
		Queue<FISH> q = new LinkedList<FISH>();
		q.offer(new FISH(y, x, 0));
		visit[y][x] = true;
		while (!q.isEmpty()) {
			FISH temp = q.poll();
			// 먹잇감 집어넣기
			if (arr[temp.y][temp.x] != 0 && arr[temp.y][temp.x] < sharkSize) {
				pq.offer(new FISH(temp.y, temp.x, temp.dist));
			}
			for (int i = 0; i < 4; i++) {
				int ny = temp.y + dy[i], nx = temp.x + dx[i];
				if (ny < 0 || nx < 0 || ny >= N || nx >= N) {
					continue;
				}
				if (arr[ny][nx] <= sharkSize && !visit[ny][nx]) {
					visit[ny][nx] = true;
					q.offer(new FISH(ny, nx, temp.dist + 1));
				}
			}
		}
	}
}
