package hoyeong.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_12851 {
	static int N,K,result=987654321,result_c=0;
	static Queue<Integer> q = new LinkedList<>();
	static int [] time = new int[100001];
	final static int [] dx = {-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if (N >= K) {
            System.out.println((N-K) + "\n1");
            return;
        }
		
		q.add(N);
		time[N] = 0;
		
		bfs();
		sb.append(time[K]+"\n"+result_c);
		System.out.println(sb);
		
	}
	
	private static void bfs() {
		while(!q.isEmpty()) {
			int x = q.poll();
			
			if(result<time[x]) return;
			
			for(int i=0; i<3; i++) {
				int nx=0;
				if(i==2) { // 순간이동
					nx = 2*x;
				}
				else {
					nx = x + dx[i];
				}
				if(nx<0 || nx>100000) continue;
				
				if(nx==K) {
					result = time[x];
					result_c++;
				}
				
				if(time[nx] ==0 || time[nx]==time[x]+1) {
					time[nx] = time[x]+1;
					q.add(nx);
				}
				
			}
			
		}
	}
}
