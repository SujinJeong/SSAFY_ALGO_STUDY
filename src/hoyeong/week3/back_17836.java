package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class input2{
	int r;
	int c;
	int cnt;
	public input2(int r, int c, int cnt) {
		super();
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}
}

public class back_17836 {
	static int N, M, T, r=0, c=0, result;
	static int [][] map;
	static boolean [][] visited;
	static Queue <input2> q = new LinkedList<>();
	static List<Integer> list = new ArrayList<>();
	final static int [] dr = {1,0,-1,0};
	final static int [] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean [N][M];
		for(int i=0; i<N; i++) { 		//입력
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] =  Integer.parseInt(st.nextToken());
			}
		}
		
		q.add(new input2(0,0,0));
		bfs();
		
		Collections.sort(list); // 검 찾았을 때와 못찾았을 때 비교
		
		if(list.size()==0) System.out.println("Fail"); // 공주를 찾으러 가지 못했을 경우
		else if(list.get(0) >= 1 && list.get(0)<=T) System.out.println(list.get(0)); // 공주를 찾았을 경우 시간 비교
        else System.out.println("Fail"); // 공주를 찾았는데 시간이 넘은 경우
	}
	
	private static void bfs() {
		
		while(!q.isEmpty()) {
			input2 node = q.poll();
			r = node.r;
			c = node.c;
			
			if(r==N-1 && c==M-1) { // 검 없이 갔을 때의 최단거리
				result = node.cnt;
				list.add(result);
				break;
			}
			
			for(int dir=0; dir<4; dir++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				
				if(nc<0 || nr<0 || nc>=M || nr>=N) continue;
				
				if(!visited[nr][nc] && map[nr][nc]!=1) {
					visited[nr][nc] = true;
					q.add(new input2(nr,nc,node.cnt+1));
					if(map[nr][nc]==2) {	// 검을 찾았을 때 최단거리 예측
						result = (node.cnt+1 + (N-1-nr)+ (M-1-nc));
						list.add(result);
					}
				}
			}
		}
	}
}

/*
검 가지고 갔을 때 최단거리 vs 검 없이 갔을 때 최단거리
 */
