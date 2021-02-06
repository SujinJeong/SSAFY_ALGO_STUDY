package study_0201;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14888 {
	static int N, minNum = Integer.MAX_VALUE, maxNum = Integer.MIN_VALUE;
	static int[] ary;
	static int[] op = new int[4];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ary = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			ary[i] = Integer.parseInt(st.nextToken()); 
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}

		// 풀이
		recursive(1, ary[0]);

		// 출력
		System.out.println(maxNum + "\n" + minNum);
	}

	public static void recursive(int cnt, int val) {
		if (cnt == N) {
			maxNum = val > maxNum ? val : maxNum;
			minNum = val < minNum ? val : minNum;
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (op[i] == 0)
				continue;
			op[i]--;
			switch (i) {
			case 0:
				recursive(cnt + 1, val + ary[cnt]);
				break;
			case 1:
				recursive(cnt + 1, val - ary[cnt]);
				break;
			case 2:
				recursive(cnt + 1, val * ary[cnt ]);
				break;
			case 3:
				recursive(cnt + 1, val / ary[cnt]);
				break;
			}
			op[i]++;
		}
	}
}
