package study_0222;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_20055 {
	static int N, K, cnt, ans;
	static int[] A;
	static boolean[] robot;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = new int[2 * N + 1];
		robot = new boolean[N + 1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= 2 * N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		while(cnt < K) {
			ans++;
			f1();
			f2();
			f3();
			f4();
		}
		System.out.println(ans);
	}
	
	private static void f1() {
		A[0] = A[2 * N];
		for (int i = 2 * N; i >= 1; i--) {
			A[i] = A[i - 1];
		}

		for (int i = N; i >= 1; i--) {
			robot[i] = robot[i - 1];
		}
		if (robot[N]) robot[N] = false;
	}
	
	private static void f2() {
		for (int i = N - 1; i >= 1; i--) {
			if (robot[i]) {
				if (!robot[i + 1] && A[i + 1] > 0) {
					if (i + 1 != N) { robot[i + 1] = true; }
					A[i + 1]--;
					robot[i] = false;
				}
			}
		}
	}
	
	private static void f3() {
		if (!robot[1] && A[1] > 0) {
			robot[1] = true;
			A[1]--;
		}
	}
	
	private static void f4() {
		cnt = 0;
		for (int i = 1; i <= 2 * N; i++) {
			if (A[i] == 0) { cnt++; }
		}
	}
}
