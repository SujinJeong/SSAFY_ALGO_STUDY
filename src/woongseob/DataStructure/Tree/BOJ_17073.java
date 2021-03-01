package study_0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17073 {
	static int N, W;
	static int[] node;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		node = new int[N + 1];
		for(int i = 0 ; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			node[a]++;
			node[b]++;
		}
		
		int num = 0;
		for(int i = 2; i <= N; i++) {
			if(node[i] == 1) num++;
		}
		System.out.println(((double)W / num));
	}
}
