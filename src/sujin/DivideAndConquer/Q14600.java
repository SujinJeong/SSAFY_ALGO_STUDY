package sujin.DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q14600 {
	/*
	 * 1. map 크기: Math.pow(n, 2); 헷갈리니까 -1씩해주기 0,0 -> 3, 0 / 2, 1 -> 2, 2 2. 하수구 위치:
	 * (가로-y, x-1) 3. 위쪽이 비어있다면 -> 왼쪽, 오른쪽 확인 아래쪽이 비어있다면 -> 왼쪽, 오른쪽 확인
	 */

	static int[][] map;
	static int idx = 0;

	public static boolean check(int x, int y, int ns) {
		for (int i = x; i < x + ns; i++) {
			for (int j = y; j < y + ns; j++) {
				// 하수구가 있으면
				if (map[i][j] != 0)
					return false;
			}
		}

		return true;
	}

	public static void fillMap(int x, int y, int size) {
		idx++;
		int ns = size / 2;
		// 4사분면 탐색
		// 1
		if (check(x, y + ns, ns))
			map[x + ns-1][y + ns] = idx;
		// 2
		if (check(x, y, ns))
			map[x + ns - 1][y + ns - 1] = idx;
		// 3
		if (check(x + ns, y, ns))
			map[x + ns][y + ns-1] = idx;
		// 4
		if (check(x + ns, y + ns, ns))
			map[x + ns][y + ns] = idx;

		// 계속 나누다가 2짜리 되면 끝
		if (size == 2)
			return;

		// 1
		fillMap(x, y + ns, ns);
		// 2
		fillMap(x, y, ns);
		// 3
		fillMap(x + ns, y, ns);
		// 4 
		fillMap(x + ns, y + ns, ns);

	}

	public static StringBuilder print() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}

		return sb;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		int length = (int) Math.pow(2, size);
		map = new int[length][length];

		String[] s = br.readLine().split(" ");
		int x = Integer.parseInt(s[0]);
		int y = Integer.parseInt(s[1]);

		// 하수구 위치 지정
		map[length - y][x - 1] = -1;

		// 타일 지정
		fillMap(0, 0, length);

		System.out.println(print());
	}

}
