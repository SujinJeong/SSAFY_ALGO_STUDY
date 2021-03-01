package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_20055 {
	static int N, K, cnt;
	static int[] arr;
	static boolean[] check;

	public static void rotate() {
		int tmp = arr[N * 2 - 1];
		for (int i = N * 2 - 1; i > 0; --i) {
			arr[i] = arr[i - 1];
		}
		arr[0] = tmp;

		for (int i = N - 1; i > 0; --i) {
			check[i] = check[i - 1];
		}
		check[0] = false;
		check[N - 1] = false;
	}

	public static void move() {
		for (int i = N - 1; i > 0; --i) {
			if (!check[i] && check[i - 1] && arr[i] > 0) {
				check[i] = true;
				check[i - 1] = false;
				arr[i]--;
			}
		}
		if (arr[0] > 0) {
			arr[0]--;
			check[0] = true;
		}
		cnt++;
	}

	public static boolean isZero() {
		int tmpCnt = 0;
		for (int i = 0; i < 2 * N; ++i) {
			if (arr[i] == 0)
				tmpCnt++;
		}
		if (tmpCnt >= K)
			return true;
		else
			return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N * 2];
		check = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N * 2; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		while (true) {
			rotate();
			move();
			if (isZero())
				break;
		}
		System.out.println(cnt);
	}
}
