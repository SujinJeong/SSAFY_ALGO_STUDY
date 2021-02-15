package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class back_9466 {
	static int N, cnt;
	static int[] arr;
	static boolean visited[];
	static boolean team[];
	static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			
			N = Integer.parseInt(br.readLine());
			visited = new boolean[N+1];
			team = new boolean[N+1];
			arr = new int[N+1]; 
			
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<N+1; j++) {
				arr[j]=Integer.parseInt(st.nextToken());		        
			}
			
			cnt=0;
			for(int k=1; k<=N; k++) {
				if(!visited[k]) {
					list.clear();
					dfs(k);
				}
			}
			
			sb.append(N-cnt+"\n");
		}
		System.out.println(sb.toString());
	}

	private static void dfs(int k) {
		if (!visited[k]) {
			visited[k] = true;
			list.add(k);
			if (list.contains(arr[k])) {
				cnt+=list.size()-list.indexOf(arr[k]);
			}
			else dfs(arr[k]);
		}
	}
}

