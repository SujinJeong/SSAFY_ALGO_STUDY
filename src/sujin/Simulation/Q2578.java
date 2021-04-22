package sujin.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2578 {
	static int[][] map;
	static int[] bingo;
	static boolean[][] visited;

	public static void visit(int num) {

		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++) {
				if (num == map[i][j])
					visited[i][j] = true;
			}
	}

	public static boolean isBingo() {
		// 빙고 갯수 세기
		int sum = 0;

		// 행체크
		for (int i = 0; i < 5; i++) {
			int cnt = 0;
			for (int j = 0; j < 5; j++) {
				if (!visited[i][j])
					break;
				cnt++;
			}
			if (cnt == 5)
				sum++;
		}
		
		// 열체크
		for (int i = 0; i < 5; i++) {
			int cnt = 0;
			for (int j = 0; j < 5; j++) {
				if (!visited[j][i])
					break;
				cnt++;
			}
			if (cnt == 5)
				sum++;
		}

		// 오른쪽 밑 대각선
		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			if (visited[i][i] == true)
				cnt++;
		}
		if (cnt == 5)
			sum++;

		// 오른쪽 위 대각선
		cnt = 0;
		for (int i = 0; i < 5; i++) {
			if (visited[4 - i][i] == true)
				cnt++;
		}
		if (cnt == 5)
			sum++;

		if (sum >= 3) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[5][5];
		for (int i = 0; i < 5; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}

		bingo = new int[25];
		visited = new boolean[5][5];
		int rslt = 0, idx = 0;
		for (int i = 0; i < 5; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < 5; j++) {
				bingo[idx++] = Integer.parseInt(line[j]);
				
			}
		}
		
		for (int i = 0; i< bingo.length; i++) {
			visit(bingo[i]);
			rslt++;
			if (isBingo()) {
				System.out.println(rslt);
				break;
			}
		}

	}

}
