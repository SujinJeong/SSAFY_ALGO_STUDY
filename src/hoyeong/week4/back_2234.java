package hoyeong.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Dot{
	int r;
	int c;
	public Dot(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}

public class back_2234 {
	static int N,M, room=1, max,cnt;
	static int [][] map;
	static int [][] visited;
	static Queue <Dot> q = new LinkedList<>();
	static ArrayList<Integer> list = new ArrayList<>();
	final static int [] dr = {0,-1,0,1};
	final static int [] dc = {-1,0,1,0};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(visited[i][j]==0) {
					cnt=1;
					move(i,j);
					room++;
					list.add(cnt);
				}
			}
		}
		
		near();
		
		Collections.sort(list);
		System.out.println(list.size());
		System.out.println(list.get(list.size()-1));
		System.out.println(max);
		
	}
	private static void move(int r, int c) {
			visited[r][c] = room;
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;

				if (((map[r][c] & (1 << i)) == 0) && visited[nr][nc]==0) {
					cnt++;
					move(nr, nc);
				}
			}
	}
	
	private static void near() {
		max = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				
				for(int k=0; k<4; k++) {
					int nr = i + dr[k];
					int nc = j + dc[k];

					if (nr < 0 || nc < 0 || nr >= N || nc >= M)
						continue;
					
					if(visited[i][j]!=visited[nr][nc]) {
						max = Math.max(max, (list.get(visited[nr][nc]-1)+list.get(visited[i][j]-1)) );						
					}
				}
			}
		}
	}
}
