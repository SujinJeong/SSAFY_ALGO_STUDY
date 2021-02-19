package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1461 {
	static int N, M, res;
	static PriorityQueue<Integer> positivePq = new PriorityQueue<>(Collections.reverseOrder());
	static PriorityQueue<Integer> negativePq = new PriorityQueue<>(Collections.reverseOrder());

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			int num = Integer.parseInt(st.nextToken());
			if (num < 0) {
				negativePq.add(-num);
			} else {
				positivePq.add(num);
			}
		}
		int last = 0;
		if (positivePq.isEmpty())
			last = negativePq.peek();
		
		else if (negativePq.isEmpty())
			last = positivePq.peek();
		
		else if (!positivePq.isEmpty() && !negativePq.isEmpty()) {
			if (positivePq.peek() > negativePq.peek())
				last = positivePq.peek();
			else if (positivePq.peek() < negativePq.peek())
				last = negativePq.peek();
			else {
				last = positivePq.peek();
			}
		}

		while (!positivePq.isEmpty()) {
			res += positivePq.peek() * 2;
			if (positivePq.size() >= M) {
				for (int i = 0; i < M; ++i) {
					positivePq.poll();
				}
			} else {
				positivePq.clear();
			}
		}

		while (!negativePq.isEmpty()) {
			res += negativePq.peek() * 2;
			if (negativePq.size() >= M) {
				for (int i = 0; i < M; ++i) {
					negativePq.poll();
				}
			} else {
				negativePq.clear();
			}
		}

		res -= last;
		System.out.println(res);
	}
}