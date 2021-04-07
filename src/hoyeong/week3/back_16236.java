package hoyeong.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class shark{
	int r,c,cnt;

	public shark(int r, int c, int cnt) {
		super();
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}
}
public class back_16236 {
	static int N, start_r, start_c, size=2, result, INF =987654321;
	static int [][] map;
	static boolean [][] visited;
	static Queue<shark> q = new LinkedList<>();
	static final int [] dr = {-1,1,0,0};
	static final int [] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int [N][N];
		visited = new boolean [N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					start_r = i;
					start_c = j;
					map[i][j]=0;
				}
			}
		}
		bfs();
		System.out.println(result);
		
	}
	private static void bfs() {
		int cnt=0;
		while(true) {
			if(cnt == size) {
				size++;
				cnt=0;
			}
			for(boolean [] row : visited)
				Arrays.fill(row, false);
			visited[start_r][start_c]=true;
			q.add(new shark(start_r,start_c,0));
			if(!Can()) break;
			cnt++;
		}
	}
	private static boolean Can() {
		int save=INF;
		int save_r=INF;
		int save_c=INF;
		boolean check = false;
		
		while(!q.isEmpty()) {
			shark s = q.poll();
			int r = s.r;
			int c = s.c;
			int cnt = s.cnt;
			
			if(map[r][c]!=0 && map[r][c]<size) {
				check=true;
				if(cnt < save) {
					save = cnt;
					save_r = r;
					save_c = c;
				}
				else if(cnt==save) {
					if(r < save_r) {
						save_r = r;
						save_c = c;
					}
					else if(r == save_r) {
						if(c < save_c) {
							save_c = c;
						}
					}
				}
				continue;
			}
			
			for(int dir=0; dir<4; dir++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
				if(!visited[nr][nc] && map[nr][nc]<=size) {
					visited[nr][nc] = true;
					q.add(new shark(nr,nc,cnt+1));
				}
			}
			
		}
		if (check) {
			map[save_r][save_c] = 0;
			start_r = save_r;
			start_c = save_c;
			result += save;
		}
		
		return check;
	}
}
