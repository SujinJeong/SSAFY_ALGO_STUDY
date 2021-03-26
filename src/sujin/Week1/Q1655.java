package sujin.Week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Q1655 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 가장 작은 값이 poll
		PriorityQueue<Integer> min = new PriorityQueue<>(); 
		// 가장 큰 값이 poll
		PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			// 하나씩 담아주기
			if (i % 2 == 1) min.add(n);
			else max.add(n);
			
			// 만약 min값이 max값보다 큰 경우 대소관계가 꼬임
			if (min.size() !=0 && max.size() != 0 && min.peek() < max.peek()) {
				int tmp = min.poll();
				min.offer(max.poll());
				max.offer(tmp);
			}
			
			// 둘중 작은값
			sb.append(max.peek()+"\n");
		}
		
		bw.write(String.valueOf(sb));
		bw.flush();
	}
}
