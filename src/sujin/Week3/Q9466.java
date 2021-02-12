package sujin.Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9466 {
	static int[] map;
	static int[] startVertex;
	static int[] vertextCnt;

	static int dfs(int start, int current, int cnt) {
		// 방문한적이 있는 경우, vertexCnt에는 본인이 몇번쨰 depth인지 저장되어있음
		if (vertextCnt[current] > 0) {
			// 시작정점이 다른경우 = 사이클이 아님
			if (startVertex[current] != start)
				return 0;
			// 시작정점이 같은경우
			else return cnt - vertextCnt[current];
		}

		else { // 방문한적이 없는 경우
			// 본인에서부터 새로운 사이클이 시작되기 때문에 시작 정점 설정
			startVertex[current] = start;
			vertextCnt[current] = cnt;
			// 시작정점은 똑같이 넘겨주고 같은 시작정점에서 시작하는 카운트 늘려주기
			return dfs(start, map[current], cnt + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			map = new int[N + 1];
			vertextCnt = new int[N + 1];
			startVertex = new int[N + 1];

			String[] line = br.readLine().split(" ");

			for (int j = 1; j <= N; j++)
				map[j] = Integer.parseInt(line[j - 1]);

			int cnt = 0;
			for (int j = 1; j <= N; j++) {
				// 방문한적이 없는 경우 dfs 탐색
				if (vertextCnt[j] == 0)
					cnt += dfs(j, j, 1);
			}
			sb.append(N - cnt + "\n");
		}

		System.out.println(sb);
	}
}