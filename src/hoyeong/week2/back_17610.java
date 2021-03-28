package hoyeong.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class back_17610 {
	static int N,S;
	static int [] arr;
	static boolean [] pos;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		S=0;
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			S+=arr[i];
		}
		pos = new boolean[S+1];
		
		dfs(0,0);
		int cnt=0;
		for(int i=1; i<=S; i++) {
			if(!pos[i]) cnt++;
		}
		System.out.println(cnt);
	}	
	
	private static void dfs(int idx, int weight) {
		if (idx == N) {
			if (weight > 0 ) {
				pos[weight] = true;
			}
			return;
		}
		dfs(idx+1,weight);
		dfs(idx+1,weight+arr[idx]);
		dfs(idx+1,weight-arr[idx]);
	}
}
