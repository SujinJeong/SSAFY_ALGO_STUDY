package sujin.Jan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/*
()(((()())(())()))(())
17
(((()(()()))(())()))(()())
24
 */
public class Q10799 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> st = new Stack<Character>();
		int sum = 0;

		// 입력
		String s = br.readLine();

		// 풀이
		for (int j = 0; j < s.length(); j++)
			if (s.charAt(j) == '(')
				st.push(s.charAt(j));
			else {
				st.pop(); // ')'인 경우 짝을 만나 pop
				if (s.charAt(j - 1) == '(') { // ()인경우 = 레이저
					sum += st.size();
				} else { // 막대의 끝
					sum += 1;
				}
			}
		
		// 출력
		System.out.println(sum);
	}
}
