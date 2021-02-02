package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_15686 {
	public static int N, M;
	public static int[][] arr;
	public static ArrayList<Info> home = new ArrayList<>();
	public static ArrayList<Info> chicken = new ArrayList<>();
	public static boolean[] visit = new boolean[13];
	public static int minDistance = 987654321;

	static class Info {
		int x;
		int y;

		public Info(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static int getDistance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

	public static void calc(int idx, int cnt) {
		if (cnt == M) {
			int tmpDistance = 0;
			for (int i = 0; i < home.size(); ++i) {
				int tmp = 987654321;
				for (int j = 0; j < chicken.size(); ++j) {
					if (visit[j] == true) {
						tmp = Math.min(getDistance(chicken.get(j).x, chicken.get(j).y, 
								home.get(i).x, home.get(i).y), tmp);
					}
				}
				tmpDistance += tmp;
			}
			minDistance = Math.min(minDistance, tmpDistance);
			return;
		}
		for (int i = idx; i < chicken.size(); ++i) {
			if (visit[i])
				continue;
			visit[i] = true;
			calc(i, cnt + 1);
			visit[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1)
					home.add(new Info(i, j));
				else if (arr[i][j] == 2)
					chicken.add(new Info(i, j));
			}
		}
		calc(0, 0);
		System.out.println(minDistance);
	}
}
