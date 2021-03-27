package sujin.Week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
1. 비용을 최소화 해야하니까 비용이 기준으로 다익
2. 비용 기준으로 다익 돌았는데 제한시간 안인지 확인
3. 비용이나 시간 둘다 손해면 안가고 둘중 하나라도 이득이면 일단 확인..
 */
public class Q12763 {
	static int n, t, m, l, min = Integer.MAX_VALUE;
	static Building[][] adj;
	static Info[] dist;
	final static int INF = 987654321;
	
	public static class Building {
		int from, to, time, cost;

		public Building(int from, int to, int time, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.time = time;
			this.cost = cost;
		}
	}
	
	public static class Info {
		int time, cost;

		public Info(int time, int cost) {
			super();
			this.time = time;
			this.cost = cost;
		}
		
	}
	
	public static void dfs(int idx) {
		if (idx == n) { // 종료노드까지 도달했을때, min cost 계산
			if (dist[n].time <= t)
				min = Math.min(min, dist[n].cost);
			return;
		}
		
		// 모든 간선 검사
		for (int i = 1; i < adj[idx].length; i++) {
			// 연결되어있을때
			if (adj[idx][i] != null) {
				// 시간, 가격 둘다 손해면 따져줄 필요없음
				if (dist[i].cost < (dist[idx].cost + adj[idx][i].cost) 
						&& dist[i].time < (dist[idx].time + adj[idx][i].time)) continue;
				
				// 제한시간이나 제한돈 넘으면 볼 필요도 없음
				// 가지치기 안하면 시간초과남!!!!!!!!!!!
				if (dist[idx].time + adj[idx][i].time > t || dist[idx].cost + adj[idx][i].cost > m) continue;
				
				// 둘 중 하나라도 이득이면 더 작은 값으로 갱신
				dist[i].cost = dist[idx].cost + adj[idx][i].cost;
				dist[i].time = dist[idx].time + adj[idx][i].time;
				
				// 갱신된 도착지첨부터 다시 탐색
				dfs(i);
			}
		}
	}
	
	public static void init() {
		for (int i = 1; i <= n; i++) {
			dist[i] = new Info(INF, INF);
		}
		
		// 시작 노드 값 설정
		dist[1].cost = 0;
		dist[1].time = 0;
		return;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		adj = new Building[n+1][n+1];
		dist = new Info[n+1];
		
		// 시간, 돈 input
		st = new StringTokenizer(br.readLine());
		t = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// 간선 정보 input
		l = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adj[from][to] = new Building(from, to, time, cost);
			adj[to][from] = new Building(to, from, time, cost);
		}
		
		init();
		
		// 1번 노드부터 시작
		dfs(1);
		
		if (dist[n].cost == INF) System.out.println(-1);
		else System.out.println(min);
	}

}
