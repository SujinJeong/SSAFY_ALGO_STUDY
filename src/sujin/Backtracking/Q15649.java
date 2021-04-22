package sujin.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열 : 순열
 */
public class Q15649 {
	static int n, m;
	static int[] num;

	public static void Comb(int cnt, int[] selected, boolean[] visited) {

		if (cnt == m) {

			for (int cur : selected)
				System.out.print(cur + " ");
			System.out.println();
			return;
		}

		// cnt는 총 몇개 뽑았는지, i는 중복제거 하기 위해 시작 인덱스 조정
		for (int i = 0; i < num.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				selected[cnt] = num[i];
				Comb(cnt + 1, selected, visited);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		num = new int[n];
		for (int i = 1; i <= n; i++) {
			num[i - 1] = i;
		}
		Comb(0, new int[m], new boolean[n]);
	}

}
