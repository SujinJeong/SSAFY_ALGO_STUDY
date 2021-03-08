package study_0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806 {
	static final int INF = 987654321;
	static int N, S, ans = INF;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int e = 0, sum = 0;
		for(int s = 0; s < N; s++) {
			if(sum >= S) {
				ans = Math.min(ans, e - s);
			}
			while(sum < S && e < N) {
				sum += arr[e++];
				if(sum >= S) {
					ans = Math.min(ans, e - s);
				}
			}
			sum -= arr[s];
		}
		if(ans == INF) {
			ans = 0;
		}
		System.out.println(ans);
	}
}
