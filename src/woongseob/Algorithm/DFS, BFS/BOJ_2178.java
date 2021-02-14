package study_0208;

import java.io.*;
import java.util.*;

public class BOJ_2178 {
	static int N, M;
	static int[] dy = {1,0,-1,0};
	static int[] dx = {0,1,0,-1};
	static int[][] arr;
	static boolean[][] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visit = new boolean[N][M];
		for(int i = 0 ; i < N ; i++) {
			String s = br.readLine();
			for(int j = 0 ; j < M; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		System.out.println(bfs());
	}
	
	static class POS{
		int y;
		int x;
		int cnt;
		public POS(int y, int x, int cnt) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}
	
	private static int bfs() {
		Queue<POS> q = new LinkedList<POS>();
		q.offer(new POS(0,0,1));
		
		while(!q.isEmpty()) {
			POS temp = q.poll();
			if(temp.y == N - 1 && temp.x == M - 1) {
				return temp.cnt;
			}
			for(int i = 0 ; i < 4; i ++) {
				int ny = temp.y + dy[i];
				int nx = temp.x + dx[i];
				if(ny < 0 || nx < 0 || ny >= N || nx >= M) {
					continue;
				}
				if(!visit[ny][nx] && arr[ny][nx] == 1) {
					visit[ny][nx] = true;
					q.offer(new POS(ny, nx, temp.cnt + 1));
				}
			}
		}
		return -1;
	}
}
