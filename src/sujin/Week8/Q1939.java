package sujin.Week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q1939 {
	static int from, to, n, m;
	static ArrayList<Edge>[] arr;
	
	public static class Edge {
		int dest, weight;

		public Edge(int dest, int weight) {
			super();
			this.dest = dest;
			this.weight = weight;
		}
		
	}
	
	public static boolean solve(int num) {
		boolean[] visited = new boolean[n+1];
		Queue<Integer> q = new LinkedList<Integer>();
		
		visited[from] = true;
		q.offer(from);
		
		while (!q.isEmpty()) {
			int dest = q.poll();
			
			if (dest == to) {
				// 도착점까지 경로 찾았으므로
				return true;
			}
			
			// dest 이랑 연결된 간선들 검사
			for (Edge next : arr[dest]) {
				// 방문하지 않았고 중량이 더 큰 경우
				if (!visited[next.dest] && num <= next.weight) {
					visited[next.dest] = true;
					q.offer(next.dest);
				}
			}
		}
		return false;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");

		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		arr = new ArrayList[n+1];
		
		for (int i = 1; i <= n; i++) {
			arr[i] = new ArrayList<>();
		}
		
		int low = Integer.MAX_VALUE;
		int high = Integer.MIN_VALUE;
		
		for (int i = 0; i < m; i++) {
			line = br.readLine().split(" ");
			int a = Integer.parseInt(line[0]);
			int b = Integer.parseInt(line[1]);
			int c = Integer.parseInt(line[2]);
			
			low = Math.min(low, c);
			high = Math.max(high, c);
			
			// 양방향이기 떄문에 양쪽으로
			arr[a].add(new Edge(b, c));
			arr[b].add(new Edge(a, c));
		}
		
		// 공장이 위치해 있는 섬의 번호
		line = br.readLine().split(" ");
		from = Integer.parseInt(line[0]);
		to = Integer.parseInt(line[1]);
		
		// 중간값 찾을때까지
		while (low <= high) {
			int mid = (low+high)/2;
			// from -> to 경로 찾았으므로 더 큰 중량 탐색
			if (solve(mid)) {
				low = mid + 1;
			}
			// from -> to 경로 못찾았으므로 더 작은 중량 탐색
			else {
				high = mid -1;
			}
		}
		
		// 한번의 이동에서 옮길 수 있는 물품들의 중량의 최대값
		System.out.println(high);

	}

}
