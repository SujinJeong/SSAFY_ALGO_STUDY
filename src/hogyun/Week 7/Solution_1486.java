package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1486 {
	static int N, M, T, D;
	static int[][] arr;
	static int[][] goCost, arriveCost;
	static final int INF = 987654321;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	static class Info {
		int x, y;

		public Info(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void goBfs() {
		Queue<Info> q = new LinkedList<>();
		q.add(new Info(0, 0));
		goCost[0][0] = 0;
		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			q.poll();
			
			for (int i = 0; i < 4; ++i) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				if (Math.abs(arr[nx][ny] - arr[x][y]) > T)
					continue;
				if (arr[x][y] >= arr[nx][ny]) {
					if (goCost[x][y] + 1 > D)
						continue;
					if (goCost[nx][ny] == INF || goCost[nx][ny] > goCost[x][y] + 1) {
						goCost[nx][ny] = goCost[x][y] + 1;
						q.add(new Info(nx, ny));
					}
				} else {
					int nextCost = (int) (Math.pow(arr[nx][ny] - arr[x][y], 2) + goCost[x][y]);
					if (nextCost > D)
						continue;
					if (goCost[nx][ny] == INF || goCost[nx][ny] > nextCost) {
						goCost[nx][ny] = (int) nextCost;
						q.add(new Info(nx, ny));
					}
				}
			}
		}
	}

	public static void arriveBfs() {
		Queue<Info> q = new LinkedList<>();
		q.add(new Info(0, 0));
		arriveCost[0][0] = 0;
		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			q.poll();
			
			for (int i = 0; i < 4; ++i) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				if (Math.abs(arr[nx][ny] - arr[x][y]) > T)
					continue;
				if (arr[x][y] > arr[nx][ny]) {
					int nextCost = (int) (Math.pow(arr[nx][ny] - arr[x][y], 2) + arriveCost[x][y]);
					if (nextCost > D)
						continue;
					if (arriveCost[nx][ny] == INF || arriveCost[nx][ny] > nextCost) {
						arriveCost[nx][ny] = nextCost;
						q.add(new Info(nx, ny));
					}
				} else {
					if (arriveCost[x][y] + 1 > D)
						continue;
					if (arriveCost[nx][ny] == INF || arriveCost[nx][ny] > arriveCost[x][y] + 1) {
						arriveCost[nx][ny] = arriveCost[x][y] + 1;
						q.add(new Info(nx, ny));
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		goCost = new int[N][M];
		arriveCost = new int[N][M];
		for (int i = 0; i < N; ++i) {
			Arrays.fill(goCost[i], INF);
			Arrays.fill(arriveCost[i], INF);
		}
		for (int i = 0; i < N; ++i) {
			String str = br.readLine();
			for (int j = 0; j < M; ++j) {
				char tmp = str.charAt(j);
				if (tmp >= 'A' && tmp <= 'Z')
					arr[i][j] = tmp - 'A';
				else
					arr[i][j] = tmp - 'a' + 26;
			}
		}
		goBfs();
		arriveBfs();
		int maxHight = arr[0][0];
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (goCost[i][j] == INF || arriveCost[i][j] == INF)
					continue;
				if (goCost[i][j] + arriveCost[i][j] <= D) {
					maxHight = Math.max(maxHight, arr[i][j]);
				}
			}
		}
		System.out.println(maxHight);
	}
}
