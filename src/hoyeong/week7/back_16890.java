package hoyeong.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class back_16890{
	
	static char [] apple, love;
	static Deque<Character> a = new ArrayDeque<>(); 
	static Deque<Character> l = new ArrayDeque<>(); 
	static StringBuilder start = new StringBuilder();
	static StringBuilder end = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		apple = new char[str1.length()];
		love = new char[str1.length()];
		int N = str1.length();
		
		for(int i=0; i<str1.length(); i++) {
			apple[i] = str1.charAt(i);
			love[i] = str2.charAt(i);
		}
		
		Arrays.sort(apple);
		Arrays.sort(love);
		
		for(int i=0; i<(N+1)/2; i++)  
			a.add(apple[i]);
		for(int j=N-1; j>=(N+1)/2; j--)
			l.add(love[j]);
		
		for(int i=0; i<N; i++) {
			if(i%2 == 0) { // 구사과
				if(l.isEmpty() || a.peek() < l.peek()) {
					start.append(a.pollFirst());
				}
				else end.append(a.pollLast());
			}
			else { // 큐브러버
				if(a.isEmpty()||a.peek() < l.peek()) { // 비정상적인 상황
					start.append(l.pollFirst());
				}
				else end.append(l.pollLast());
			}
		}
		System.out.print(start);
		for(int i=end.length()-1; i>=0; i--)
			System.out.print(end.charAt(i));
	}
}
