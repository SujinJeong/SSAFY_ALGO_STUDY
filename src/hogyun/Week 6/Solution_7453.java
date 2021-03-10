package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_7453 {
	static int N, res;
	static int[][] arr;
	static long[] arr2;
	static long[] arr3;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[4][N];
		for (int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[0][i] = Integer.parseInt(st.nextToken());
			arr[1][i] = Integer.parseInt(st.nextToken());
			arr[2][i] = Integer.parseInt(st.nextToken());
			arr[3][i] = Integer.parseInt(st.nextToken());
		}
		arr2 = new long[N * N];
		arr3 = new long[N * N];
		int idx = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				arr2[idx] = arr[0][i] + arr[1][j];
				arr3[idx] = arr[2][i] + arr[3][j];
				idx++;
			}
		}
		Arrays.sort(arr2);
		Arrays.sort(arr3);
		long res = 0;
		int start = 0;
		int end = N * N - 1;
		while (start < N * N && end >= 0) {
			long tmp = arr2[start] + arr3[end];
			if (tmp > 0) {
				end--;
			} else if (tmp < 0) {
				start++;
			} else {
				long cnt1 = 0;
				long cnt2 = 0;
				long num1 = arr2[start];
				long num2 = arr3[end];
				while (start < N * N && arr2[start] == num1) {
					cnt1++;
					start++;
				}
				while (end >= 0 && arr3[end] == num2) {
					cnt2++;
					end--;
				}
				res += (cnt1 * cnt2);
			}
		}
		System.out.println(res);
	}
}
