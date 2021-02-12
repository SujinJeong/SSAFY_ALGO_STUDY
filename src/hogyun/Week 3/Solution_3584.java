package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3584 {
	static int T, N, child1, child2, res;
	static int []arr;
	static boolean []check;
	
	public static int findParent(int c1, int c2) {
		check[c1] = true;
		while(arr[c1] != -1) {
			c1 = arr[c1];
			check[c1] = true;
		}
		while(true) {
			if(check[c2])
				break;
			if(arr[c2] != -1)
				c2 = arr[c2];
		}
		return c2;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; ++tc) {
			N = Integer.parseInt(br.readLine());
			arr = new int[100001];
			Arrays.fill(arr, -1);
			check = new boolean[100001];
			Arrays.fill(check, false);
			for (int i = 1; i <= N - 1; ++i) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				arr[v] = u;
			}
			st = new StringTokenizer(br.readLine());
			child1 = Integer.parseInt(st.nextToken());
			child2 = Integer.parseInt(st.nextToken());
			res = findParent(child1, child2);
			sb.append(res + "\n");
		}
		System.out.println(sb.toString());
	}
}
