package study_0125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9012 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();
			boolean VPS = true;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(') {
					stack.push(str.charAt(i));
				} else if (str.charAt(i) == ')') {
					if (stack.empty()) {
						VPS = false;
						break;
					} else {
						stack.pop();
					}
				}
			}
			if (!stack.empty() || !VPS) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}
	}
}
