package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_10473 {
	static double startX, startY, endX, endY;
	static int N;
	static final int INF = 987654321;
	static double[] cost;
	static ArrayList<Info>[] arr;

	static double getDist(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
	}

	static class Info implements Comparable<Info> {
		double x, y, time;
		int num;

		public Info(int num, double x, double y, double time) {
			super();
			this.num = num;
			this.x = x;
			this.y = y;
			this.time = time;
		}

		@Override
		public int compareTo(Info a) {
			return (int) (time - a.time);
		}
	}

	public static void bfs() {
		PriorityQueue<Info> pq = new PriorityQueue<>();
		pq.add(new Info(0, startX, startY, 0.0));
		cost[0] = 0.0;
		while (!pq.isEmpty()) {
			Info now = pq.poll();
			if (cost[now.num] < now.time)
				continue;
			for (int i = 0; i < arr[now.num].size(); ++i) {
				int next = arr[now.num].get(i).num;
				double nextCost = arr[now.num].get(i).time;
				if (cost[next] > nextCost + cost[now.num]) {
					cost[next] = nextCost + cost[now.num];
					pq.add(new Info(next, 0, 0, cost[next]));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		startX = Double.parseDouble(st.nextToken());
		startY = Double.parseDouble(st.nextToken());
		st = new StringTokenizer(br.readLine());
		endX = Double.parseDouble(st.nextToken());
		endY = Double.parseDouble(st.nextToken());
		N = Integer.parseInt(br.readLine());
		cost = new double[N + 2];
		Arrays.fill(cost, INF);
		arr = new ArrayList[N + 2];
		for (int i = 0; i < N + 2; ++i)
			arr[i] = new ArrayList<Info>();
		arr[0].add(new Info(N + 1, endX, endY, getDist(startX, startY, endX, endY) / 5.0));
		ArrayList<Info> tmp = new ArrayList<>();
		tmp.add(new Info(0, startX, startY, 0));
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			tmp.add(new Info(i + 1, x, y, 0));
			arr[0].add(new Info(i + 1, x, y, getDist(startX, startY, x, y) / 5.0));
		}
		for (int i = 1; i <= N; ++i) {
			arr[i].add(new Info(N + 1, 0, 0, getDist(tmp.get(i).x, tmp.get(i).y, endX, endY) / 5.0));
			arr[i].add(
					new Info(N + 1, 0, 0, Math.abs(getDist(tmp.get(i).x, tmp.get(i).y, endX, endY) - 50) / 5.0 + 2.0));
		}
		for (int i = 1; i <= N; ++i) {
			for (int j = 1; j <= N; ++j) {
				if (i == j)
					continue;
				double distTmp = getDist(tmp.get(i).x, tmp.get(i).y, tmp.get(j).x, tmp.get(j).y);
				arr[i].add(new Info(j, 0, 0, distTmp / 5.0));
				arr[i].add(new Info(j, 0, 0, Math.abs(distTmp - 50) / 5.0 + 2.0));
			}
		}
		bfs();
		System.out.println(cost[N + 1]);
	}
}
