package sujin.Week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1992 {
	static int[][] map;
	static StringBuilder sb = new StringBuilder();
	public static void solve(int x, int y, int size) {
		
		// 쪼개고 쪼개다가 1이 되었을때는 4등분할 수 없으므로
		if (size == 1) {
			if (map[x][y] == 1) sb.append("1");
			else sb.append("0");
			return;
		}
		
		if(canZip(x, y, size)) return;
		
		// 차례대로 1,2,3,4
		sb.append("(");
		solve(x, y, size/2);
		solve(x, y+size/2, size/2);
		solve(x+size/2, y, size/2);
		solve(x+size/2, y+size/2, size/2);
		sb.append(")");
	}
	
	public static boolean canZip(int x, int y, int size) {
		int startNum = map[x][y];
		
		for (int i = x; i < x+size; i++)
			for (int j = y; j < y+size; j++)
				if (map[i][j] != startNum)
					// 하나라도 다르면 false
					return false;
		
		// 다른게 없으면 압축하기
		if (startNum == 0)
			sb.append("0");
		else sb.append("1");
		
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(s.substring(j, j+1));
			}
		}
		
		solve(0, 0, n);
		System.out.println(sb);
	}

}