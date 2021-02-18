package divideandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1992 {
	static int[][] arr;
	static int N;

	static void recursion(int x, int y, int size) {
		if (size == 1) {
			System.out.print(arr[x][y]);
			return;
		}

		boolean checkAllOne = true;
		boolean checkAllZero = true;

		for (int i = x; i < x + size; ++i) {
			for (int j = y; j < y + size; ++j) {
				if (arr[i][j] == 1)
					checkAllZero = false;
				else
					checkAllOne = false;
			}
		}

		if (checkAllZero)
			System.out.print(0);
		if (checkAllOne)
			System.out.print(1);

		if (!checkAllZero && !checkAllOne) {
			System.out.print("(");
			recursion(x, y, size / 2);
			recursion(x, y + size / 2, size / 2);
			recursion(x + size / 2, y, size / 2);
			recursion(x + size / 2, y + size / 2, size / 2);
			System.out.print(")");
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; ++i) {
			String str = br.readLine();
			for (int j = 0; j < N; ++j) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		recursion(0, 0, N);
	}
}
