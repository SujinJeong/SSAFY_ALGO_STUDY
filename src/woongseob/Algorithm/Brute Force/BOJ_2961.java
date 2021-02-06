package study_0201;

import java.io.*;
import java.util.*;

public class BOJ_2961 {
	static int N, ans = Integer.MAX_VALUE;
	static int[] sour;
	static int[] bitter;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sour = new int[N];
		bitter = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}
		// 풀이
		recursive(0, 1, 0, 0);
		// 출력
		System.out.println(ans);
	}
	
	public static void recursive(int cnt, int s, int b, int n) {
		if(cnt == N) {
			if(ans > Math.abs(s - b) && n != 0) {
				ans = Math.abs(s - b);
			}
			return;
		}
		recursive(cnt + 1, s * sour[cnt], b + bitter[cnt], n + 1);
		recursive(cnt + 1, s, b, n);
	}
}
