package hoyeong.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Dot{
	int r,c;

	public Dot(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}
public class back_2638 {
	static int N,M,result;
	static int [][] map;
	static int [][] air;
	final static int [] dr = {-1,1,0,0};
	final static int [] dc = {0,0,-1,1};
	static Queue<Dot> q = new LinkedList<>(); // 공기 판단
	static Queue<Dot> ch = new LinkedList<>(); // 치즈 판단
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int [N][M];
		air = new int [N][M]; // 가보지 않은곳 0, 공기 1, 체크2;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					ch.add(new Dot(i, j));
				}
			}
		}
		result=0;
		while(!ch.isEmpty()) {
			result++;
			bfs();
			CHEEZE();
		}
		System.out.println(result);
	}
	private static void bfs() {
		for(int [] row : air) {
			Arrays.fill(row, 0);
		}
		q.add(new Dot(0,0));
		while (!q.isEmpty()) {
			int r = q.peek().r;
			int c = q.peek().c;
			q.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				if(nr<0 || nc<0 || nr>=N || nc>=M) continue;
				if(air[nr][nc]==0 && map[nr][nc]==0) {
					air[nr][nc] = 1;
					q.add(new Dot(nr,nc));
				}
			}
			
		}
	}
	private static void CHEEZE() {
		int l = ch.size();
		int cnt=0;
		outloop:while (!ch.isEmpty()) {
			if(cnt==l) {
				break;
			}
			cnt++;
			int check=0;
			int r = ch.peek().r;
			int c = ch.peek().c;
			ch.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				if(nr<0 || nc<0 || nr>=N || nc>=M) continue;
				if(air[nr][nc]==1 && map[nr][nc]==0) {
					check++;
					if(check<2) { // 공기와 접촉 면의 갯수
						continue;
					}
					else { // 공기와 접촉이 2면 이상
						map[r][c] = 0;
						continue outloop;
					}	
				}
			}
			ch.add(new Dot(r,c));
		}
	}
}


