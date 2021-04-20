package sujin.Floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11403 {
	static int[][] adj;
	static int n;

	public static void floyd() {

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
						if (adj[i][k] == 1 && adj[k][j] == 1)
							adj[i][j] = 1;
				}
			}
		}
	}

	public static StringBuilder print() {
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) 
				sb.append(adj[i][j] + " ");
			sb.append("\n");
		}

		return sb;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		adj = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		floyd();
		System.out.println(print());
	}

}
