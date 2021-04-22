package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_14503 {
	static int N,M, start_N, start_M, start_dir, cnt=1;
	static int[][] map;
	static boolean[][] visited;
	final static int [] dr = {-1,0,1,0};
	final static int [] dc = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int [N][M];
		visited = new boolean [N][M];
		st = new StringTokenizer(br.readLine());
		start_N = Integer.parseInt(st.nextToken());
		start_M = Integer.parseInt(st.nextToken());
		start_dir = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited[start_N][start_M]=true;
		clean(start_N, start_M, start_dir);
		System.out.println(cnt);
	}
	
	private static void clean(int r, int c, int dir) {
		int no=0;
			
		while(true) {
			dir--;
			if(dir<0) dir=3;
			
			int nr = r+dr[dir];
			int nc = c+dc[dir];
			
			if(nr<0 || nc<0 || nr>=N || nc>=M) continue;
			
			if(!visited[nr][nc] && map[nr][nc]!=1) { // a
				visited[nr][nc] = true;
				r = nr;
				c = nc;
				cnt++;
				no=0;
			}
			
			else if(no==4) { // c,d
				dir++;
				if(dir==4) dir=0;
				r = r-dr[dir];
				c = c-dc[dir];
				no=0;
				if(map[r][c]==1) break;
				
			}
			
				
			else if(visited[nr][nc] || map[nr][nc]==1) { // b
				no++;
			}
						
		}
	}
}
