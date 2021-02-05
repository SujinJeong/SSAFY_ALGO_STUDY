package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_14888 {
	public static int N;
	public static int Max, Min;
	public static int[] arr, operator;

	public static void backTracking(int num, int idx) {
		if (idx == N) {
			Max = Math.max(Max, num);
			Min = Math.min(Min, num);
			return;
		}

		for (int i = 0; i < 4; ++i) {
			if (operator[i] > 0) {
				operator[i]--;
				if (i == 0)
					backTracking(num + arr[idx], idx + 1);
				else if (i == 1)
					backTracking(num - arr[idx], idx + 1);
				else if (i == 2)
					backTracking(num * arr[idx], idx + 1);
				else
					backTracking(num / arr[idx], idx + 1);
				operator[i]++;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i)
			arr[i] = Integer.parseInt(st.nextToken());

		operator = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; ++i)
			operator[i] = Integer.parseInt(st.nextToken());

		Max = -1000000000;
		Min = 1000000000;

		backTracking(arr[0], 1);
		System.out.println(Max);
		System.out.println(Min);
	}
}
