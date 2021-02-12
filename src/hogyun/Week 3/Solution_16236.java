package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_16236 {
	static int N, sharkX, sharkY, sharkSize, sharkCnt, sharkTime;
	static int[][] arr;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static ArrayList<fishInfo> fishList = new ArrayList<>();
	static boolean[][] visited;

	static class targetInfo {
		int x, y, dist, idx;

		public targetInfo(int x, int y, int dist, int idx) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.idx = idx;
		}
	}

	static class fishInfo {
		int x, y, size;

		public fishInfo(int x, int y, int size) {
			this.x = x;
			this.y = y;
			this.size = size;
		}
	}

	static class sharkInfo {
		int x, y, time;

		public sharkInfo(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

	public static int getDistance(int x, int y, int x2, int y2) {
		return Math.abs(x - x2) + Math.abs(y - y2);
	}

	static Queue<targetInfo> pq = new PriorityQueue<targetInfo>(new Comparator<targetInfo>() {
		@Override
		public int compare(targetInfo a, targetInfo b) {
			if (a.dist == b.dist) {
				if (a.x == b.x)
					return a.y - b.y;
				return a.x - b.x;
			}
			return a.dist - b.dist;
		}
	});

	public static void bfs() {
		int targetIdx = 0;
		for (int i = 0; i < fishList.size(); ++i) {
			if (sharkSize > fishList.get(i).size) {
				int tmpDist = getDistance(sharkX, sharkY, fishList.get(i).x, fishList.get(i).y);
				pq.add(new targetInfo(fishList.get(i).x, fishList.get(i).y, tmpDist, i));
			}
		}
		if (pq.isEmpty()) { // 더이상 찾을 물고기가 없을 때 탈출
			return;
		}
		int targetSize = pq.size();
		int tmpX = 0;
		int tmpY = 0;
		boolean check = false;
		int tmpSharkTime = 987654321;
		for (int ts = 0; ts < targetSize; ++ts) {
			visited = new boolean[N][N];
			visited[sharkX][sharkY] = true;
			Queue<sharkInfo> q = new LinkedList<>();
			q.add(new sharkInfo(sharkX, sharkY, sharkTime));
			while (!q.isEmpty()) {
				int qSize = q.size();
				for (int s = 0; s < qSize; ++s) {
					int hx = q.peek().x;
					int hy = q.peek().y;
					int hT = q.peek().time;
					q.poll();
					for (int i = 0; i < 4; ++i) {
						int nx = hx + dx[i];
						int ny = hy + dy[i];
						if (nx < 0 || ny < 0 || nx >= N || ny >= N)
							continue;
						if (arr[nx][ny] > sharkSize)
							continue;
						if (arr[nx][ny] <= sharkSize && !visited[nx][ny]) {
							if (nx == pq.peek().x && ny == pq.peek().y) {
								if (tmpSharkTime > hT + 1) {
									tmpSharkTime = hT + 1;
									tmpX = nx;
									tmpY = ny;
									targetIdx = pq.peek().idx;
									check = true;
								}
							} else {
								visited[nx][ny] = true;
								q.add(new sharkInfo(nx, ny, hT + 1));
							}
						}
					}
				}
			}
			pq.poll();
		}
		if (check) {
			sharkX = tmpX;
			sharkY = tmpY;
			arr[sharkX][sharkY] = 0;
			fishList.remove(targetIdx);
			sharkTime = tmpSharkTime;
			sharkCnt++;
			if (sharkCnt == sharkSize) {
				sharkCnt = 0;
				sharkSize++;
			}
			bfs();
		} else
			return;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		sharkTime = 0;
		sharkCnt = 0;
		sharkSize = 2;
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] != 0 && arr[i][j] != 9) {
					fishList.add(new fishInfo(i, j, arr[i][j]));
				} else if (arr[i][j] == 9) {
					sharkX = i;
					sharkY = j;
				}
			}
		}
		arr[sharkX][sharkY] = 0;
		bfs();
		System.out.println(sharkTime);
	}
}
