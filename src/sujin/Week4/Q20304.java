package sujin.Week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
1. 흐름: bfs이용 안전도 0인거 다 탐색 -> 안전도 1인거 탐색-> 안전도 1에서 또 비트 1차이가 발생하면 2인 원리
2. 안전도 0인거 q에 싹다 넣어주고 비교, 그 다음 visited 처리후 안전도 1인거 싹다 q에 넣어주고 비교 .... 반복
 */
public class Q20304 {
	private static class Node {
		int num, count;

		Node(int num, int count) {
			this.num = num;
			this.count = count;
		}
	}

	static int N, M, result = 0;
	static boolean[] visit;
	static Queue<Node> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		visit = new boolean[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			// 해커가 입력한 비밀번호는 무조건 보안성 0이기 때문에 이것부터 넣어주기
			q.offer(new Node(tmp, 0));
			visit[tmp] = true;
		}
		
		
		//q는 최대 N번만큼 돌아가고, visited가 모두 true이면 q에 더이상 넣을 것이 없기 때문에 탈출
		while (!q.isEmpty()) {
			Node n = q.poll();
			// 보안성 가장 높은 결과 뽑기
			result = Math.max(result, n.count);
			
			// 비트 하나씩 밀면서 전부 다 바꿔보기 만약 1000 이면 4번의 연산이 일어남
			for (int t = 1; t <= N; t <<= 1) {
				int num;
				// 1-> 0으로 바꾸기
				if ((n.num & t) > 0)
					num = n.num-t;
				// 0-> 1로 바꾸기
				else
					num = n.num+t;
				
				// 비트를 바꿔줬는데 방문한적있거나 N 범위를 넘어갈경우
				if (num > N || visit[num]) continue;
				
				// 1~N중 방문한 숫자는 true로 변경
				visit[num] = true;
				// 새로 갱신된 안전도들을 다시 비교하여 더 큰 안전도를 찾기위해 안전도+1해서 q에 push
				q.add(new Node(num, n.count + 1));
			}
		}
		
		System.out.println(result);
	}

}

