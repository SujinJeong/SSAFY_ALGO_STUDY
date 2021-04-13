package sujin.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q5002 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int maxDiff = Integer.parseInt(br.readLine());
		String order = br.readLine();
		Stack<Character> s = new Stack<>();
		boolean isFinish = true;
		
		int pair = 0;
		for(int i = 0; i < order.length(); i++) {
			if (s.size() == (maxDiff+2)) {
				isFinish = false;
				break;
			}
			if (s.size() != 0 && s.peek() != order.charAt(i)) {
				s.pop(); pair +=2;
				continue;
			}
			s.push(order.charAt(i));
		}
		
		if (isFinish && s.size() <= maxDiff)
				sb.append(pair+s.size());
		else sb.append(pair+maxDiff);
		
		System.out.println(sb);
	}

}
