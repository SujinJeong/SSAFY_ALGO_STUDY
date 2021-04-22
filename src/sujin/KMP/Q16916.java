package sujin.KMP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
kmp 이용 - 1786 참고
 */
public class Q16916 {
	
	public static int[] makeArr(char[] pattern) {
		int[] pi = new int[pattern.length];
		int j = 0;

		for (int i = 1; i < pattern.length; i++) {
			while (j > 0 && pattern[i] != pattern[j]) {
				j = pi[j - 1];
			}
			if (pattern[i] == pattern[j]) {
				pi[i] = ++j;
//				pi[i] = j+1;
//				j++;
			}
		}
		
		return pi;
	}

	public static int kmp(char[] parent, char[] pattern, int[] pi) {
		
		int j = 0;
		for (int i = 0; i < parent.length; i++) {
			while (j > 0 && parent[i] != pattern[j]) {
				// 틀린경우에는 그 전 인덱스까지 접두사/접미사가 같은 부분까지 계속 이동
				j = pi[j - 1];
			}
			if (parent[i] == pattern[j]) {
				// pattern 끝까지 탐색 완료되었을 경우
				if (j == pattern.length-1) {
					return 1;
				}
				// pattern 끝까지 더 탐색
				else j++;
			}
		}

		return 0;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] parent = br.readLine().toCharArray();
		char[] pattern = br.readLine().toCharArray();
		
		System.out.println(kmp(parent, pattern, makeArr(pattern)));
	}

}
