package study_0222;

import java.io.*;

public class BOJ_3085 {
	static int N, ans;
	static char[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		for(int i = 0 ; i < N; i++) {
			String s = br.readLine();
			for(int j = 0 ; j < N; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int nx = j + 1;
				if (nx < N) {
					swap(i, j, i, nx);
					row(i, j); row(i, nx);
					col(i, j); col(i, nx);
					swap(i, j, i, nx);
				} 
				int ny = i + 1;
				if (ny < N) {
					swap(i, j, ny, j);
					row(i, j); row(ny, j);
					col(i, j); col(ny, j);
					swap(i, j, ny, j);
				}
			}
		}
		System.out.println(ans);
	}
	
	private static void swap(int i, int j, int a, int b) {
		char temp = arr[i][j];
		arr[i][j] = arr[a][b];
		arr[a][b] = temp;
	}
	
	private static void row(int r, int c) {
		for (int i = 0; i < N; i++) {
			char word = arr[i][c];
			int len = 1;
			for (int j = i + 1; j < N; j++) {
				if (arr[j][c] == word) { len++; }
				else { break; }
			}
			ans = Math.max(ans, len);
		}		
	}
	
	private static void col(int r, int c) {
		for (int i = 0; i < N; i++) {
			char word = arr[r][i];
			int len = 1;
			for (int j = i + 1; j < N; j++) {
				if (arr[r][j] == word) { len++; }
				else { break; }
			}
			ans = Math.max(ans, len);
		}
	}
}
