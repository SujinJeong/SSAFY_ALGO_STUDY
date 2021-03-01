package study_0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9663 {
	static int N, ans;
	static int[] chess;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		chess = new int[N];
		sol(0);
		System.out.println(ans);
	}
	
	private static void sol(int cnt) {
		if(cnt == N) {
			ans++;
			return;
		}
		
		for(int i = 0 ; i < N; i++) {
			chess[cnt] = i;
			boolean valid = true;
			for(int j = 0 ; j < cnt; j++) {
				if(chess[j] == chess[cnt] || Math.abs(chess[j] - chess[cnt]) == cnt - j) {
					valid = false;
					break;
				}
			}
			
			if(valid) sol(cnt + 1);
		}
	}
}
