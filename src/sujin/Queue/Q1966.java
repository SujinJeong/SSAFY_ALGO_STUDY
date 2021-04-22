package sujin.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q1966 {
	public static class Info implements Comparable<Info>{
		int idx, pri;

		public Info(int idx, int pri) {
			super();
			this.idx = idx;
			this.pri = pri;
		}

		@Override
		public int compareTo(Info o) {
			return o.pri - pri;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= tc; t++) {
			Queue<Info> q = new LinkedList<Info>();
			PriorityQueue<Info> pq = new PriorityQueue<>();

			String[] line = br.readLine().split(" ");
			int n = Integer.parseInt(line[0]);
			int m = Integer.parseInt(line[1]);

			line = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				q.offer(new Info(i, Integer.parseInt(line[i])));
				pq.offer(new Info(i, Integer.parseInt(line[i])));
			}

			// 몇번째로 출력할건지를 계산하기 위한 변수
			int cnt = 1;
			while (!q.isEmpty()) {

				Info i = q.poll();

				//System.out.println("현재 tc: " + t + ", 현재 최대값: " + pq.peek().pri);
				// 우선순위 높은거 빼주기
				if (pq.peek().pri == i.pri) {
					if (i.idx == m) sb.append(cnt + "\n");
					pq.poll();
					cnt++;
				}
				else {
					q.offer(i);
				}

			}
			// end of tc
		}

		System.out.println(sb);

	}

}
