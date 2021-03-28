package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_9663 {
	static int N, res;
	static int[] arr;

	public static boolean isOk(int num) {
		boolean check = true;
		for (int i = 0; i < num; i++) {
			if (arr[i] == arr[num] || Math.abs(arr[num] - arr[i]) == num - i) {
				check = false;
				break;
			}
		}
		return check;
	}

	public static void findQueen(int num) {
		if (num == N) {
			res++;
			return;
		}
		for (int i = 0; i < N; ++i) {
			arr[num] = i;
			if (isOk(num))
				findQueen(num + 1);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		findQueen(0);
		System.out.println(res);
	}
}
