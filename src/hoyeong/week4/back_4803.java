package hoyeong.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class back_4803 {
	static int N,M,result,cnt,num=0,t,no,bra;
	static LinkedList<Integer> [] list;
	static boolean [] visited;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			t=0;
			num++;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		if(N==0 && M==0) break;
		
		list = new LinkedList[N+1];
		visited = new boolean [N+1];
		
		for(int i=0; i<=N; i++) {
			list[i] = new LinkedList<Integer>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int node = Integer.parseInt(st.nextToken());
			int branch  = Integer.parseInt(st.nextToken());
			list[node].add(branch);
			list[branch].add(node);
		}
		
			for (int j = 1; j <= N; j++) {
				if (!visited[j]) {
					no=0;
					bra=0;
					tree(j);
					if(no-1==bra/2) t++;
				}
			}
		
		if(t==0) sb.append("Case "+num+": No trees.\n");
		else if(t==1) sb.append("Case "+num+": There is one tree.\n");
		else sb.append("Case "+num+": A forest of "+t+" trees.\n");
		
		}
		System.out.println(sb.toString());
	}
	
	
	private static void tree(int node) {
		if (!visited[node]) {
			no++;
			visited[node] = true;
			for (int x : list[node]) {
				bra++;
				tree(x);
			}
		}
	}
}
