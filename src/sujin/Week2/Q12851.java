package sujin.Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
1. bfs의 종료 기준 = 시간! 시간이 min보다 크면 더이상 볼 필요가 없다
2. 큐에서 값을 꺼내고 방문처리 (모든 경우의 수를 따지기 위해 넣을 때 방문처리 하는 것이 아니라 뺄때)
3. 꺼낸 값이 동생 위치와 같을 경우 min값 계산 ( 시간과 min값 중 작은 값 min값에 대입, min값과 시간이 같다면 다른 경우의 수이므로 cnt 증가 )
4. visited가 false이고 N의 가능 범위 0~100000내에 있는 경우 큐에 넣고 방문
 */
public class Q12851 {
	static int min = Integer.MAX_VALUE;
	static int cnt = 1;
	static Queue<Info> q = new LinkedList<Info>();
	static int N, K;
	
	public static int bfs() {
		boolean[] visited = new boolean[100001];
		
		while(!q.isEmpty()) {
			Info i = q.poll();
			
			// 잡았다 동생!
			if (i.x == K) {
				// 경우의 수가 1개 이상인 경우
				if (min == i.time)
					cnt++;
				// 최소 시간 갱신
				else min = Math.min(min, i.time);
				// 다른 경우의 수가 있을 수 있으므로 break가 아니라 continue
				continue;
			}
			
			visited[i.x] = true;
			
			// 잡지 못한경우 잡으러 이동
			// 순서대로 인식하기 때문에 범위 계산을 앞에 넣어줘야 한다
			if (i.x+1 <= 100000 && !visited[i.x + 1]  )
				q.offer(new Info(i.x+1, i.time+1));
			if (i.x-1 >= 0 && !visited[i.x - 1])
				q.offer(new Info(i.x-1, i.time+1));
			if (i.x*2 <= 100000 && !visited[i.x*2]  )
				q.offer(new Info(i.x*2, i.time+1));
		}
		return min;
	}
	
	public static class Info {
		public int x;
		public int time;
		
		public Info(int x, int time) {
			super();
			this.x = x;
			this.time = time;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// 초기좌표 큐에 push
		q.offer(new Info(N, 0));
		System.out.println(bfs());
		System.out.println(cnt);
	}

}
