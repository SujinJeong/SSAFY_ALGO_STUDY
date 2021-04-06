package hoyeong.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_18808 {
	static int N,M,K,r,c;
	static int [][] map;
	static int [][] sticker;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int [N][M];
		
		outloop:for(int k=0; k<K; k++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			sticker = new int [r][c];
			for(int i=0; i<r; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<c; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int dir=0; dir<4; dir++) {
				if (STICK()) continue outloop; // 붙일 수 있다면 다음 스티커 확인
				else { // 붙일 수 없다면 스티커 돌리기
					sticker = change();
				}
			}
		}
		int cnt=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==1) cnt++;
			}
		}
		System.out.println(cnt);
	}
	private static boolean STICK() { // 스티커 붙이기
		for(int i=0; i<N-r+1; i++) { // 시작 위치
			for(int j=0; j<M-c+1; j++) {
				if(pos(i,j)) {
					attach(i,j);
					return true;
				}
			}
		}
		return false;
	}
	
	private static boolean pos(int row, int col) { // 스티커 붙일 수 있는지 확인
		for (int i = 0; i < r; i++)
			for (int j = 0; j < c; j++)
				if (sticker[i][j] == 1 && map[row + i][col + j] == 1)
					return false;
		return true;
	}
	
	private static void attach(int row, int col) { // 스티커 붙이기
		for (int i = 0; i < r; i++)
			for (int j = 0; j < c; j++)
				if(sticker[i][j]==1) // 1이라면 붙이기
					map[row+i][col+j] = sticker[i][j];
		
	}
	
	private static int [][] change() { // 스티커 돌리기
		int[][] make = new int[c][r];
        for(int i = 0; i<c; i++){
        	for(int j = 0; j<r; j++)
            	make[i][j] = sticker[r-j-1][i];
        }
        
		int tmp = r;
        r = c;
        c = tmp;
        return make;
	}
}
