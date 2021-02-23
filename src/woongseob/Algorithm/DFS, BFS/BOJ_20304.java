package study_0215;

import java.io.*;
import java.util.*;

public class BOJ_20304 {
	static int N, M;
	static boolean[] visit;
	static Queue<Pass> q = new LinkedList<Pass>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		visit = new boolean[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());		
		for(int i = 0 ; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			visit[num] = true;
			q.offer(new Pass(num, 0));
		}
		System.out.println(bfs());	
	}
	
	static class Pass{
		int num;
		int len;
		public Pass(int num, int len) {
			super();
			this.num = num;
			this.len = len;
		}
		
	}
	
	private static int bfs() {
		Pass ret = null;
		while(!q.isEmpty()) {
			ret = q.poll();
			
			int bitLen = 1;
			while((1 << bitLen) < N) {
				bitLen++;
			}
			
			for(int i = 0; i <= bitLen; i++) {
				int changeOne = ret.num ^ (1 << i);
				if(changeOne <= N && !visit[changeOne]) {
					visit[changeOne] = true;
					q.offer(new Pass(changeOne, ret.len + 1));
				}
			}
		}
		return ret.len;
	}
}
