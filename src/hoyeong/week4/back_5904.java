package hoyeong.week4;

import java.io.*;
import java.util.*;

public class back_5904 {
	static int N;
	static int [] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		dp = new int [1000];
		dp[0] = 3;
		moo(3,0);
	}

	private static void moo(int s, int cnt) { // 어느 그룹인지 판단
		if(N <= s) {
			if(N > dp[cnt-1]+(3+cnt)) { // 3그룹에 있을 때
				N = N-dp[cnt-1]-(3+cnt);
				find(cnt-1);
			}
			else if(N > dp[cnt-1]) { // 2그룹
				if(N == dp[cnt-1]+1) System.out.println("m");
				else System.out.println("o");
			}
			else { // 1그룹
				find(cnt-1);
			}
		}
		else {
			dp[cnt+1] = 2*s+3+cnt+1;
			moo(2*s+3+cnt+1,cnt+1);
		}
	}
	
	private static void find(int cnt) {
		if(cnt==0) {
			if(N==1) System.out.println("m");
			else System.out.println("o");
			return;
		}
		if(N > dp[cnt-1]+(3+cnt)) { // 3그룹에 있을 때
			N = N-dp[cnt-1]-(3+cnt);
			find(cnt-1);
		}
		else if(N > dp[cnt-1]) { // 2그룹
			if(N == dp[cnt-1]+1) System.out.println("m");
			else System.out.println("o");
		}
		else { // 1그룹
			find(cnt-1);
		}
	}
}

