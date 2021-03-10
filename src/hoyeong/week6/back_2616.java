package hoyeong.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_2616 {
	static int N,train;
	static int [] arr;
	static int [] sum;
	static int [][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int [N+1];
		sum = new int [N+1];
		dp = new int [4][N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum[i] = sum[i-1] + arr[i];
		}
		train = Integer.parseInt(br.readLine());
				
		for(int i=1; i<=3; i++) {
			for(int j=train*i; j<=N; j++) {
				dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-train]+sum[j]-sum[j-train]);
			}
		}
		System.out.println(dp[3][N]);
	}
}
