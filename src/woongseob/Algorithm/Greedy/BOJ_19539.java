package study_0215;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_19539 {
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int sum = 0, div = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int h = Integer.parseInt(st.nextToken());
			sum += h;
			div += h / 2;
		}
		if (sum % 3 != 0) {
			System.out.println("NO");
		} else {
			if (div >= sum / 3) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
