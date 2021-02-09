package hoyeong.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_1260 {
	static int N;
	static LinkedList<Integer>[] nodelist;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb_b = new StringBuilder();		
		StringBuilder sb_d = new StringBuilder();		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		nodelist = new LinkedList[N+1];
		for(int i=0; i <= N; i++) {
            nodelist[i] = new LinkedList<Integer>();
        }
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			nodelist[node1].add(node2);
			nodelist[node2].add(node1);
			
			Collections.sort(nodelist[node1]);
			Collections.sort(nodelist[node2]);
		}
		dfs(start,new boolean[N+1],sb_d);
		System.out.println(sb_d);
		bfs(start,new boolean[N+1],sb_b);
		System.out.println(sb_b);
		
	
	}
	private static void bfs(int node, boolean[] flag, StringBuilder sb) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(node);
		
		while(!q.isEmpty()) {
			node = q.poll();
			
			if(flag[node]) continue; // 1 이라면
			flag[node] = true;
			sb.append(node+" ");
			
			for(int list:nodelist[node]) {
				q.add(list);
			}
		}
		
	}
	private static void dfs(int node, boolean[] flag,StringBuilder sb) {
		if(flag[node]) return;
		flag[node]=true;
		sb.append(node+" ");
		
		for(int list:nodelist[node]) {
			dfs(list,flag,sb);
		}
	}
}
