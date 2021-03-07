package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_15565 {
	static int N, K;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		int cnt = 0;
		int res = 987654321;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; ++i) {
			int num = Integer.parseInt(st.nextToken());
			if(num == 1) {
				arr[cnt++] = i;
			}
		}
		if(cnt < K)
			System.out.println(-1);
		else {
			for(int i=0; i<=cnt - K; ++i) {
				res = Math.min(res, arr[i + K - 1] - arr[i] + 1);
			}
			System.out.println(res);
		}
	}
}
