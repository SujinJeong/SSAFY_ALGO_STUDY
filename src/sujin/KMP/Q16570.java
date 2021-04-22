package sujin.KMP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q16570 {
	static void makeTable(int[] p) {
		
		int max = 0, cnt = 0, j = 0;
		
		int[] table = new int[p.length];
		
		for (int i = 1; i < p.length; i++) {
			while (j > 0 && p[i] != p[j])
				j = table[j - 1];
			if (p[i] == p[j])
				table[i] = ++j;
			max = table[i] > max? table[i] : max;
		}
		
		for (int i : table)
			if (i == max) cnt++;
		
		if (max == 0) System.out.println(-1);
		else System.out.println(max + " " + cnt);
		
		return;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = n-1; i >= 0; i--) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		makeTable(arr);
	}
}
