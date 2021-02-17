package ssafy_algo_0217;

import java.io.*;

public class BOJ_1992 {
	static int N;
	static char[][] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		sol(N, 0, 0);
		System.out.println(sb);
	}

	private static void sol(int size, int sy, int sx) {
		char start = arr[sy][sx];
		boolean divide = false;
		for (int i = sy; i < sy + size; i++) {
			for (int j = sx; j < sx + size; j++) {
				if (arr[i][j] != start) {
					divide = true;
					break;
				}
			}
		}
		if(divide) {
			sb.append("(");
			sol(size / 2, sy, sx);
			sol(size / 2, sy, sx + size / 2);
			sol(size / 2, sy + size / 2, sx);
			sol(size / 2, sy + size / 2, sx + size / 2);
			sb.append(")");
		}
		else {
			sb.append(start);
		}
	}
}
