package study_0208;

import java.io.*;
import java.util.*;

public class BOJ_17391 {
	static int N, M;
	static int[][] arr;
	static boolean[][] visit;

	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
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
		q.offer(new POS(0,0,0));
		while(!q.isEmpty()) {
			POS temp = q.poll();
			if(temp.y == N -1 && temp.x == M - 1) {
				return temp.cnt;
			}
			int loop = arr[temp.y][temp.x];
			for(int i = 1; i <= loop; i++) {
				int ny = temp.y + i * 1;
				if(ny < N && !visit[ny][temp.x]) {
					visit[ny][temp.x]= true;
					q.offer(new POS(ny, temp.x, temp.cnt + 1));
				}
				int nx = temp.x + i * 1;
				if(nx < M && !visit[temp.y][nx]) {
					visit[temp.y][nx] = true;
					q.offer(new POS(temp.y, nx, temp.cnt + 1));
				}
			}
		}
		return 0;
	}
}
