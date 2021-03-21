package hoyeong.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class bridge{
	int b;
	long c;
	public bridge(int b, long c) {
		super();
		this.b = b;
		this.c = c;
	}
}
public class back_1939 {
	static int N,M,Start,Dest;
	static long max, result=0;
	static ArrayList<bridge> [] list; // 데이터 검색에는 ArrayList가 훨씬 유리
	static Queue<Integer> q = new LinkedList<>();
	static boolean [] visited;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<bridge>();
		}
		max=0;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Integer.parseInt(st.nextToken());
			list[a].add(new bridge(b,c));
			list[b].add(new bridge(a,c));		
			max = Math.max(max, c);
		}
		
		st = new StringTokenizer(br.readLine());
		Start = Integer.parseInt(st.nextToken());
		Dest = Integer.parseInt(st.nextToken());
		
		long low=1, high=max;
		while(low<=high) {
			q.clear();
			long mid = (low+high)/2; // 찾으려는 중량
			q.add(Start);
			visited[Start]=true;
			
			if(bfs(mid)) { // 목적지까지 갈 수 있다면
				result = Math.max(result, mid);
				low = mid+1;
			}
			else high = mid-1;
		}
		
		System.out.println(result);

	}
	private static boolean bfs(long mid) {
		
		Arrays.fill(visited, false);
		
		while (!q.isEmpty()) {
			int a = q.poll();
			for (int i = 0; i < list[a].size(); i++) {
				int b = list[a].get(i).b;
				long c = list[a].get(i).c;
				if (!visited[b] && mid <= c) { // 다리를 건널 수 있다면
					if (b == Dest) {
						return true;
					}
					visited[b] = true;
					q.add(b);
				}
			}
		}
		return false;
	}
}
