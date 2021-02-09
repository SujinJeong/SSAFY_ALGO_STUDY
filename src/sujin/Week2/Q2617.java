package sujin.Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
5개의 구슬 중 3개 이상 즉 전체 구슬을 n이라고 하면 (n-1)/2개 이상이
앞에 위치하거나 뒤에 위치하거나 한다면 이 구슬은 중간에 올 수 없게 되는 것.
 */
import java.util.ArrayList;

public class Q2617 {
	static int n, m, count = 0;
	static int[] less;
	static int[] more;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);

		ArrayList<Integer>[] minList = new ArrayList[n + 1];
		ArrayList<Integer>[] maxList = new ArrayList[n + 1];
		
		for (int i = 1; i <= n; i++) {
			minList[i] = new ArrayList<>();
			maxList[i] = new ArrayList<>();
		}
		less = new int[n + 1];
		more = new int[n + 1];

		for (int i = 0; i < m; i++) {
			String[] line2 = br.readLine().split(" ");
			int a = Integer.parseInt(line2[0]);
			int b = Integer.parseInt(line2[1]);
			// a가 b보다 가벼움
			minList[a].add(b);
			// b가  a보다 무거움
			maxList[b].add(a);
		}

		int half = n / 2;

		for (int i = 1; i <= n; i++) {
			visit = new boolean[n + 1];
			less[i] = dfs(i, minList);
			visit = new boolean[n + 1];
			more[i] = dfs(i, maxList);

			if (less[i] > half || more[i] > half) {
				count++;
			}
		}
		System.out.println(count);

	}

	private static int dfs(int index, ArrayList<Integer>[] list) {
		int sum = 0;
		visit[index] = true;
		for (int num : list[index]) {
			if (!visit[num]) {
				visit[num] = true;
				sum += dfs(num, list) + 1;
			}
		}
		return sum;
	}

}
