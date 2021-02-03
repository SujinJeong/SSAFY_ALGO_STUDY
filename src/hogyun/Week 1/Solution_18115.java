package deque;

import java.util.*;
import java.io.*;

public class Solution_18115 {
	public static int N;
	public static Deque<Integer> dq = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int num = 1;
		for (int i = N - 1; i >= 0; --i) {
			if (arr[i] == 1) {
				dq.offerFirst(num);				
			} else if (arr[i] == 3) {
				dq.offerLast(num);
			} else {
				int tmp = dq.pollFirst();
				dq.offerFirst(num);
				dq.offerFirst(tmp);
			}
			num++;
		}

		StringBuilder sb = new StringBuilder();// 스트링빌더 안 쓰고 그냥 for문으로 출력 시 시간초과
		for (int i = 0; i < N; ++i) {
			sb.append(dq.pollFirst() + " ");
		}
		System.out.println(sb);
	}
}
