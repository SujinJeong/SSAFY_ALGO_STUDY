package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1966 {
	public static int TC;
	public static int[] res;

	static class Info {
		int index;
		int importance;

		public Info(int index, int importance) {
			super();
			this.index = index;
			this.importance = importance;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		res = new int[TC];

		for (int t = 0; t < TC; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			ArrayList<Integer> list = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			Queue<Info> q = new LinkedList<Info>();
			for (int i = 0; i < N; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());
				list.add(arr[i]);
				q.offer(new Info(i, arr[i]));
			}
			list.sort(Comparator.reverseOrder()); // 우선순위 내림차순으로 정렬
			int idx = 0;
			int cnt = 1;

			while (true) {
				if (q.peek().importance == list.get(idx)) {
					if (q.peek().index == M) {
						res[t] = cnt;
						break;
					} else {
						cnt++;					
						idx++;
						q.poll();
					}
				} else {
					q.add(q.peek());
					q.poll();
				}
			}
		}
		for (int i = 0; i < TC; ++i)
			System.out.println(res[i]);
	}
}
