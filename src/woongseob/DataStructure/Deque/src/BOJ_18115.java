package study_0125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_18115 {
	static int N;
	static int[] card;
	static Deque<Integer> dq = new ArrayDeque<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		card = new int[N];
		for(int i = 0 ; i < N; i++) {
			card[i] = Integer.parseInt(stk.nextToken());
		}
		
		for(int i = N - 1; i >= 0; i--) {
			skill(card[i], N - i);
		}
		
		while(!dq.isEmpty()) {
			sb.append(dq.removeLast() + " ");
		}
		System.out.println(sb);
	}
	
	public static void skill(int n, int idx) {
		if(n == 1) {
			dq.addLast(idx);
		}
		else if(n==2) {
			int temp = dq.removeLast();
			dq.addLast(idx);
			dq.addLast(temp);
		}
		else {
			dq.addFirst(idx);
		}
	}
}
