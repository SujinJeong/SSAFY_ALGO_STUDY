package hoyeong.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class b_2917{
	int r,c;

	public b_2917(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}

public class back_2917 {
	static int N,M,Start_r,Start_c,Dest_r,Dest_c;
	static char [][] map;
	static int [][] dis;
	static boolean [][] visited;
	final static int [] dr ={0,0,-1,1};
	final static int [] dc ={-1,1,0,0};
	static Queue<b_2917> q = new LinkedList<b_2917>(); // bfs에서 쓸 queue
	static Queue<b_2917> tree = new LinkedList<b_2917>(); // 트리 저장 queue
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		dis = new int [N][M];
		visited = new boolean[N][M];
		
		for (int[] row : dis) {
			Arrays.fill(row, -1);
		}
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j]=='+') {
					tree.add(new b_2917(i, j));
					dis[i][j] = 0;
				}
				else if(map[i][j]=='V') {
					Start_r = i;
					Start_c = j;
				}
				else if(map[i][j]=='J') {
					Dest_r = i;
					Dest_c = j;
				}
			}
		}
		while(!tree.isEmpty()) { // 나무로부터 최단거리 구하기 (핵심)
			b_2917 t = tree.poll();
			int r = t.r;
			int c = t.c;
			for(int dir =0; dir<4; dir++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				if(dis[nr][nc]==-1) {
					dis[nr][nc] = dis[r][c]+1;
					tree.add(new b_2917(nr, nc));
				}
			}
		}
		
		int result = 0;
			
		int low = 1, high = dis[Start_r][Start_c];
		while (low <= high) {
			int mid = (low + high) / 2; // 거리차이

			if (bfs(mid)) { // 갈수 있으면
				result = Math.max(result, mid);
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		System.out.println(result);
	}

	private static boolean bfs(int mid) {
		q.clear();
		q.add(new b_2917(Start_r,Start_c));
		for (boolean[] row : visited) {
			Arrays.fill(row, false);
		}
		
		while (!q.isEmpty()) {
			b_2917 b = q.poll();
			if (b.r == Dest_r && b.c == Dest_c)
				return true;
			
			for (int dir = 0; dir < 4; dir++) {
				int nr = b.r + dr[dir];
				int nc = b.c + dc[dir];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;
				if (!visited[nr][nc] && (map[nr][nc] == '.' || map[nr][nc]=='J') && dis[nr][nc]>=mid) {					
					visited[nr][nc] = true;
					q.add(new b_2917(nr, nc));
				}
			}
		}
		return false;
	}
}
