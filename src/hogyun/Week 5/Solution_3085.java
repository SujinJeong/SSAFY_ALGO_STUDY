package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_3085 {
	static int N, res;
	static char[][] arr;

	public static void calc() {
		int maxSize = 0;
		for(int i=0; i<N; ++i) { // 행 조사
			int start = arr[i][0];
			int startCnt = 1;
			for(int j=1; j<N; ++j) {
				if(start == arr[i][j]) {
					startCnt++;
				}else {
					startCnt = 1;
				}
				maxSize = Math.max(maxSize, startCnt);
				start = arr[i][j];
			}
		}
				
		for(int i=0; i<N; ++i) { // 열 조사
			int start = arr[0][i];
			int startCnt = 1;
			for(int j=1; j<N; ++j) {
				if(start == arr[j][i]) {
					startCnt++;
				}else {
					startCnt = 1;
				}
				maxSize = Math.max(maxSize, startCnt);
				start = arr[j][i];
			}
		}
		res = Math.max(res, maxSize);
	}
	public static void swap1(int x, int y) {
		char tmpChar = arr[x][y];
		arr[x][y] = arr[x][y + 1];
		arr[x][y + 1] = tmpChar;

		calc();
		
		tmpChar = arr[x][y];
		arr[x][y] = arr[x][y + 1];
		arr[x][y + 1] = tmpChar;
	}
	
	public static void swap2(int y, int x) {
		char tmpChar = arr[x][y];
		arr[x][y] = arr[x + 1][y];
		arr[x + 1][y] = tmpChar;
		
		calc();
		
		tmpChar = arr[x][y];
		arr[x][y] = arr[x + 1][y];
		arr[x + 1][y] = tmpChar;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		for (int i = 0; i < N; ++i) {
			String str = br.readLine();
			for (int j = 0; j < N; ++j) {
				arr[i][j] = str.charAt(j);
			}
		}
		res = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N - 1; ++j) {
				swap1(i, j);
				swap2(i, j);
			}
		}
		System.out.println(res);
	}
}
