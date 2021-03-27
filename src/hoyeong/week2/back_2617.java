package hoyeong.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_2617 {
	static int N,M;
	static boolean [][] map;
	static boolean [][] map_r;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new boolean [N][N];
		map_r = new boolean [N][N];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			map[a][b] = true;
			map_r[b][a] = true;
		}
		
		floid();
		int cnt, cnt_r, result=0;
		for(int i=0; i<N; i++) {
			cnt=0; 
			cnt_r=0;
			for(int j=0; j<N; j++) {
				if(map[i][j]) cnt++;
				if(map_r[i][j]) cnt_r++;
			}
			if(cnt>N/2 || cnt_r>N/2) result++;
		}
		System.out.println(result);
	}
	private static void floid() {
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][k] && map[k][j]) map[i][j]=true;
				}
			}
		}
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map_r[i][k] && map_r[k][j]) map_r[i][j] = true;
				}
			}
		}
	}
}





//---------------------------------------------------------------------

/*package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class back_2617 {
	static int N;
	static LinkedList<Integer>[] list;
	static LinkedList<Integer>[] list_r;
	static boolean[] check;
	static int cnt=0;
	static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		list = new LinkedList[N+1];
		list_r = new LinkedList[N+1];
		check = new boolean[N+1];
		for(int i=0; i <=N; i++) {
            list[i] = new LinkedList<Integer>();
            list_r[i] = new LinkedList<Integer>();
        }
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			list[num1].add(num2);
			list_r[num2].add(num1);
		}
		
		
		for(int i=1; i<=N; i++) {
			cnt=0;
			System.out.println(i);
			Arrays.fill(check, false);
			dfs(i,list);
			System.out.println("cnt: "+cnt);
			if(cnt>=(N+1)/2) {
				result++;
				continue;}
			
			cnt=0;
			Arrays.fill(check, false);
			dfs(i,list_r);
			System.out.println("cnt: "+cnt);
			if(cnt>=(N+1)/2) result++;
			
		}
		System.out.println(result);
	}
	
	private static void dfs(int node, LinkedList<Integer>[] list) {
		if(check[node]) return;
		check[node]=true;
			
		for(int x:list[node]) {
				System.out.println(x+" "+cnt);
				dfs(x,list);
				cnt++;
			}
		}
}
	

*/