package stack;

import java.util.Scanner;
import java.util.Stack;

public class Solution_9012 {
	public static int N;
	public static String[] res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		res = new String[N];
		for (int i = 0; i < N; ++i) {
			String str = sc.next();
			char[] line = new char[str.length()];
			Stack<Character> stk = new Stack<Character>();
			for (int j = 0; j < str.length(); ++j) {
				line[j] = str.charAt(j);
			}
			boolean check = true;
			for (int j = 0; j < line.length; ++j) {
				if(line[j] == '(') { // '(' 일 경우 무조건 넣어준다.
					stk.push(line[j]);
				}else {
					if(stk.empty()){ // 비어있는데 ')'이면 무조건 NO
						check = false;
						break;
					}else { // 이전에 '('가 있었으므로 stack에서 pop시켜줘서 () 이거 하나가 통과했다는 의미
						stk.pop();
					}
				}
			}
			if(stk.empty())
				res[i] = "YES";
			else
				res[i] = "NO";
			if(!check)
				res[i] = "NO";
		}
		for (int i = 0; i < N; ++i)
			System.out.println(res[i]);

		sc.close();
	}
}
