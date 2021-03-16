package study_0309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11779 {
	static final int INF = 987654321;
	static int n, m, s, e;
	static ArrayList<ArrayList<Info>> graph;
	static int[] d, trace;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		graph = new ArrayList<ArrayList<Info>>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Info>());
		}
		trace = new int[n + 1];
		d = new int[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph.get(u).add(new Info(w, v));
		}
		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());

		dijk();
		System.out.println(sb);
	}

	private static void dijk() {
		for (int i = 1; i <= n; i++) {
			d[i] = INF;
		}
		d[s] = 0;
		PriorityQueue<Info> pq = new PriorityQueue<>();
		pq.offer(new Info(d[s], s));
		while (!pq.isEmpty()) {
			Info temp = pq.poll();

			if (temp.cost > d[temp.node]) { continue; }
			
			for (int i = 0; i < graph.get(temp.node).size(); i++) {
				int next = graph.get(temp.node).get(i).node;
				if (d[next] > d[temp.node] + graph.get(temp.node).get(i).cost) {
					trace[next] = temp.node;
					d[next] = d[temp.node] + graph.get(temp.node).get(i).cost;
					pq.offer(new Info(d[next], next));
				}
			}
		}
		sb.append(d[e] + "\n");
		int temp = e;
		ArrayList<Integer> ans = new ArrayList<>();
		while(temp != 0) {
			ans.add(temp);
			temp = trace[temp];
		}
		sb.append(ans.size() + "\n");
		for(int i = ans.size() - 1; i >=0; i--) {
			sb.append(ans.get(i) + " ");
		}
	}

	static class Info implements Comparable<Info> {
		int cost;
		int node;

		public Info(int cost, int node) {
			super();
			this.cost = cost;
			this.node = node;
		}

		@Override
		public int compareTo(Info o) {
			return cost - o.cost;
		}

	}
}
