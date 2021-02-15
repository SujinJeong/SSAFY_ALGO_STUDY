package study_0208;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1967 {
	static int n, d, r;
	static ArrayList<Tree>[] t;
	static boolean[] visit;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		t = new ArrayList[n + 1];
		visit = new boolean[n + 1];
		for(int i = 0; i <= n; i++) {
			t[i] = new ArrayList<Tree>(); 
		}
		for(int i = 0 ; i < n - 1; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			t[a].add(new Tree(b, w));
			t[b].add(new Tree(a, w));
		}
		dfs(1, 0);
		visit = new boolean[n + 1];
		dfs(r, 0);
		System.out.println(d);
	}
	
	private static void dfs(int node, int dist) {
		visit[node] = true;
		if(d < dist) {
			d = dist;
			r = node;
		}
		for(int i = 0 ; i < t[node].size(); i++) {
			if(!visit[t[node].get(i).node]) {
				dfs(t[node].get(i).node, dist + t[node].get(i).weight);
			}
		}
		
	}

	static class Tree{
		int node;
		int weight;
		public Tree(int node, int weight) {
			super();
			this.node = node;
			this.weight = weight;
		}
	}
}
