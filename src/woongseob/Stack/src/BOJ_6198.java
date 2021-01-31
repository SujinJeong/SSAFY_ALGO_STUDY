package study_0125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_6198 {
	static int N;
	static int[] height;
	static long ans = 0;
	static Stack<Integer> roof = new Stack<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		height = new int[N];
		// Input
		for(int i = 0; i < N; i++) {
			height[i] = Integer.parseInt(br.readLine());
		}
		// Sol
		for(int i = 0; i < N; i++) {
			while(!roof.empty() && roof.peek() <= height[i]) {
				roof.pop();
			}
			roof.push(height[i]);
			ans += roof.size() - 1;
		}
		// Output
		System.out.println(ans);
	}
}
