package study_0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_7453 {
	static int N;
	static int[] A, B, C, D;
	static int[] AB, CD;
	// static ArrayList<Integer> AB = new ArrayList<>();
	// static ArrayList<Integer> CD = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		B = new int[N];
		C = new int[N];
		D = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			D[i] = Integer.parseInt(st.nextToken());
		}

		AB = new int[N * N];
		CD = new int[N * N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				AB[i * N + j] = A[i] + B[j];
				CD[i * N + j] = C[i] + D[j];
			}
		}
		Arrays.sort(AB);
		Arrays.sort(CD);

		long ans = 0;
		for (int i = 0; i < N * N; i++) {
			long low = lower_bound(CD, -AB[i]);
			long high = upper_bound(CD, -AB[i]);
			ans += high - low;
		}
		System.out.println(ans);
	}

	public static int lower_bound(int[] array, int value) {
		int low = 0;
		int high = array.length;
		while (low < high) {
			final int mid = low + (high - low) / 2;
			if (value <= array[mid]) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

	public static int upper_bound(int[] array, int value) {
		int low = 0;
		int high = array.length;
		while (low < high) {
			final int mid = low + (high - low) / 2;
			if (value >= array[mid]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}

}
