package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_2374 {
	static int N, res;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		res = 0;
		Stack<Integer> stk = new Stack<>();
		for (int i = 0; i < N; ++i) {
			if (stk.isEmpty())
				stk.add(arr[i]);
			else {
				while (stk.peek() < arr[i]) {
					int tmp = stk.pop();
					if (stk.isEmpty() || stk.peek() > arr[i]) {
						res += arr[i] - tmp;
						break;
					} else {
						res += stk.peek() - tmp;
					}
				}
				stk.add(arr[i]);
			}
		}
		if (!stk.isEmpty()) {
			int tmp = stk.peek();
			while (stk.size() > 1)
				stk.pop();
			int tmp2 = stk.peek();
			res += tmp2 - tmp;
		}
		System.out.println(res);
	}
}
