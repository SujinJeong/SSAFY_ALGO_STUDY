package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_2617 {
	public static int N, M;
	public static ArrayList<Integer> list[], list2[];
	public static boolean[] visited;

	public static int dfsMax(int num) {
		int maxCnt = 1;
		for (int i = 0; i < list[num].size(); ++i) {
			int tmp = list[num].get(i);
			if (!visited[tmp]) {
				visited[tmp] = true;
				maxCnt += dfsMax(tmp);
			}
		}
		return maxCnt;
	}

	public static int dfsMin(int num) {
		int minCnt = 1;
		for (int i = 0; i < list2[num].size(); ++i) {
			int tmp = list2[num].get(i);
			if (!visited[tmp]) {
				visited[tmp] = true;
				minCnt += dfsMin(tmp);
			}
		}
		return minCnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		list2 = new ArrayList[N + 1];
		for (int i = 1; i <= N; ++i) {
			list[i] = new ArrayList<Integer>();
			list2[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list2[b].add(a);
		}
		int half = N / 2 + 1;
		int res = 0;
		for (int i = 1; i <= N; ++i) {
			visited = new boolean[N + 1];
			if (dfsMax(i) > half)
				res++;
			visited = new boolean[N + 1];
			if (dfsMin(i) > half)
				res++;
		}
		System.out.println(res);
	}
}
