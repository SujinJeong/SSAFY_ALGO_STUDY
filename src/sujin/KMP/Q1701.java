package sujin.KMP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1701 {
	static int max = Integer.MIN_VALUE;

	static void makeTable(char[] p) {
		int[] table = new int[p.length];
		int j = 0;

		for (int i = 1; i < p.length; i++) {
			while (j > 0 && p[i] != p[j])
				j = table[j - 1];
			if (p[i] == p[j])
				table[i] = ++j;
		}
		
		for (int i = 0; i < table.length; i++)
			max = Math.max(max, table[i]);
		
		return;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] c = br.readLine().toCharArray();

		for (int i = 0; i < c.length; i++)
			makeTable(Arrays.copyOfRange(c, i, c.length));

		System.out.println(max);
	}

}
