package sujin.Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
LCA(Lowest Common Ancestor) 푸는 방법
1. 아래에서 위로 올라가는 방식
2. 두 정점의 높이를 맞춰준다(깊이를 맞춰줌)
3. 하나씩 똑같이 올라가면서 같은 정점(=공통 조상)나올때까지 반복
 */

public class Q3584 {
	static int N;
	static int a, b;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			// input
			N = Integer.parseInt(br.readLine());
			// 부모 정점 저장
			parent = new int[N + 1];

			// 간선은 점개수-1
			for (int i = 0; i < N - 1; i++) {
				String[] line = br.readLine().split(" ");
				int a = Integer.parseInt(line[0]);
				int b = Integer.parseInt(line[1]);
				// a가 b의 부모
				parent[b] = a;
			}

			// 공통 조상을 구할 두 노드
			String[] line2 = br.readLine().split(" ");
			a = Integer.parseInt(line2[0]);
			b = Integer.parseInt(line2[1]);

			int a_depth = get_depth(a);
			int b_depth = get_depth(b);

			// 찾은공통조상 출력
			sb.append(LCA(a, a_depth, b, b_depth) + "\n");
		}
		System.out.println(sb);
	}

	static int LCA(int a, int a_depth, int b, int b_depth) {
		
		// a와 b의 높이가 같아질때까지 올려주기 = 높이 맞춰주기
		if (a_depth > b_depth) {
			while (a_depth-- != b_depth)
				a = parent[a];
		} else if (a_depth < b_depth) {
			while (a_depth != b_depth--)
				b = parent[b];
		}

		// 높이 맞춰줬으니 부모따라 하나씩 올라가면서 최소 공통조상 찾기
		while (a != b) {
			a = parent[a];
			b = parent[b];
		}

		return a;
	}

	// 루트노드(parent값이 0)까지 올라가면서 현재 깊이 찾기
	static int get_depth(int n) {
		int cnt = 0;
		while (true) {
			n = parent[n];
			cnt++;
			if (n == 0)
				break;
		}
		return cnt;
	}

}
