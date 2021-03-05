package sujin.Week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9663 {
	static int[] arr;
	static int n, cnt = 0;

	public static boolean canQueen(int num, int row) {

		for (int i = 0; i < row; i++) {
			// 지금까지 행 중에 같은 열이 존재하는지 검사
			if (arr[i] == num)
				return false;

			// 대각선에 이미 퀸이 존재하는지 검사 "x값 차이 == y값 차이"면 대각선에 존재
			if (Math.abs(arr[i] - num) == Math.abs(i - row))
				return false;
		}

		return true;
	}

	public static void solve(int row) {
		if (row == n) {
			cnt++;
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			// 슬쩍 넣어보기
			arr[row] = i;
			// 이 위치에 넣을 수 있는지 확인
			if (canQueen(i, row)) {
				solve(row + 1);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		// 행의 정보를 담고 있는 녀석
		arr = new int[n];
		solve(0);

		System.out.println(cnt);
	}

}
