package study_0222;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2980 {
	static int N, L, D, R, G;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		int time = 0, pos = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			G = Integer.parseInt(st.nextToken());
			time += D - pos;
			int cycle = R + G;
			if (time % cycle < R) time += R - (time % cycle);	
			pos = D;
		}
		time += L - pos;
		System.out.println(time);
	}
}
