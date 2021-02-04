package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_12851 {
	public static int N, K;
	public static boolean []visited = new boolean[100002];
	public static int calc(int x, int num) {
		if (num == 1)
			return x - 1;
		else if (num == 2)
			return x + 1;
		else
			return x * 2;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q =new LinkedList<>();
		q.add(N);
		visited[N] = true;
		int time = 0;
		int res = 0;
		boolean token = false;
		while(!q.isEmpty()) {
			int qSize = q.size();			
			for(int i=0; i<qSize; ++i) {
				int front = q.poll();
				if(front == K) {
					res++;		
					token = true;
				}
				visited[front] = true;
				for(int j=1; j<=3; ++j) {
					int num = calc(front, j);
					if(num<0 || num >100000) 
						continue;
					if(visited[num])
						continue;
					q.add(num);
				}
			}
			if(token) break;
			time++;
		}
		System.out.println(time);
		System.out.println(res);
	}
}
