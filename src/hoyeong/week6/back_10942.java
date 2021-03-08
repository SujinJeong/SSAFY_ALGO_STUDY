package hoyeong.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_10942 {
	static int N,M;
	static int [] arr;
	static int [][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		arr = new int [N+1];
		dp= new int [N+1][N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		pelin();
		
		M = Integer.parseInt(br.readLine());
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			sb.append(dp[s][e]+"\n");
		}
		System.out.println(sb.toString());
		
	}
	private static void pelin() {
		for(int i=1; i<=N; i++) { // 길이가 1일때  무조건 펠린
			dp[i][i] = 1;
		}
		for(int i=1; i<N; i++) { // 길이가 2일 때 양 끝의 숫자가 같으면 펠린
			if(arr[i]==arr[i+1]) dp[i][i+1] = 1;
		}
		for(int i=3; i<=N; i++) { // 길이가 3 이상일 때 양 끝의 숫자가 같고, 사이에 수들이 펠린이면
			for(int j=1; j<=N-i+1; j++) {
				int k= j+i-1; // 길이가 i 일 때 마지막 숫자
				if(arr[j]==arr[k] && dp[j+1][k-1]==1)
					dp[j][k] = 1;
			}
		}
	}
}
