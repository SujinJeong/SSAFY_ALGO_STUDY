package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class back_2667 {
	static int N,cnt;
	static int[][] map;
	static boolean[][] visited;
	static List<Integer> list = new ArrayList<>();
	final static int[] dr = {-1,0,1,0};
	final static int[] dc = {0,1,0,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==1 &&!visited[i][j]) {
					cnt=0;
					dfs(i,j);
					list.add(cnt);
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for(int x:list) System.out.println(x);
		
		
	}
	private static void dfs(int r, int c) {
		visited[r][c]=true;
		cnt++;
		for(int dir=0; dir<4; dir++) {
			int nr = r+dr[dir];
			int nc = c+dc[dir];
			if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
			
			if(!visited[nr][nc] && map[nr][nc]==1) {
				dfs(nr,nc);
			}
		}
		
	}
}
