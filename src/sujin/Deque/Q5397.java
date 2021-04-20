package sujin.Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Q5397 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Character> first = new LinkedList<Character>();
		Deque<Character> last = new LinkedList<Character>();
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		// 커서 위치가 first / last 덱 사이
		while (t-- > 0) {
			String s = br.readLine();

			for (int i = 0; i < s.length(); i++) {
				char tmp = s.charAt(i);

				if (tmp == '<') {
					if (!first.isEmpty()) {
						char move = first.removeLast();
						last.addFirst(move);
					}
				} else if (tmp == '>') {
					if (!last.isEmpty()) {
						char move = last.removeFirst();
						first.addLast(move);
					}
				} else if (tmp == '-') { // 백스페이스

					if (!first.isEmpty()) {
						first.removeLast();
					}
				} else { // 문자열
					first.addLast(tmp);
				}

			}

			while (!first.isEmpty()) {
				sb.append(first.removeFirst());
			}

			while (!last.isEmpty()) {
				sb.append(last.removeFirst());
			}

			sb.append("\n");
		} // end of tc

		System.out.println(sb);
	}

}
