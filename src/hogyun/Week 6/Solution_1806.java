package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1806 {
	static int N, S;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i)
			arr[i] = Integer.parseInt(st.nextToken());

		int start = 0;
		int end = 0;
		int sum = 0;
		int minLen = 987654321;
		while (true) {
			if (end == N + 1)
				break;
			if (sum >= S) {
				minLen = Math.min(minLen, end - start);
				sum -= arr[start++];
			} else if (sum < S) {
				sum += arr[end++];
			}
		}
		if (minLen == 987654321)
			System.out.println(0);
		else
			System.out.println(minLen);
	}
}
