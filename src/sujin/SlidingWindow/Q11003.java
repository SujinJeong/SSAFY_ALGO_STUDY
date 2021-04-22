package sujin.SlidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q11003 {
	public static class Info {
		int num, idx;

		public Info(int num, int idx) {
			super();
			this.num = num;
			this.idx = idx;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Info> dq = new LinkedList<Info>();
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		for (int now = 1; now <= n; now++) {
			int tmp = Integer.parseInt(st.nextToken());

			// 정렬되어있는 애 중에 젤 큰애보다 작은 애 들어오면 컸던 애는 쓸모없어지므로 빼주기
			while (!dq.isEmpty() && tmp < dq.peekLast().num) {
				dq.pollLast();
			}

			// 최소값이 오래돼서 범위 안에 없는 경우
			if (!dq.isEmpty() && dq.peekFirst().idx <= now - l) {
				dq.pollFirst();
			}

			Info cur = new Info(tmp, now);
			dq.addLast(cur);

			sb.append(dq.peekFirst().num + " ");
		}

		System.out.println(sb);
	}

}
