package hoyeong.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

class SET{
	int e,t;

	public SET(int e, int t) {
		super();
		this.e = e;
		this.t = t;
	}
}
public class back_1865 {
	static int N,M,W,S,E,T, INF=987654321;
	static int [] dis;
	static LinkedList<SET> [] list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for(int i=0; i<TC; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			dis = new int [N+1];
			list = new LinkedList[N+1];
			
			for(int j=1; j<=N; j++) {
				list[j] = new LinkedList<SET>();
			}
			
			for(int j=0; j<M; j++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				list[s].add(new SET(e,t)); // 도로는 양방향 이므로 둘다 넣어줘야함
				list[e].add(new SET(s,t));
			}
			for(int j=0; j<W; j++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				list[s].add(new SET(e,-t)); // 웜홀은 단방향 이므로 하나만 넣어주면됨
				
			}
			
			if(BF()) sb.append("YES\n");
			else sb.append("NO\n");
		}
		System.out.println(sb.toString());
	}
	
	private static boolean BF() {
		Arrays.fill(dis, INF);
		dis[1] = 0;
		boolean check;
		
		for(int i=1; i<=N; i++) {
			check = false;
			for(int j=1; j<=N; j++) {
				for(int k=0; k<list[j].size(); k++)
					if(dis[list[j].get(k).e] > dis[j] + list[j].get(k).t) {
						dis[list[j].get(k).e] = dis[j] + list[j].get(k).t;
						check = true;
						if(i==N) {
							return true;
						}
					}
				}
			}
		return false;
	}
}
