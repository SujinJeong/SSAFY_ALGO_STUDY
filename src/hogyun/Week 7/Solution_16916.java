package kmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_16916 {
	static int res;
	
	public static int[] getPi(String p) {
		int m = p.length();
		int j = 0;
		int [] pi = new int[m];
		for(int i=1; i<m; ++i) {
			while(j > 0 && p.charAt(i) != p.charAt(j)) {
				j = pi[j - 1];
			}
			if(p.charAt(i)== p.charAt(j)) {
				pi[i] = ++j;
			}
		}
		return pi;
	}
	
	public static void KMP(String s1, String s2) {
		int []pi = getPi(s2);
		int j = 0;
		for(int i=0; i<s1.length(); ++i) {
			while(j > 0 && s1.charAt(i) != s2.charAt(j)) {
				j = pi[j - 1];
			}
			if(s1.charAt(i) == s2.charAt(j)) {
				if(j == s2.length() - 1) {
					res = 1;
					break;
				}else {
					j++;
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		KMP(str1, str2);
		System.out.println(res);
	}
}
