package hoyeong.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;


class Dot{
	int r,c;

	public Dot(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}
public class back_3190 {
	static int N,K,L;
	static boolean [][] map;
	final static int[] dr = {0,1,0,-1};
	final static int[] dc = {1,0,-1,0};
	static Deque <Dot> d = new ArrayDeque<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		map = new boolean[N+1][N+1];
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = true;
		}
		
		int cnt=0;
		int dir=0;
		int r=1, c=1;
		d.add(new Dot(1,1));
		
		L = Integer.parseInt(br.readLine());
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			char direction = st.nextToken().charAt(0);
			
			while(cnt!=t) {
				cnt++;
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				
				if(nr<=0|| nc<=0 || nr>N || nc>N ){ // 중지 
					System.out.println(cnt);
					System.exit(0);
				}
				
				for(Dot x:d) { // 
					if(nr == x.r && nc == x.c) {
						System.out.println(cnt);
						System.exit(0);
					}
				}
				
				r = nr;
				c = nc;
				
				d.addFirst(new Dot(nr,nc));
				if(map[nr][nc]) {
					map[nr][nc] = false;
					continue;
				}
				d.pollLast();				
			}
			
			if(direction =='D') {
				if(dir==3) dir=0;
				else dir++;
			}
			else {
				if(dir==0) dir=3;
				else dir--;
			}
		}
		while(true) {
			cnt++;
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			
			if(nr<=0|| nc<=0 || nr>N || nc>N ){ // 중지 
				System.out.println(cnt);
				System.exit(0);
			}
			
			for(Dot x:d) { // 
				if(nr == x.r && nc == x.c) {
					System.out.println(cnt);
					System.exit(0);
				}
			}
			r = nr;
			c = nc;
			d.addFirst(new Dot(nr,nc));
			if(map[nr][nc]) continue;
			d.pollLast();				
		}
	}

}




// 예전 코드----------------------------------------------------
/*package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class snake{
	int x;
	int y;
	public snake(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

class where{
	int c;
	String D;
	
	public where(int c, String d) {
		super();
		this.c = c;
		this.D = d;
	}
}

public class back_3190 {
	
	public static int direction;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Deque<snake> d = new ArrayDeque<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] Map = new int[N+1][N+1];
		int cnt=0; // 뱀이 이동한 횟수
		direction=90;
		int a = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<a; i++) {
			Map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]=2; //사과 셋팅
		}
		int c = Integer.parseInt(br.readLine());
		where[] arr = new where[c];
		for(int i=0; i<c; i++) {
			arr[i]= new where(Integer.parseInt(st.nextToken()),st.nextToken());
		}
		
		snake S = new snake(1,1);
		
		while(true) {
			switch (direction) {
			case 0: S.y++;break; 
			case 90: S.x++;break; 
			case 180: S.y--;break;
			case 270: S.x--;break;
			}
			if(S.x<=0 || S.x>=N || S.y>=N || S.y<=0)	break; // 뱀이 벽에 닿았을 때
		cnt++;
		d.addFirst(new snake(S.x,S.y));
		if(Map[S.x][S.y]==2) { //사과 만났을 때
			Map[S.x][S.y]=1;
			continue;
		}
		
		for(int i=0; i<c; i++) { // 방향 전환
			if(cnt==arr[i].c) {
				switch(arr[i].D) {
				case "D": direction = direction+90; break;
				case "L": {
					if(c-90<0) {direction = 270; break;}
					else direction=direction-90; break;
					}
				}
			}
		}
		Map[S.x][S.y]=1;
		d.pollLast();
		}
	}
}
*/