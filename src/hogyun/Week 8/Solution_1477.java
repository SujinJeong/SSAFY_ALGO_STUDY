package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1477 {
	static int N, M, L;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		arr = new int[N + 2];
		arr[0] = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		arr[N] = L;
		Arrays.sort(arr);
		int left = 1;
		int right = L - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			int tmpCnt = 0;
			for (int i = 1; i < N + 2; ++i) {
				int dist = arr[i] - arr[i - 1];
				tmpCnt += dist / mid;
				if (dist % mid == 0)
					tmpCnt--;
			}
			if (tmpCnt > M) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.println(left);
	}
}
