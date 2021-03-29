package hoyeong.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class b_12763 implements Comparable<b_12763>{
	int end, t, m;

	public b_12763(int end, int t, int m) {
		super();
		this.end = end;
		this.t = t;
		this.m = m;
	}

	@Override
	public int compareTo(b_12763 o) {
		// TODO Auto-generated method stub
		return this.end-o.end;
	}
}

public class back_12763 {
	static int N,T,M,L,INF=987654321,result=987654321;
	static int [] money,time;
	static boolean[] visited;
	static ArrayList<b_12763> [] list;
	static PriorityQueue<b_12763> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		money = new int [N+1];
		time = new int [N+1];
		visited = new boolean[N+1];
		
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
			money[i] = INF;
			time[i] = INF;
		}
		
		L = Integer.parseInt(br.readLine());
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			list[s].add(new b_12763(e, t, m)); // 양방향 이동이 가능해야 하므로
			list[e].add(new b_12763(s, t, m));
		}
		
		dijk();
		if(result>M) System.out.println(-1); // 결과 돈이 M보다 크다면 -1
		else System.out.println(result);
	}
	
	private static void dijk() {
		time[1] = 0;
		money[1] = 0;
		pq.add(new b_12763(1, 0, 0));
		while(!pq.isEmpty()) {
			b_12763 b = pq.poll();
			int e = b.end;
			int t = b.t;
			int m = b.m;
			
			if(e==N) { // 도착점에 왔을 때 결과값
				result = Math.min(result, m);
				continue;
			}
						
			for(int i=0; i<list[e].size(); i++) {
				int next = list[e].get(i).end; // 다음으로 갈 곳
				int next_time = t + list[e].get(i).t; 
				int next_money = m + list[e].get(i).m;
				
				if(next_time>T) continue; //시간이 지나면 continue;
				
				if (money[next] >= next_money || time[next] >= next_time) { // 다익으로 money를 최소화 해주면 정답루트까지 갈 수 있으나 돈이 최소가 아니라 중간에서 짤리는 경우 발생
					if (money[next] > next_money)							//	다익으로 time을 최소화 해주면 가장 적은 돈으로 갈 수 있으나 시간이 최소가 아니라 중간에서 짤리는 경우가 발생
						money[next] = next_money;							//  다익으로 모두 관리하면서 시간이 최소이거나 돈이 최소인 경우 모두 통과 가능하게 만들어줌
					if (time[next] > next_time)
						time[next] = next_time;
					pq.add(new b_12763(next, next_time, next_money));
				}
			}
		}
	}
}
