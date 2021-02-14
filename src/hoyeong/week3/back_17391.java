package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class input {
	int r;
	int c;
	int cnt;

	public input(int r, int c, int cnt) {
		super();
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}

}

public class back_17391 {
	static int N, M, r, c, result=0;
	static int[][] map;
	static boolean[][] visited;
	final static int[] dr = { 1, 0 };
	final static int[] dc = { 0, 1 };
	static Queue<input> q = new LinkedList<>();
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		q.add(new input(0, 0, 1));
		bfs();
		Collections.sort(list);
		System.out.println(list.get(0));
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			input node = q.poll();
			r = node.r;
			c = node.c;
			for (int i = 1; i <= map[r][c]; i++) {
				for (int dir = 0; dir < 2; dir++) {
					int nr = r + i * dr[dir];
					int nc = c + i * dc[dir];

					if (nr >= N || nc >= M)
						continue;

					if (!visited[nr][nc]) {
						visited[nr][nc] = true;
						q.add(new input(nr, nc, node.cnt + 1));
					}
					
					if (nr == N - 1 && nc == M - 1) {
						list.add(node.cnt);
					}
				}
			}
		}
	}
}

