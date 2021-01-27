package woongseob.Stack.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Sol_2493 {
	static class lazer {
		public lazer(int height, int pos) {
			super();
			this.height = height;
			this.pos = pos;
		}

		int height;
		int pos;
	}

	static int N;
	static Stack<lazer> stack = new Stack<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= N; i++) {
			int h = Integer.parseInt(stk.nextToken());
			if (stack.empty()) {
				System.out.print("0 ");
			} else if (stack.peek().height >= h) {
				System.out.print(stack.peek().pos + " ");
			} else {
				while (!stack.empty() && stack.peek().height < h) {
					stack.pop();
				}
				if (stack.empty()) {
					System.out.print("0 ");
				} else {
					System.out.print(stack.peek().pos + " ");
				}
			}
			stack.push(new lazer(h, i));
		}
	}
}