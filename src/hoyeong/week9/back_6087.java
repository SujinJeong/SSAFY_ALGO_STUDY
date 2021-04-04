package hoyeong.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//진행 방향이 바뀔 때 거울 세움
class Dot{
	int r,c,cnt,cur;

	public Dot(int r, int c, int cnt, int cur) {
		super();
		this.r = r;
		this.c = c;
		this.cnt = cnt;
		this.cur = cur;
	}
	
}
public class back_6087 {
	static int W,H,start_r,start_c,des_r,des_c,result=987654321;
	static char [][] map;
	static int [][] visited;
	final static int [] dr = {-1,1,0,0};
	final static int [] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new char[H][W];
		visited = new int[H][W];
		boolean check = false;
		for(int i=0; i<H; i++) {
			String str = br.readLine();
			for(int j=0; j<W; j++) {
				map[i][j] = str.charAt(j);
				visited[i][j] = 987654321; // 다익스트라의 개념 당겨씀
				if(map[i][j]=='C') {
					if(!check) {
						check = true;
						start_r = i;
						start_c = j;
					}
					else {
						des_r = i;
						des_c = j;
					}
				}
			}
		}
		bfs();
		System.out.println(result);
	}
	private static void bfs() {
		Queue<Dot> q = new LinkedList<>();
		visited[start_r][start_c] = 0;
		q.add(new Dot(start_r,start_c,0,0));
		
		while(!q.isEmpty()) {
			Dot d = q.poll();
			int r = d.r;
			int c = d.c;
			int cnt = d.cnt;
			int cur = d.cur;
			
			if(r==des_r && c==des_c) {
				result = Math.min(result, cnt);
				continue;
			}
			
			for(int dir=0; dir<4; dir++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				if(nr<0 || nc<0 || nr>=H || nc>=W || map[nr][nc]=='*') continue;
				
				int next_c = cnt; // 이전 방향과 같다면 cnt 동일
				if(dir != cur) next_c++; // 이전의 방향과 다르다면 cnt++
				if(visited[nr][nc]<next_c) continue; // 다음으로 갈 곳의 visited값이 더 작다면 갈필요없음
				visited[nr][nc] = next_c;
				if(r==start_r && c==start_c) { // 시작점에서 다음칸으로 갈 때는 무조건 cnt 0 
					q.add(new Dot(nr,nc,cnt,dir));
					continue;
				}
				q.add(new Dot(nr,nc,next_c,dir));
			}
			
		}
	}
}
