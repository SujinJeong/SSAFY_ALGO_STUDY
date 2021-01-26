package study_0125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Sol_10799 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Stack<Character> stack = new Stack<>();
		int ans = 0;
		for(int i = 0 ; i < str.length(); i++) {
			if(str.charAt(i) == '(') {
				stack.push(str.charAt(i));
			}
			else {
				stack.pop();
				// 레이져 일 경우
				if(str.charAt(i - 1) == '(') {
					ans += stack.size();
				}
				else {
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
}
