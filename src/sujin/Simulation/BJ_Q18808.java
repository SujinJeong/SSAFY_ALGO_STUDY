package sujin.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
풀이 50분 소요
 */
public class BJ_Q18808 {
/*
1. 비어있는 행, 열이 없어야하고
2. 스티커는 모두 연결
3. 우선순위 가장 위쪽 -> 왼쪽
4. 만약 붙일 위치가 없다면 90도 회전한 뒤 스티커 붙이기 -> 360도 회전했는데 못붙이면 버리기
 */
	static int n, m;
	static int[][] nb;
	static int[] dx = {};
	static int[] dy = {};
	
	// 유효성 검사 통과하면 , 붙이기!
	public static void stick(int[][] sticker, int r, int c) {
		for (int i = 0; i < sticker.length; i++)
			for (int j = 0; j < sticker[0].length; j++)
				if (sticker[i][j] == 1) {
					// 노트북에 붙이기
					nb[r + i][c + j] = sticker[i][j];
				}
	}
	
	public static boolean canStick(int[][] sticker) {
		
		// 노트북에서 스티커 크기 뺸만큼
		int row_length = n - sticker.length + 1;
		int col_length = m - sticker[0].length + 1;
		
		for (int i = 0; i < row_length; i++) 
			for (int j = 0; j < col_length; j++)
				if (check(sticker, i, j)) { // 붙일 수 있는 곳인지 유효성검사
					// 붙이기
					stick(sticker, i, j);
					return true;
				}

		return false;
	}
	
	// 노트북에서 스티커가 붙은 칸의 수
	public static int count() {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (nb[i][j] == 1) cnt++;
			}
		}
		
		return cnt;
	}
	
	// 유효성 검사
	public static boolean check(int[][] sticker, int r, int c) {
		
		for (int i = 0; i < sticker.length; i++) {
			for (int j = 0; j < sticker[0].length; j++ ) {
				// 스티커가 존재하는 부분인데, 노트북의 해당 위치가 이미 차있을때
				// 두가지 조건이 다 있어야 돌아감..
				if (sticker[i][j] == 1 && nb[r + i][c + j] == 1) return false;
			}
		}
		
		return true;
	}
	
	// 조건에 부합하지 않으면 회전
	public static int[][] rotate(int[][] sticker) {
		int[][] new_sticker = new int[sticker[0].length][sticker.length];

		// 회전해야하므로 i, j 위치 바꿔주기
		for (int i = 0; i < sticker.length; i++)
			for (int j = 0; j < sticker[0].length; j++)
				new_sticker[j][sticker.length - i - 1] = sticker[i][j];

		return new_sticker;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 노트북 가로,세로, 스티커개수
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		// 노트북
		nb = new int[n][m];
		
		// 스티커 정보 input
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			int[][] sticker = new int[r][c];
			for (int x = 0; x < r; x++) {
				st = new StringTokenizer(br.readLine());
				for (int y = 0; y < c; y++) {
					sticker[x][y] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 붙일 수 있는지 test
			int dir = 0;
			while (dir < 4) {
				// 붙일 수 있으면 더 돌려볼 필요없다
				if (canStick(sticker)) break;
				sticker = rotate(sticker); // 못붙였으면 회전해서 sticker 배열 갱신
				dir++;
			}
		}
		
		System.out.println(count());
		
	}

}
