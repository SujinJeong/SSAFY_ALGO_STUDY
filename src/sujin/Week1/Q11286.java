package sujin.Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Q11286 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 절대값이 같으면 작은 수, 다르면 절대값이 작은 수
		PriorityQueue<Integer> q = new PriorityQueue<>(
				(o1, o2) -> Math.abs(o1) == Math.abs(o2) ? Integer.compare(o1, o2)
						: Integer.compare(Math.abs(o1), Math.abs(o2)));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) { // 출력
				if (q.size() == 0)
					sb.append(0 + "\n");
				else
					sb.append(q.poll() + "\n");
			} else
				q.add(num);
		}
		System.out.println(sb);

	}

}
