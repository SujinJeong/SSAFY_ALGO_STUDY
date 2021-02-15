package study_0208;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_4256 {
	static int[] preorder, inorder;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			preorder = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < n; i++) {
				preorder[i] = Integer.parseInt(st.nextToken());
			}
			inorder = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < n; i++) {
				inorder[i] = Integer.parseInt(st.nextToken());
			}
			// 풀이
			subtree(0, n - 1, 0);
			sb.append("\n");
		}
		// 출력
		System.out.println(sb);
	}

	private static void subtree(int s, int e, int root) {
		for(int i = s; i <= e; i++) {
			if(inorder[i] == preorder[root]) {
				subtree(s, i - 1, root + 1);
				subtree(i + 1, e, root  + 1 + (i - s));
				sb.append(preorder[root] + " ");
			}
		}
	}
}
