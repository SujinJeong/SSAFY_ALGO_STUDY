package sujin.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열, 같은 수 여러개 가능 : 중복순열
-> 순열에서 visited 빼기
 */
public class Q15651 {
	static int n, m;
	static int[] num;
	static StringBuilder sb;
	
	public static void Comb(int cnt, int[] selected) {

		if (cnt == m) {
			for (int cur : selected)
				sb.append(cur + " ");
			sb.append("\n");
			return;
		}

		// cnt는 총 몇개 뽑았는지, i는 중복제거 하기 위해 시작 인덱스 조정
		for (int i = 0; i < num.length; i++) {
			selected[cnt] = num[i];
			Comb(cnt + 1, selected);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		num = new int[n];
		for (int i = 1; i <= n; i++) {
			num[i - 1] = i;
		}
		Comb(0, new int[m]);
		
		System.out.println(sb);
	}

}
