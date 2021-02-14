package study_0208;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_3584 {
	static int N;
	static int[] parent, depth;
	static ArrayList<Integer>[] list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			list = new ArrayList[N + 1];
			for(int i = 0; i <= N; i++) {
				list[i] = new ArrayList<>();
			}
			parent = new int[N + 1];
			depth = new int[N + 1];
			for(int i = 0 ; i < N - 1; i ++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				list[A].add(B);
				parent[B] = A;
			}
			// 풀이 1. 깊이 설정
			for(int i =1 ;i<=N; i++) {
				if(parent[i] == 0) {
					dfs(i,0);
				}
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 풀이 2. 조상 찾기
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			sb.append(lca(n1,n2) + "\n");
		}
		// 출력
		System.out.println(sb);
	}
	
	private static void dfs(int node, int level) {
		if(depth[node] < level) {
			depth[node] = level;
		}
		for(int i = 0; i < list[node].size(); i++) {
			dfs(list[node].get(i), level + 1);
		}
	}
	
	private static int lca(int n1, int n2) {
		while(depth[n1] != depth[n2] ) {
			if(depth[n1] > depth[n2]) {
				n1 = parent[n1];
			}else {
				n2 = parent[n2];
			}
		}
		while(n1 != n2) {
			n1 = parent[n1];
			n2 = parent[n2];
		}
		return n1;
	}
}
