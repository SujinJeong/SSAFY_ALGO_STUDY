package hoyeong.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class back_7576 {
	static StringBuilder sb = new StringBuilder();
	final static int[] dc = {-1,1,0,0};
	final static int[] dr = {0,0,-1,1};
	static LinkedList<input2> [] list;
	static Queue<input2> q;
	static int row;
	static int col;
	static int [][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new int[col][row];
		q = new LinkedList<>();
		for(int i=0; i<col; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<row; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) q.add(new input2(i,j));
				}
			}
		bfs(q);
		}

	public static void bfs(Queue<input2> q) {

		while(!q.isEmpty()) {
			input2 input2 = q.poll();
			
			for(int i=0; i<4; i++) {
				int nc = input2.a + dc[i];
				int nr = input2.b + dr[i];
				
				if(nc<0 || nr<0 || nc>=col || nr>=row) continue;
				
				if(map[nc][nr]!=0) continue;
				
				q.add(new input2(nc,nr));
				map[nc][nr]=map[input2.a][input2.b]+1;
				
			}
		}
		int max=Integer.MIN_VALUE;
		for(int i=0; i<col;i++) {
			for(int j=0; j<row; j++) {
				if(map[i][j]==0) {
					System.out.println(-1);
					return;
				}
				max=Math.max(max,map[i][j]);
			}
		}
		System.out.println(max-1);
	}

}
