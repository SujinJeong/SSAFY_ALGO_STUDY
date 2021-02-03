package heap;

import java.io.*;
import java.util.*;

public class Solution_11286 {
	public static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				int res = (Math.abs(a) == Math.abs(b)) ? a - b : Math.abs(a) - Math.abs(b);
				return res;
			}
		});
		Queue<Integer> q = new LinkedList<>();
		int zeroCnt = 0;
		for (int i = 0; i < N; ++i) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				zeroCnt++;
				if(!pq.isEmpty())
					q.add(pq.poll());
				else
					q.add(0);
			}else
				pq.offer(num);
		}
		for(int i=0; i<zeroCnt; ++i) {
			System.out.println(q.poll());
		}
	}
}
