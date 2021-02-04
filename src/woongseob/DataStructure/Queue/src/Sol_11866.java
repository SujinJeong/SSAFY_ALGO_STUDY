package study_0125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sol_11866 {
	static int K, N;
	
	public static void main(String[] args) throws IOException {
		Queue<Integer> q = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		StringBuilder ans = new StringBuilder();
		K = Integer.parseInt(stk.nextToken());
		N = Integer.parseInt(stk.nextToken());
		for(int i = 1 ; i <= K; i++) {
			q.offer(i);
		}
		
		int loop = 0;
		ans.append('<');
		while(!q.isEmpty()) {
			loop++;
			if(loop == N) {
				if(q.size() == 1) {
					ans.append(Integer.toString(q.peek())).append('>');
				}else {
					ans.append(Integer.toString(q.peek())).append(", ");
				}
				q.poll();
				loop = 0;
			}
			else {
				q.offer(q.peek());
				q.poll();
			}
		}
		
		System.out.println(ans);
	}
}
