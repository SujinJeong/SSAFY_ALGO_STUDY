package study_0215;

import java.io.*;
import java.util.*;

public class BOJ_2437 {
	static int N;
	static int[] c;
	static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		c = new int[N];
		
		for(int i = 0 ; i < N; i++) {
			c[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(c);
		
		int sum = 0;
		for(int i = 0 ; i < N; i++) {
			if(c[i] > sum + 1) break;
			sum += c[i];
		}
		System.out.println(sum + 1);
	}
}
