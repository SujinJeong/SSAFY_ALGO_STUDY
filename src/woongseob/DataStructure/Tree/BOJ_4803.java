package study_0215;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_4803 {
	static int n, m;
	static int[] parent;
	static boolean[] check, cycle;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = 0;
		while (true) {
			tc++;
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			if (n == 0 && m == 0) {
				break;
			}
			parent = new int[n + 1];
			check = new boolean[n + 1];
			cycle = new boolean[n + 1];
			for (int i = 1; i <= n; i++) {
				parent[i] = i;
			}
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (getParent(a) != getParent(b)) {
					if (cycle[getParent(a)] || cycle[getParent(b)]) {
						cycle[getParent(a)] = true;
						cycle[getParent(b)] = true;
					}
					unionParent(getParent(a), getParent(b));
				} else {
					cycle[getParent(a)] = true;
				}
			}
			int ans = 0;
			for (int i = 1; i <= n; i++) {
				if(!cycle[getParent(i)] && !check[getParent(i)]) {
					ans++;
					check[getParent(i)] = true;
				}
			}
			if(ans == 0) {
				sb.append("Case " + tc+": No trees.\n");
			}
			else if(ans == 1) {
				sb.append("Case " + tc + ": There is one tree.\n");
			}
			else {
				sb.append("Case " + tc + ": A forest of " + ans + " trees.\n");
			}
		}
		System.out.println(sb);
	}

	private static int getParent(int x) {
		if (parent[x] == x)
			return x;
		else
			return parent[x] = getParent(parent[x]);
	}

	private static void unionParent(int a, int b) {
		a = getParent(a);
		b = getParent(b);

		if (a < b)
			parent[b] = a;
		else
			parent[a] = b;
	}

}
