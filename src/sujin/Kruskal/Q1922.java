package sujin.Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1922 {
	static int[] parent;

	static class Info implements Comparable<Info> {
		int start, end, weight;

		public Info(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Info o) {
			return this.weight - o.weight;
		}

	}

	public static int getParent(int x) {
		if (parent[x] == x)
			return x;

		return parent[x] = getParent(parent[x]);
	}

	public static void unionFind(int x, int y) {
		int p1 = getParent(x);
		int p2 = getParent(y);

		if (p1 < p2) { // 부모가 다를 떄 연결
			parent[p2] = p1;
		} else {
			parent[p1] = p2;
		}
	}

	public static boolean findParent(int x, int y) {
		int p1 = getParent(x);
		int p2 = getParent(y);

		if (p1 == p2) { // 부모가 다를 떄 연결
			return true;
		} else
			return false;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PriorityQueue<Info> pq = new PriorityQueue<>();

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		parent = new int[n + 1];

		// 초기화
		for (int i = 0; i <= n; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			pq.add(new Info(start, end, weight));
		}

		// 최소 비용 찾기
		
		int rslt = 0;
		while (!pq.isEmpty()) {
			Info i = pq.poll();
			
			// 같은부모면 이미 계산 되었음
			if (findParent(i.start, i.end))
				continue;
			else {
				unionFind(i.start, i.end);
				rslt += i.weight;
			}
		}
		
		System.out.println(rslt);

	}

}
