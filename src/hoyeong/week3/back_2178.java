package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_2178 {
	public static class Dot {
		int c, r;

		public Dot(int c, int r) {
			super();
			this.c = c;
			this.r = r;
		}
	}
	
	static int N,M;
	static int [][] map;
	static boolean[][] visited;
	final static int[] dr = {1,0,-1,0};
	final static int[] dc = {0,1,0,-1};
	static Queue<Dot> q = new LinkedList<Dot>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
		
		for(int i=1; i<=N; i++) {
			String str = br.readLine();
			for(int j=1; j<=M; j++) {
				map[i][j]= (int)(str.charAt(j-1)-'0');
			}
		}
		bfs();
		System.out.println(map[N][M]);
	}
	
	public static void bfs() {
		int c=1, r=1, dir=0;
		while(c!=M || r!=N) {
			int nr=0, nc=0;
			for(dir=0; dir<4; dir++) {
				nr = r+dr[dir];
				nc = c+dc[dir];
				if(nr<1 || nc<1 || nr>N || nc>M) continue; // 범위 벗어나면
						
				if(map[nr][nc]==1 && !visited[nr][nc]) {
					visited[r][c]=true;
					q.add(new Dot(nc,nr));
					map[nr][nc] = map[r][c]+1;
				}	
			}
			c = q.peek().c;
			r = q.peek().r;	
			q.poll();
			}
		}
	}

