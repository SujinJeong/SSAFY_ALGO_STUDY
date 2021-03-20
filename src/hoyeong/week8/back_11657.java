package hoyeong.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Bus{
	int b,c;

	public Bus(int b, int c) {
		super();
		this.b = b;
		this.c = c;
	}
}
public class back_11657 {
	static int N,M;
	static long INF = Long.MAX_VALUE;
	static ArrayList<Bus>[] list;
	static long [] dis;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		dis = new long [N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Bus(b,c));
		}
		if (!BF()) { // 사이클이 없을 때
			for (int i = 2; i <= N; i++) {
                sb.append(dis[i] == INF ? "-1\n" : dis[i] + "\n"); //해당도시로 가는 경로가 없다면 -1, 있다면 최소 경로 출력
            }
		}
		else { // 사이클 존재
			sb.append("-1\n");
		}
		System.out.println(sb);
	}
	private static boolean BF() {
		
		Arrays.fill(dis, INF);
		dis[1]=0;
		
		for(int i=0; i<N; i++) { // N번 반복
			
			for(int j=1; j<=N; j++) {
				if(dis[j] == INF) continue; // 해당 도시로 갈 수 없다면 연산 x
				
				int s = list[j].size();
				for(int k=0; k<s; k++) {
					Bus b = list[j].get(k);
					int end = b.b;
					int wei = b.c;
					
					if(dis[end] > dis[j]+wei) {
						dis[end] = dis[j]+wei;
						if(i==N-1) return true; // 사이클 존재
					}
				}
			}
		}
		return false; // 사이클 없음
	}
}
