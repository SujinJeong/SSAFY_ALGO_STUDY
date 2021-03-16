package study_0309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1486 {
	static final int INF = 987654321;
	static int N, M, T, D;
	static int[] dy = { 1, -1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };
	static int[][] arr, map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		map = new int[N * M][N * M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				if (s.charAt(j) >= 'A' && s.charAt(j) <= 'Z') {
					arr[i][j] = s.charAt(j) - 'A';
				} else {
					arr[i][j] = s.charAt(j) - 'a' + 26;
				}
			}
		}

		floyd();
		int ans = 0;
		for (int i = 0; i < N * M; i++) {
			if (map[0][i] + map[i][0] <= D) {
				ans = Math.max(ans, arr[i / M][i % M]);
			}
		}
		System.out.println(ans);
	}

	private static void floyd() {
		int size = N * M;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i != j) {
					map[i][j] = INF;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for(int k = 0 ; k < 4; k++) {
					int ny = i + dy[k];
					int nx = j + dx[k];
					int start = i * M + j;
					int dest = ny * M + nx;
					if (ny < 0 || nx < 0 || ny >= N || nx >= M) { continue; }
					int diff = Math.abs(arr[ny][nx] - arr[i][j]);
					if (diff > T) { continue; }
					if (arr[ny][nx] > arr[i][j]) {
						map[start][dest] = diff * diff;
					}
					else {
						map[start][dest] = 1;
					}
				}
			}
		}
		
		for (int i = 0; i < N * M; i++) {
			for (int j = 0; j < N * M; j++) {
				for (int k = 0; k < N * M; k++) {
					map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
				}
			}
		}
	}
}
