package hoyeong.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_3085 {
	static int N, max=0;
	static char [][] map;
	static int [] dr = {1,0,-1,0};
	static int [] dc = {0,1,0,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		set_max(); // 초기단계에서 최댓값 찾기
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				candy(i,j);
			}
		}
		System.out.println(max);
	}
	
	private static void candy(int r, int c) {
		for(int dir=0; dir<4; dir++) {
			int nr = r+ dr[dir];
			int nc = c+ dc[dir];
			
			if (nr<0 || nc<0 || nr >= N || nc >= N)
				continue;
			
			//if (map[r][c] != map[nr][nc]) {
				char s = map[r][c];
				map[r][c] = map[nr][nc];
				map[nr][nc] = s;

				int cnt = 1;
				for (int i = r + 1; i < N; i++) {
					if (map[i][c] != map[r][c])
						break;
					cnt++;
				}
				for (int i = r - 1; i >= 0; i--) {
					if (map[i][c] != map[r][c])
						break;
					cnt++;
				}
				max = Math.max(max, cnt);

				cnt = 1;
				for (int i = c + 1; i < N; i++) {
					if (map[r][i] != map[r][c])
						break;
					cnt++;
				}
				for (int i = c - 1; i >= 0; i--) {
					if (map[r][i] != map[r][c])
						break;
					cnt++;
				}
				max = Math.max(max, cnt);

				s = map[r][c];
				map[r][c] = map[nr][nc];
				map[nr][nc] = s;
			//}
		}
	}

	private static void set_max() {
		for (int i = 0; i < N; i++) {
			int cnt = 1;
			for (int j = 0; j < N - 1; j++) {
				if (map[i][j] != map[i][j + 1])
					break;
				cnt++;
			}
			max = Math.max(max, cnt);
			
			cnt = 1;
			for (int j = 0; j < N - 1; j++) {
				if (map[j][i] != map[j+1][i])
					break;
				cnt++;
			}
			max = Math.max(max, cnt);
		}
	}
}
