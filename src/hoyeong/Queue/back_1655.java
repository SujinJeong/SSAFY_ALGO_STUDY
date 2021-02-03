package hoyeong.Queue;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class back_1655 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("txt.txt"));

		PriorityQueue<Integer> low_pq = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> high_pq = new PriorityQueue<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			if(i%2==0)
				low_pq.add(num);
			else
				high_pq.add(num);
			if (i>=1 &&low_pq.peek()>high_pq.peek()) {
				int save = low_pq.poll();
				low_pq.add(high_pq.poll());
				high_pq.add(save);
			}
			sb.append(low_pq.peek()).append("\n");
			}
		System.out.println(sb.toString());
		}
}
/*
7
1
5
2
10
-99
7
5
*/
