package hoyeong.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_1992 {
	static int N;
	static int[][] map;
	final static int dr[] = {0,0,1,1};
	final static int dc[] = {0,1,0,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		map = new int [N][N];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			String [] StringArray = str.split("");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(StringArray[j]);
			}
		}
		quad(0,0,N);
	}

	private static void quad(int r, int c, int n) {
		if (check(r, c, n) != 2) {
			System.out.print(check(r, c, n));
		} else {
			if (n >= 2) {
				n = n / 2;
				System.out.print("(");
				for (int i = 0; i < 4; i++) {
					int nr = r + n * dr[i];
					int nc = c + n * dc[i];
					quad(nr, nc, n);
				}
				System.out.print(")");
			}
		}
	}
	
	private static int check(int r, int c, int n) {
		int save = map[r][c];
		for(int i=r; i<r+n; i++) {
			for(int j=c; j<c+n; j++) {
				if(map[i][j]!=save) {
					return 2;
				}
			}
		}
		return save;
	}
}
