package study_0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15565 {
	static final int INF = 987654321;
	static int N, K, ans = INF;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int cnt = 0, e = 0;
		for (int s = 0; s < N; s++) {
			if (cnt == K) {
				ans = Math.min(ans, e - s);
			}

			while (cnt < K && e < N) {
				if (arr[e] == 1) {
					cnt++;
				}
				e++;
				if (cnt == K) {
					ans = Math.min(ans, e - s);
				}
			}
			if (arr[s] == 1) {
				cnt--;
			}
		}
		if (ans == INF) {
			ans = -1;
		}
		System.out.println(ans);
	}
}
