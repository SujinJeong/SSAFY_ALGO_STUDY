package study_0215;

import java.io.*;
import java.util.Stack;

public class BOJ_2374 {
	static int n;
	static Stack<Integer> s = new Stack<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		long ans = 0;
		for (int i = 0; i < n; i++) {
			int val = Integer.parseInt(br.readLine());
			if (s.empty()) {
				s.add(val);
			} else {
				if (s.peek() >= val) {
					s.add(val);
				} else {
					while(s.peek() < val) {
						int last = s.pop();
						if(s.empty() || s.peek() >= val) {
							ans += val - last;
							break;
						}else {
							ans += s.peek() - last;
						}
					}
					s.add(val);
				}
			}
		}
		if(s.size() > 1) {
			int low = s.pop();
			while(s.size() != 1) {
				s.pop();
			}
			int high = s.pop();
			ans += high - low;
		}
		System.out.println(ans);
	}
}
