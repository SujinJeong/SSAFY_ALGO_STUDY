package study_0222;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2578 {
	static final int SIZE = 5;
	static int[][] arr = new int[SIZE][SIZE];
	static boolean[][] check = new boolean[SIZE][SIZE];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i = 0 ; i < SIZE; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < SIZE; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0;
		for(int i = 0 ; i < SIZE; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < SIZE; j++) {
				int val = Integer.parseInt(st.nextToken());
				if (ans != 0) continue;
				
				for (int k = 0; k < SIZE; k++) {
					for (int l = 0; l < SIZE; l++) {
						if (val == arr[k][l]) {
							check[k][l] = true;
							if (isBingo() >= 3) { ans = (i * SIZE) + j + 1; }
						}
					}
				}
			}
		}
		System.out.println(ans);
	}

	private static int isBingo() {
		int bingo = 0;
		for (int c = 0; c < SIZE; c++) {
			boolean rLine = true;
			for (int r = 0; r < SIZE; r++) {
				if (!check[r][c]) {
					rLine = false;
					break;
				}
			}
			if (rLine) bingo++;
		}

		for (int r = 0; r < SIZE; r++) {
			boolean cLine = true;
			for (int c = 0; c < SIZE; c++) {
				if (!check[r][c]) {
					cLine = false;
					break;
				}
			}
			if (cLine) bingo++;
		}
		
		boolean lDia = true;
		for (int i = 0; i < SIZE; i++) {
			if (!check[i][i]) {
				lDia = false;
				break;
			}
		}
		if (lDia) bingo++;

		boolean rDia = true;
		for (int i = 0; i < SIZE; i++) {
			if (!check[i][SIZE - i - 1]) {
				rDia = false;
				break;
			}
		}
		if (rDia) bingo++;

		return bingo;
	}
}
