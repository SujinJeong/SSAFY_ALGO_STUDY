package hoyeong.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class human implements Comparable<human>{
	int idx;
	double w;
	
	public human(int idx, double w) {
		super();
		this.idx = idx;
		this.w = w;
	}

	@Override
	public int compareTo(human o) {
		return this.idx - o.idx;
	}
}
public class back_10473 {
	static double start_x, start_y, Dest_x, Dest_y;
	static int N, INF=987654321;
	static double [] dis;
	static double [][] cannon;
	static boolean [] visited;
	static PriorityQueue<human> pq = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		start_x = Double.parseDouble(st.nextToken());
		start_y = Double.parseDouble(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		Dest_x = Double.parseDouble(st.nextToken());
		Dest_y = Double.parseDouble(st.nextToken());
		
		N = Integer.parseInt(br.readLine());
		cannon = new double[N+2][2];
		dis = new double[N+2];
		visited = new boolean[N+2];
		
		cannon[0][0] = start_x;
		cannon[0][1] = start_y;
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			cannon[i][0] = Double.parseDouble(st.nextToken());
			cannon[i][1] = Double.parseDouble(st.nextToken());
		}
		
		cannon[N+1][0] = Dest_x;
		cannon[N+1][1] = Dest_y;
		
		dijk();
		System.out.println(dis[N+1]);
	}
	private static double distance(int a, int b) {
		double dis = Math.sqrt(Math.pow(cannon[a][0]-cannon[b][0],2)+Math.pow(cannon[a][1]-cannon[b][1],2));
		
		if(a==0) return dis/5.0;
		return Math.min(Math.abs(dis-50)/5.0 +2, (dis)/5.0);
	}
	
	private static void dijk() {
		Arrays.fill(dis, INF);
		dis[0] = 0;
		pq.add(new human(0,0));
		while(!pq.isEmpty()) {
			human h = pq.poll();
			int idx = h.idx;
			double w = h.w;
					
			for(int i=0; i<=N+1; i++) {
				double time = distance(idx,i) + w;
				
				if(dis[i]>time) {
					dis[i] = time;
					pq.add(new human(i, time));
				}
				
			}
		}
	}
}
