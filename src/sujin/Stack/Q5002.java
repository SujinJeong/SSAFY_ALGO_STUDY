package sujin.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q5002 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int maxDiff = Integer.parseInt(br.readLine());
		String order = br.readLine();
		Stack<Character> s = new Stack<>();
		boolean isFinish = true;
		
		int pair = 0;
		for(int i = 0; i < order.length(); i++) {
			// n+1까지만 기회있으므로 n+2는 가망없음
			if (s.size() == (maxDiff+2)) {
				isFinish = false;
				break;
			}
			
			char cur = order.charAt(i);
			if (s.size() != 0 && s.peek() != cur) {
				s.pop(); 
				pair +=2;
				continue;
			}
			
			// 두번째사람까지 들여보낼 수 있으므로 n+1 사람까지 기회 주는거임
			// w,m 인 경우나 size가 n+2된경우 아니면 push
			s.push(cur);
		}
		
		// 끝까지 간 경우에는 스택에 쌓여있는만큼 더해주기
		if (isFinish)
			if (s.size() > maxDiff)
				System.out.println(pair+maxDiff);
			else
				System.out.println(pair+s.size());
		// 중간에 끝난경우에는 pair수 + max 차이
		else
			System.out.println(pair+maxDiff);
	}

}
