package study_0125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_11286 {
	static int N;
	static PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			if(Math.abs(o1) == Math.abs(o2)) {
				return o1 - o2;
			}
			return Math.abs(o1) - Math.abs(o2);
		}
	});

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int op = Integer.parseInt(br.readLine());
			if (op == 0) {
				if (pq.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(pq.poll());
				}
			} else {
				pq.add(op);
			}
		}
	}
}

