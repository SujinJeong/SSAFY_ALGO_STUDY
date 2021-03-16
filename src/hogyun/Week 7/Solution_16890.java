package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_16890 {
	static Queue<Character> res = new LinkedList<>();
	static Deque<Character> dq1 = new LinkedList<>();
	static Deque<Character> dq2= new LinkedList<>();
	static StringBuilder front = new StringBuilder();
	static StringBuilder back = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str1 = br.readLine();
		String str2 = br.readLine();

		char []tmp1 = str1.toCharArray();
		char []tmp2 = str2.toCharArray();
		Arrays.sort(tmp1);
		Arrays.sort(tmp2);
		for(int i=0; i<(str1.length() + 1) / 2; ++i) {
			dq1.addLast(tmp1[i]);
		}
		for(int i=0; i<str2.length() / 2; ++i) {
			dq2.addLast(tmp2[str2.length() - (i + 1)]);
		}
		int size = str1.length();
		for(int i=0; i<size; ++i) {
			if(i %2 == 0) {
				if(dq2.isEmpty() || dq1.peekFirst() < dq2.peekFirst()) {
					front.append(dq1.pollFirst());
				}else {
					back.append(dq1.pollLast());
				}				
			}else {
				if(dq1.isEmpty() || dq1.peekFirst() < dq2.peekFirst()) {
					front.append(dq2.pollFirst());
				}else {
					back.append(dq2.pollLast());
				}
			}
		}
		sb.append(front);
		for(int i=0; i<back.length(); ++i) {
			sb.append(back.charAt(back.length() - (i + 1)));
		}
		System.out.println(sb);
	}
}
