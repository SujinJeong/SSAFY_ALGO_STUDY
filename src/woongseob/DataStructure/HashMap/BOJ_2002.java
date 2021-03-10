package study_0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ_2002 {
	static int N;
	static HashMap<String, Integer> m = new HashMap<>();
	static String[] pass;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String car = br.readLine();
			m.put(car, i);
		}

		pass = new String[N];
		for (int i = 0; i < N; i++) {
			pass[i] = br.readLine();
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if(m.get(pass[i]) > m.get(pass[j])) {
					cnt++;
					break;
				}
			}
		}
		System.out.println(cnt);
	}
}
