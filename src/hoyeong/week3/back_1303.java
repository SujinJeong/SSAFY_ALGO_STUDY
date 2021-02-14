package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class back_1303 {
	static int N,M,r,c,cnt_W,cnt_B, sum_W=0, sum_B=0;
	static char[][] map;
	static boolean[][] visited;
	final static int dr[] = {1,0,-1,0};
	final static int dc[] = {0,1,0,-1};
	static int max;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[M][N];
		visited = new boolean[M][N];
		for(int i=0; i<M; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		for(int i=0; i<M; i++) {
			for(int j=0; j<N;j++) {
				if(!visited[i][j]) {
					cnt_W=0;
					cnt_B=0;
					dfs(i,j);
					if(map[i][j]=='W') {
						sum_W += cnt_W*cnt_W;
					}
					else if(map[i][j]=='B') {
						sum_B += cnt_B*cnt_B;
					}
				}
			}
		}
		System.out.println(sum_W+" "+sum_B);
	}
	
	public static void dfs(int r, int c) {
		visited[r][c]=true;
		if(map[r][c]=='W') cnt_W++;
		else if(map[r][c]=='B') cnt_B++;
		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if (nr < 0 || nc < 0 || nr >= M || nc >= N)
				continue;
			if (!visited[nr][nc] && map[r][c] == map[nr][nc]) { // 같은 팀일 때
				dfs(nr,nc);
			}
		}
	}
}