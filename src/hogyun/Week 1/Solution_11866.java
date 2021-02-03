package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_11866 {
	public static int N, K;
	public static int[] res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		res = new int[N];

		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; ++i)
			q.add(i);
		int idx = 0;	
		while (!q.isEmpty()) {
			for (int i = 0; i < K - 1; ++i) {
				q.add(q.peek());
				q.poll();
			}
			res[idx++] = q.peek();
			q.poll();
		}
		System.out.print("<");
		for (int i = 0; i < res.length; ++i) {
			if (i == res.length - 1)
				System.out.print(res[i] + ">");
			else
				System.out.print(res[i] + ", ");
		}
	}
}
