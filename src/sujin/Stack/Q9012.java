package sujin.Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/*
6
(())())
(((()())()
(()())((()))
((()()(()))(((())))()
()()()()(()()())()
(()((())()(
3
((
))
())(()
*/
public class Q9012 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Stack<Character> st = new Stack<Character>(); // '(' ����
	
		int num = Integer.parseInt(br.readLine());
		for (int i = 0; i < num; i++) {
			// �Է�
			String s = br.readLine();

			boolean isLast = true;
			// Ǯ��
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == '(')
					st.push(s.charAt(j));

				else if (s.charAt(j) == ')') {
					if (st.isEmpty()) { // ')' �� ���� ���
						isLast = false;
						break;
					} else { // ������ �Ⱥ���ְ� '('�� ���ÿ� �����ִ� ���
						st.pop();
					}

//                    // ���� ������ �ε����� ��� = ���� �ùٸ� ���ڿ�
//                    if (j == (s.length()-1))
//                        isLast = true;
				}
			}

			// ���
			if (isLast && st.empty()) {
				bw.write("YES");
				bw.newLine();
			}
			// '(' �� ���� ���
			else {
				bw.write("NO");
				bw.newLine();
			}

			st.clear();
		}
		bw.flush();
	}
}