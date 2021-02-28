package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_13164 {
	static int N, K;
	static int[] arr;
	static Integer[] diff;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		diff = new Integer[N - 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i)
			arr[i] = Integer.parseInt(st.nextToken());

		int res = 0;
		for (int i = 0; i < N - 1; ++i)
			diff[i] = arr[i + 1] - arr[i];

		Arrays.sort(diff, Collections.reverseOrder());
		for (int i = K - 1; i < N - 1; ++i)
			res += diff[i];
		System.out.println(res);
	}
}
