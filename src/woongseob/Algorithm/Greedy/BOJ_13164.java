package study_0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_13164 {
	static int N, K;
	static int[] student, diff; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		student = new int[N];
		diff = new int[N - 1];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			student[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < N-1; i++) {
			diff[i] = student[i + 1] - student[i];
		}
		Arrays.sort(diff);
		int ans = 0; 
		for(int i = 0 ; i < N - K; i++) {
			ans += diff[i];
		}
		System.out.println(ans);
	}
}
