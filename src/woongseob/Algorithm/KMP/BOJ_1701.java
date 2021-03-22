package study_0316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1701 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int ans = 0;
		while(!s.equals("")) {
			ans = Math.max(ans, kmp(s));
			s = s.substring(1);
		}
		System.out.println(ans);
	}

	private static int kmp(String s) {
		int sLen = s.length();
		int[] table = new int[sLen];
		int j = 0;
		for(int i = 1; i < sLen; i++) {
			while(j > 0 && s.charAt(i) != s.charAt(j)) {
				j = table[j - 1];
			}
			if(s.charAt(i) == s.charAt(j)) {
				table[i] = ++j;
			}
		}
		
		int ans = 0;
		for(int i = 0 ; i < sLen; i++) {
			ans = Math.max(ans, table[i]);
		}
		return ans;
	}
	
}
