package sujin.Week7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Q1865 {
	static int dist[];
	static int n, m, w;
	static Node[] node;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static class Node {
		int start, end, time;

		public Node(int start, int end, int time) {
			super();
			this.start = start;
			this.end = end;
			this.time = time;
		}

	}

	// 1부터 시작하면 inf인지 검사를 안해야하는 이유 https://steady-coding.tistory.com/91
	public static boolean bellmanFord() {
		// 시작점 1번 노드로
		dist[1] = 0;
		boolean update = false;

		// v-1(정점의 개수 - 1)번 수행, 횟수만을 위한 for문
		for (int v = 1; v < n; v++) {
			update = false;
			
			// 모든 정점에서 출발할때는 node.length까지 반복해서 출발점으로 돌아왔을때 또 갱신이 일어나면 음의사이클이라는것
			for (int i = 0; i < node.length; i++) {
				Node n = node[i];

				// 모든 정점 검사할 경우 dist[n.start] != INF 추가
				// 출발점이 infinite 값이 아니고 dp값보다 현재 계산값이 더 작을 때 더 작은 최단거리 갱신
				if (dist[n.end] > dist[n.start] + n.time) {
					dist[n.end] = dist[n.start] + n.time;
					// 갱신이 이루어졌을때
					update = true;
				}
			}
			
			// 간선에 대한 모든 정보를 조사했는데 더이상 최단거리 갱신이 이루어지지 않는다면 음수사이클 X
			if (!update)
				return false;
		}
		return true;
	}

	public static void input() throws IOException {

		String[] line = br.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		w = Integer.parseInt(line[2]);

		// 양방향 그래프이므로 2*m
		node = new Node[2 * m + w];
		dist = new int[n + 1];

		// 최단거리 inf 값 넣어주기
		Arrays.fill(dist, 987654321);

		int idx = 0;
		// 웜홀 정보 input
		for (int i = 0; i < m + w; i++) {
			line = br.readLine().split(" ");
			int s = Integer.parseInt(line[0]);
			int e = Integer.parseInt(line[1]);
			int t = Integer.parseInt(line[2]);

			// 도로는 양쪽방향이기 때문에 양방향 모두 추가
			if (i < m) {
				node[idx++] = new Node(s, e, t);
				node[idx++] = new Node(e, s, t);
				// 웜홀 한방향이므로 -만 붙여주기
			} else {
				node[idx++] = new Node(s, e, -t);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		while (tc-- > 0) {
			input();
			// 음수사이클이 있는 경우 YES append
			if (bellmanFord())
				sb.append("YES\n");
			else
				sb.append("NO\n");
		}

		bw.write(String.valueOf(sb));
		bw.flush();
		
	}

}
