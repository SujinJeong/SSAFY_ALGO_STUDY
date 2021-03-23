package sujin.Week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q14938 {
	public static void init() {
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");

		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);
		int r = Integer.parseInt(line[2]);
		int[] item = new int[n+1];
		int[][] adj = new int[r][r];
		
		// 아이템 input
		line = br.readLine().split(" ");
		for (int i = 1; i <= n; i++) {
			item[i] = Integer.parseInt(line[i-1]);
		}
		
		Arrays.fill(adj, Integer.MAX_VALUE);
		
		for (int i = 0; i < r; i++) {
			line = br.readLine().split(" ");
			//adj[]
		}
		
		
	}

}
