package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4256 {
	static int N;
	static int[] pre, in;

	static void postorder(int start, int end, int root) {
		for (int i = start; i < end; ++i) {
			if (in[i] == pre[root]) {
				postorder(start, i, root + 1);
				postorder(i + 1, end, root + i + 1 - start);
				System.out.print(pre[root] + " ");
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; ++tc) {
			N = Integer.parseInt(br.readLine());
			pre = new int[N + 1];
			in = new int[N + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; ++i)
				pre[i] = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; ++i)
				in[i] = Integer.parseInt(st.nextToken());

			postorder(0, N, 0);
			System.out.println();
		}
	}
}
