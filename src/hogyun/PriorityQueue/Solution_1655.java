package hogyun.PriorityQueue;

import java.util.*;
import java.io.*;

public class Solution_1655 {
	public static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Queue<Integer> maxPq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return b - a;
			}
		});

		Queue<Integer> minPq = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return a - b;
			}
		});
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; ++i) {
			int num = Integer.parseInt(br.readLine());
			if (maxPq.size() == minPq.size())
				maxPq.offer(num);
			else
				minPq.offer(num);
			
			if(!maxPq.isEmpty() && !minPq.isEmpty()) {
				if (maxPq.peek() > minPq.peek()) {
					int tmp = minPq.poll();
					minPq.offer(maxPq.poll());
					maxPq.offer(tmp);
				}
			}
			sb.append(maxPq.peek() +"\n");
		}
		System.out.println(sb.toString());
	}
}
