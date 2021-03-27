package hoyeong.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class back_9466 {
	static int N, cnt,INF=987654321,team;
	static int[] arr;
	static int[][] cycle;
	static boolean [] visited;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			
			N = Integer.parseInt(br.readLine());
			visited = new boolean[N+1];
			arr = new int[N+1]; 
			cycle = new int[2][N+1]; 
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				arr[i]=Integer.parseInt(st.nextToken());		        
			}
			team=0; 
			int group=0;
			for(int i=1; i<=N; i++) {
				if(!visited[i]) {
					group++;
					dfs(i, 1, group);
				}
			}
			sb.append(N-team+"\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int k,int cnt,int group) {
		if(!visited[k]) {
			visited[k]=true;
			if(arr[k]==k) {
				team++;
				return;
			}
			if(cycle[0][arr[k]]!=0 && cycle[1][arr[k]]==group) {
				team += cnt-cycle[0][arr[k]]+1;
				return;
			}
			else {
				cycle[0][k] = cnt++;
				cycle[1][k] = group;
				if(visited[arr[k]]) return;
				dfs(arr[k],cnt,group);
			}
		}
	}
}

