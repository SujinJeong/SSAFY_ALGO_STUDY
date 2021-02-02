package stack;

import java.util.Scanner;
import java.util.Stack;

public class Solution_10799 {
	public static char[] arr;
	public static int res = 0;
	public static Stack<Character> stk = new Stack<Character>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		arr = new char[str.length()];
		for (int i = 0; i < str.length(); ++i) {
			arr[i] = str.charAt(i);
		}
		int leftCnt = 0;
		for (int i = 0; i < str.length(); ++i) {
			if (arr[i] == '(') {
				stk.push(arr[i]);
				leftCnt++;
			} else {
				if (stk.peek() == '(') { //레이저
					stk.push(arr[i]);
					leftCnt--;
					res += leftCnt;
				} else { // 막대기 끝
					stk.push(arr[i]);
					leftCnt--;
					res += 1;
				}
			}
		}
		System.out.println(res);
		sc.close();
	}
}
