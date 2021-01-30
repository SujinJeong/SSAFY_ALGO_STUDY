package study_0125;

import java.io.*;
import java.util.*;

public class BOJ_1655 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int val = Integer.parseInt(br.readLine());
			if (i % 2 == 0) {
				maxHeap.offer(val);
			} else {
				minHeap.offer(val);
			}
			if (i >=1 && minHeap.peek() < maxHeap.peek()) {
				int temp = minHeap.poll();
				minHeap.offer(maxHeap.poll());
				maxHeap.offer(temp);
			}
			sb.append(maxHeap.peek()).append("\n");
		}
		System.out.println(sb.toString());
	}
}