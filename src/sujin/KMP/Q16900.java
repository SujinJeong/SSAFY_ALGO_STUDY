package sujin.KMP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q16900 {

	static int[] table;
	
	static void makeTable(char[] p) {
		table = new int[p.length];
		int j = 0;
		
		for (int i = 1; i < p.length; i++) {
			while (j > 0 && p[i] != p[j]) {
				j = table[j - 1];
			}
			if (p[i] == p[j]) {
				table[i] = ++j;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		char[] arr = st.nextToken().toCharArray();
		int num = Integer.parseInt(st.nextToken());
		
		makeTable(arr);
		
		// 겹치는 부분부터 다시 시작하기 위한 변수
		int length = arr.length;
		long restart = (length - table[length-1]);
		// 이미 한번 pattern이 붙어 있으니까 num-1만큼 또 이어붙이고 원래 문자 붙이기
		System.out.println(restart * (num-1) + length);
	}

}
