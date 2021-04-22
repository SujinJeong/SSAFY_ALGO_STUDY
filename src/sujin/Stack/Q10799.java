package sujin.Stack;

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

		// �Է�
		String s = br.readLine();

		// Ǯ��
		for (int j = 0; j < s.length(); j++)
			if (s.charAt(j) == '(')
				st.push(s.charAt(j));
			else {
				st.pop(); // ')'�� ��� ¦�� ���� pop
				if (s.charAt(j - 1) == '(') { // ()�ΰ�� = ������
					sum += st.size();
				} else { // ������ ��
					sum += 1;
				}
			}
		
		// ���
		System.out.println(sum);
	}
}
