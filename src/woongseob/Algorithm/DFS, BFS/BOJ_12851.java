package study_0201;

import java.io.*;
import java.util.*;

public class BOJ_12851 {
	static int N, K, ans, cnt;
	static boolean visit[] = new boolean[100001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		bfs(N);
		System.out.println(ans);
		System.out.println(cnt);
	}
	
	static public class Info {
		int n;
		int s;
		public Info(int n, int s) {
			super();
			this.n = n;
			this.s = s;
		}
	}
	
	static public void bfs(int start) {
		Queue<Info> q = new LinkedList<Info>();
		int time = 0, curr;
		q.offer(new Info(start, time));
		while (!q.isEmpty()) {
			Info temp = q.poll();
			curr = temp.n;
			time = temp.s;
			if(curr == K) {
				if(ans == 0) {
					ans = time;
				}
				else {
					if(time != ans) break;					
				}
				cnt++;
			}
			
			visit[curr] = true;
			
			if(curr - 1 >= 0 && !visit[curr - 1]) {
				q.offer(new Info(curr - 1, time + 1));
			}
			if(curr + 1 <= 100000 && !visit[curr + 1]) {
				q.offer(new Info(curr + 1, time + 1));
			}
			if(curr * 2 <= 100000 && !visit[curr * 2]) {
				q.offer(new Info(curr * 2, time + 1));
			}
		}
	}
}
