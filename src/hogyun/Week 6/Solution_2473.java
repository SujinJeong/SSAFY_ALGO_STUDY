package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2473 {
	static int N;
	static long[] arr, res;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new long[N];
		res = new long[3];
		for (int i = 0; i < N; ++i) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		long sum = 3000000000L;
		Arrays.sort(arr);
		for (int start = 0; start < N - 2; ++start) {
			int mid = start + 1;
			int end = arr.length - 1;
			while (mid < end) {
				long tmp = arr[start] + arr[mid] + arr[end];
				if (Math.abs(sum) > Math.abs(tmp)) {
					sum = tmp;
					res[0] = arr[start];
					res[1] = arr[mid];
					res[2] = arr[end];
				}
				if (tmp < 0) {
					mid++;
				} else
					end--;
			}
		}
		Arrays.sort(res);
		for (int i = 0; i < 3; ++i) {
			System.out.print(res[i] + " ");
		}
	}
}
