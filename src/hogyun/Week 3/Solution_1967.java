package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1967 {
	static int N, maxWeight, maxIdx;
	static ArrayList<Info>[] arr;
	static boolean[] visited;

	static class Info {
		int v, weight;

		public Info(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}
	}

	public static void dfs(int start, int weight) {
		visited[start] = true;	
		for(int i=0; i<arr[start].size(); ++i) {
			Info tmp = arr[start].get(i);
			if(!visited[tmp.v]) {
				visited[tmp.v] = true;
				dfs(tmp.v, weight + tmp.weight);
				visited[tmp.v] = false;
			}
		}
		
		if(weight > maxWeight) {
			maxWeight = weight;
			maxIdx = start;
		}
		visited[start] = false;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		arr = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		for (int i = 0; i <= N; ++i)
			arr[i] = new ArrayList<Info>();

		for (int i = 0; i < N - 1; ++i) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			arr[u].add(new Info(v, weight));
			arr[v].add(new Info(u, weight));
		}
		dfs(1, 0);
		maxWeight = 0;
		dfs(maxIdx, 0);
		System.out.println(maxWeight);
	}
}
