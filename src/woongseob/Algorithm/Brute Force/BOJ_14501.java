package study_0201;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14501 {
	static int N, ans = Integer.MIN_VALUE;
	static int[] day, pay;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		day = new int[N];
		pay = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			day[i] = Integer.parseInt(st.nextToken());
			pay[i] = Integer.parseInt(st.nextToken());
		}
		// 풀이
		recursive(0, 0);
		// 출력
		System.out.println(ans);
	}

	public static void recursive(int cnt, int val) {
		if (cnt > N) {
			return;
		}
		ans = ans < val ? val : ans;
		if(cnt < N) {
			recursive(cnt + day[cnt], val + pay[cnt]);
		}
		recursive(cnt + 1, val);
	}
}
