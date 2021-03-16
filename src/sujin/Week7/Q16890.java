package sujin.Week7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;

/*
1. 구사과: 작은문자가 앞으로 올수록 좋음 but (본인의 가장 작은 문자 > 큐브러버의 가장 큰 문자)이면 자신이 가진 제일 "큰" 문자 맨 뒤로 넣어야함!
2. 큐브러버: 큰문자가 앞으로 올수록 좋음 but (본인의 가장 큰 문자 < 구사과의 가장 작은 문자)이면 자신이 가진 제일 "작은" 문자 맨 뒤로 넣어야함!
 */
public class Q16890 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Deque<Character> dq1 = new ArrayDeque<Character>();
		Deque<Character> dq2 = new ArrayDeque<Character>();
		// 원래대로 차곡차곡 넣어주기
		StringBuilder front = new StringBuilder();
		// 1, 2의 경우를 맨뒤로 넣어주는 경우
		StringBuilder back = new StringBuilder();
		
		// 구사과
		String s1 = br.readLine();
		Character[] g = new Character[s1.length()];
		// 큐브러버
		String s2 = br.readLine();
		Character[] c = new Character[s2.length()];
		
		for (int i = 0; i < s1.length(); i++) {
			g[i] = s1.charAt(i);
			c[i] = s2.charAt(i);
		}

		Arrays.sort(g);
		Arrays.sort(c, Collections.reverseOrder());
		
		// 사과 차례일때 홀수일수도 있으니까 +1
		for (int i = 0; i < (g.length+1)/2; i++) dq1.add(g[i]);
		for (int i = 0; i < c.length/2; i++) dq2.add(c[i]);
		
		// dq1 -> 작은거부터, dq2 -> 큰거부터
		for (int i = 0; i < g.length; i++) {
			if (i % 2 == 0) { // 구사과
				if (dq2.isEmpty() || dq1.peekFirst() < dq2.peekFirst()) front.append(dq1.pollFirst());
				// 본인의 가장 작은 문자 > 큐브러버의 가장 큰 문자 -> 자신이 가진 가장 큰 문자 맨 뒤로
				else back.append(dq1.pollLast());
			}
			else { // 큐브러버
				if (dq1.isEmpty() || dq2.peekFirst() > dq1.peekFirst()) front.append(dq2.pollFirst());
				// 본인의 가장 큰 문자 < 큐브러버의 가장 작은 문자 -> 자신이 가진 가장 작은 문자 맨 뒤로
				else back.append(dq2.pollLast());
			}
		}
		
//		System.out.println(front);
//		System.out.println(back.reverse());
		bw.write(front.toString());
		bw.write(back.reverse().toString());
		bw.flush();
	}

}
