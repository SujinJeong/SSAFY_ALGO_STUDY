package sujin.Week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q8983 {
	static int m, n, l;
	
	public static int getDistance(int x, int y, int shoot) {
		return Math.abs(shoot - x) + y;
	}

	public static boolean shooting(int[] shoot, int x, int y) {
		// 사대 범위 줄여가기
		int low = 0, high = m-1;

		while (low <= high) {
			int mid = (low + high) / 2;

			// 사정거리
			if (getDistance(x, y, shoot[mid]) <= l) {
				return true;
			}
			// 사정 거리 밖이고 사대가 동물 기준 더 큰쪽에 있는 경우
			else if (x < shoot[mid])
				high = mid - 1;
			// 사정 거리 밖이고 사대가 동물 기준 더 작은쪽에 있거나 
			// 사대랑 같은 라인에 있는데 높이 있어서 다다를 수 없는 경우
			else
				low = mid + 1;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int rslt = 0;
		
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		int[] shoot = new int[m];

		// 사대 input
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			shoot[i] = Integer.parseInt(st.nextToken());
		}

		// 작은 쪽에 있는 사대부터
		Arrays.sort(shoot);
		
		// 동물 input
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			// 자신을 쏴줄 사대가 있으면 cnt++
			 if (shooting(shoot, x, y)) rslt++;
		}

		System.out.println(rslt);
	}

}
