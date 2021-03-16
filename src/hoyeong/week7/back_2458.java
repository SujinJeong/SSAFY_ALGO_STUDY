package hoyeong.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_2458 {
	static int N,M,cnt=0;
	static boolean [][] s_map;
	static boolean [][] t_map;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		s_map = new boolean[N+1][N+1];
		t_map = new boolean[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int small = Integer.parseInt(st.nextToken());
			int tall = Integer.parseInt(st.nextToken());
			s_map[small][tall] = true;
			t_map[tall][small] = true;
		}
		
		fluid();
		search();
		System.out.println(cnt);
	}
	
	private static void fluid() {
		for(int i=1; i<=N; i++) { // 내가 누구보다 작은지 알 수 있음
			for(int j=1; j<=N; j++) { 
				for(int k=1; k<=N; k++) {
					if(s_map[j][i] && s_map[i][k]) s_map[j][k] = true;
				}
			}
		}
		for(int i=1; i<=N; i++) { // 내가 누구보다 큰지 알 수 있음
			for(int j=1; j<=N; j++) { 
				for(int k=1; k<=N; k++) {
					if(t_map[j][i] && t_map[i][k]) t_map[j][k] = true;
				}
			}
		}
	}
	
	private static void search() {
		for(int i=1; i<=N; i++) { // 내가 누구보다 큰지 작은지 모두 알고있다면
			for(int j=1; j<=N; j++) {
				if(s_map[i][j] || t_map[i][j]) s_map[i][j] = true;
			}
		}
		
		for(int i=1; i<=N; i++) {
			int std=0;
			for(int j=1; j<=N; j++) {
				if(s_map[i][j]) std++;
			}
			if(std==N-1) cnt++;
		}
	}
}
