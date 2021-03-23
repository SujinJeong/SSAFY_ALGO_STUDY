package hoyeong.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_14938 {
	static int N,M,R,INF=987654321;
	static int [] item;
	static int [][] dis;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		item = new int [N+1]; // 아이템
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}
		
		dis = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i==j) dis[i][i] = 0;
				else dis[i][j] = INF;
			}
		}
		
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			dis[from][to] = l;
			dis[to][from] = l;
		}
		
		floid();
		
		int cnt, result = 0;
		for(int i=1; i<=N; i++) { 
			cnt=0;
			for(int j=1; j<=N; j++) { // 한 지점에서 갈수 있는 지점들 사이에 얻을 수 있는 아이템의 최댓값
				if(dis[i][j] <= M) cnt+=item[j];
			}
			result = Math.max(result, cnt);
		}
		System.out.println(result);
	}
	private static void floid() {
		for(int k=1; k<=N; k++) { // 거쳐가는 노드
			for(int i=1; i<=N; i++) { // 시작 노드
				for(int j=1; j<=N; j++) { // 도착 노드
					if(dis[i][j] > dis[i][k]+dis[k][j])
						dis[i][j] = dis[i][k]+dis[k][j];
				}
			}
		}
	}
}
