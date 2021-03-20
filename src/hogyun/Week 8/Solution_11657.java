package solve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_11657 {
	static int N, M;
	static final long INF = Long.MAX_VALUE;
	static long[] cost;
	static ArrayList<Info>[] arr;

	static class Info {
		int end, time;

		public Info(int end, int time) {
			super();
			this.end = end;
			this.time = time;
		}
	}

	public static void bellman() {
		boolean isCycle = false;
		cost[1] = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = 1; j <= N; ++j) {
				for (int k = 0; k < arr[j].size(); ++k) {
					int next = arr[j].get(k).end;
					int nextCost = arr[j].get(k).time;
					if (cost[j] != INF && cost[next] > cost[j] + nextCost) {
						cost[next] = cost[j] + nextCost;
						if (i == N - 1)
							isCycle = true;
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		if (isCycle) {
			System.out.println("-1");
			System.exit(0);
		} else {
			for (int i = 2; i <= N; ++i) {
				if (cost[i] == INF)
					cost[i] = -1;
				sb.append(cost[i] + "\n");
			}
			System.out.println(sb);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N + 1];
		cost = new long[N + 1];
		Arrays.fill(cost, INF);
		for (int i = 0; i < N + 1; ++i)
			arr[i] = new ArrayList<>();
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			arr[A].add(new Info(B, C));
		}
		bellman();
	}
}
