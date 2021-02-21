package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2437 {
	static int N, res;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		if (arr[0] != 1) {
			res = 1;
			System.out.println(res);
			System.exit(0);
		}

		int tmp = 1;
		boolean token = false;
		for (int i = 1; i < N; ++i) {
			if (tmp + 1 < arr[i]) {
				res = tmp + 1;
				token = true;
				break;
			}
			tmp += arr[i];
		}
		if (token)
			System.out.println(res);
		else {
			res = tmp + 1;
			System.out.println(res);
		}
	}
}
