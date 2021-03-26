package hoyeong.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class back_9935 {
	static int N,B;
	static String str,bomb;
	static char [] result;
	static Stack<Integer>stack = new Stack<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		str = br.readLine();
		bomb = br.readLine();
				
		N = str.length();
		B = bomb.length();
		
		result = new char[N];
		
		int idx = 0;
		outloop:for(int i=0; i<N; i++) {
			result[idx++] = str.charAt(i);
			if(result[idx-1] == bomb.charAt(B-1)) { // 폭발물 추정
				if(idx - B < 0) continue;
				for(int j=0; j<B; j++) {
					if(result[idx-j-1]!=bomb.charAt(B-j-1)) {
						continue outloop;
					}
				}
				idx -= B;
			}
		}
		
		if(idx==0) System.out.println("FRULA");
		else {
		for(int i=0; i<idx; i++)
			sb.append(result[i]);
		System.out.println(sb);
		}
	}
}




// 예전 코드--------------------------------------------------------
/*package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class back_9935 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static Stack <String> stack = new Stack<>();
	static String [] strArray;
	static String [] bomb; 
	static String[] save;
	
	public static void main(String[] args) throws IOException {
		String str = br.readLine();
		strArray = str.split("");
		
		String str1 = br.readLine();
		bomb = str1.split("");
		save = new String[bomb.length];
		
		bomb();
		
		if(!stack.isEmpty()) {
			System.out.println(sb.toString());
		}
		else System.out.println("FRULA");
	}
	
	private static void bomb() {
		for(int i=0; i<strArray.length; i++) {
			if(strArray[i].equals(bomb[bomb.length-1])) {
				save[bomb.length-1]=strArray[i]; // 폭발 문자열의 가장 마지막 값 비교
				int cnt=1;
				for(int j=bomb.length-2; j>=0; j--) { // 
					if(i < bomb.length || !stack.peek().equals(bomb[j])) break; // 폭발 문자가 아니라면 중간에 끊음
					save[j]=stack.pop();
					cnt++;
					}
				if(cnt!=bomb.length) {
					for(int j=bomb.length-cnt; j<=bomb.length-1; j++) {
						stack.push(save[j]);
						}
				}
			}
			else stack.push(strArray[i]);
			}
		for(String s:stack) sb.append(s);
		}
	}*/