package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2980 {
	static int N, L;
	static Queue<Info> q = new LinkedList<>();

	static class Info {
		int D, R, G;

		public Info(int d, int r, int g) {
			super();
			D = d;
			R = r;
			G = g;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			int D = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int G = Integer.parseInt(st.nextToken());
			q.add(new Info(D, R, G));
		}
		int start = q.peek().D;
		int t = 0;
		int dist = 0;
		while (true) {
			if (dist == L)
				break;
			if (dist != start) {
				t++;
				dist++;
			} else {
				int tmp = q.peek().R + q.peek().G;
				if (t % tmp < q.peek().R) {
					t++;
					continue;
				} else if (t % tmp < q.peek().R + q.peek().G) {
					q.poll();
					if (q.size() >= 1)
						start = q.peek().D;
					t++;
					dist++;
				}
			}
		}
		System.out.println(t);
	}
}
