package hoyeong.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class back_9252 {
	static char [] arr1;
	static char [] arr2;
	static int [][] dp;
	static Stack <Character> stack = new Stack<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		arr1 = new char[str.length()+1];
		arr1[0] = '0';
		for(int i=1; i<=str.length(); i++) {
			arr1[i] = str.charAt(i-1);
		}
		
		str = br.readLine();
		arr2 = new char[str.length()+1];
		arr2[0] = '0';
		for(int i=1; i<=str.length(); i++) {
			arr2[i] = str.charAt(i-1);
		}
		
		dp = new int[arr1.length][arr2.length];
		
		for(int i=1; i<arr1.length; i++) {
			for(int j=1; j<arr2.length; j++) {
				if(arr1[i]==arr2[j]) 	dp[i][j] = dp[i-1][j-1]+1; // 현재 문자열이 오기 전까지 최대 lcs 길이
				else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		System.out.println(dp[arr1.length-1][arr2.length-1]);
		str(); // 문자열 찾는 메소드
	}
	private static void str() {
		int r = arr1.length-1;
		int c = arr2.length-1;
		while(r!=0 && c!=0) {
			if(dp[r][c]==dp[r][c-1]) c--; // 왼쪽이 같으면 왼쪽으로 이동
			else if(dp[r][c]==dp[r-1][c]) r--; // 윗쪽이 같으면 윗쪽으로 이동
			else {								// 좌측, 상단 같은 곳이 없을 때 자기자신이 공통부분수열일면 stack에 넣고 좌측상단으로 이동
				if(arr1[r] == arr2[c]) stack.push(arr1[r]); //거꾸로 출력해야하므로 stack 이용
				r--;
				c--;
			}
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}
}
