package hoyeong.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class b_1967{
	int t,w;

	public b_1967(int t, int w) {
		super();
		this.t = t;
		this.w = w;
	}
}
public class back_1967 {
	static int N,find1,find2;
	static int [] visited;
	static ArrayList<b_1967> [] list;
	static Queue<b_1967> q = new LinkedList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		visited = new int[N+1];
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int wei = Integer.parseInt(st.nextToken());
			list[from].add(new b_1967(to, wei));
			list[to].add(new b_1967(from, wei));
		}
		
		if(N==1) {
			System.out.println(0);
			System.exit(0);
		}
		node();
		int max=0, idx=0;
		for(int i=1; i<=N; i++) {
			if(max<visited[i]) {
				max = visited[i];
				idx = i;
			}
		}
		circle(idx);
		max=0;
		for(int i=1; i<=N; i++) {
			max = Math.max(max, visited[i]);
		}
		System.out.println(max);
	}
	
	private static void node() {
		visited[1] = -1;
		q.add(new b_1967(1, 0));
		while(!q.isEmpty()) {
			b_1967 b = q.poll();
			int t = b.t;
			int w = b.w;
						
			for(int i=0; i<list[t].size(); i++) {
				int next = list[t].get(i).t;
				int weight = w + list[t].get(i).w;
				if(visited[next]!=0) continue;
				visited[next] = weight;
				q.add(new b_1967(next, weight));
			}
		}
	}
	
	private static void circle(int idx) {
		Arrays.fill(visited, 0);
		visited[idx] = -1;
		q.add(new b_1967(idx, 0));
		while(!q.isEmpty()) {
			b_1967 b = q.poll();
			int t = b.t;
			int w = b.w;
						
			for(int i=0; i<list[t].size(); i++) {
				int next = list[t].get(i).t;
				int weight = w + list[t].get(i).w;
				if(visited[next]!=0) continue;
				visited[next] = weight;
				q.add(new b_1967(next, weight));
			}
		}
	}
}
