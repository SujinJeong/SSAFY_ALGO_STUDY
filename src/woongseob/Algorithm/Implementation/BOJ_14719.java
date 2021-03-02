package study_0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14719 {
	static int H, W;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		arr = new int[W];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int ans = 0;
		for (int i = 0; i < W; i++) {
			int left = 0;
			for (int j = 0; j <= i; j++) {
				left = Math.max(left, arr[j]);
			}
			int right = 0;
			for (int j = i; j < W; j++) {
				right = Math.max(right, arr[j]);
			}
			int side = Math.min(left, right);
			ans += side - arr[i];
		}
		System.out.println(ans);
	}
}
