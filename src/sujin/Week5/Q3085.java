package sujin.Week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3085 {
	static char[][] map;
	static int n, max = 0;
	
	public static void solve() {
		
		// 가로로 가장 긴것
		for (int i = 0; i < n; i++) {
			// 하나 찾았을 때부터 시작하므로
			int cnt = 1;
			for (int j = 0; j < n-1; j++) {
				if (map[i][j] == map[i][j+1]) cnt++;
				else { // 다른거 만난순간 cnt 초기화
					//여기다만 놓으면 한줄이 다 같은경우를 MAX를 계산해주지 않아서 밖에서도 계산 필요
					max = Math.max(cnt, max); 
					cnt = 1;
				}
			}
			max = Math.max(cnt, max);
		}
		
		// 세로로 가장 긴것
		for (int i = 0; i < n; i++) {
			// 하나 찾았을 때부터 시작하므로
			int cnt = 1;
			for (int j = 0; j < n-1; j++) {
				if (map[j][i] == map[j+1][i]) cnt++;
				else { // 다른거 만난순간 cnt 초기화
					//여기다만 놓으면 한줄이 다 같은경우를 MAX를 계산해주지 않아서 밖에서도 계산 필요
					max = Math.max(cnt, max); 
					cnt = 1;
				}
			}
			max = Math.max(cnt, max);
		}
		
		return;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		map = new char[n][n];
		
		for (int i = 0; i < n; i++) {
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				map[i][j] = line[j];
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n-1; j++) {
				// 열바꾸기
				char tmp1 = map[i][j];
				char tmp2 = map[i][j+1];
				map[i][j] = tmp2;
				map[i][j+1] = tmp1;
				
				solve();
				
				// 좌표 돌려놓기
				map[i][j] = tmp1;
				map[i][j+1] = tmp2;
				
				// 열바꾸기
				tmp1 = map[j][i];
				tmp2 = map[j+1][i];
				map[j][i] = tmp2;
				map[j+1][i] = tmp1;
				
				solve();
				
				// 좌표 돌려놓기
				map[j][i] = tmp1;
				map[j+1][i] = tmp2;
			}
		}
		System.out.println(max);
	}

}
