package study_0316;

import java.io.*;
import java.util.*;

public class BOJ_16900 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String S = st.nextToken();
		int K = Integer.parseInt(st.nextToken());
		
		int sLen = S.length();
		int[] table = new int[sLen];
		int j = 0;
		for(int i = 1; i < sLen; i++) {
			while(j > 0 && S.charAt(i) != S.charAt(j)) {
				j = table[j - 1];
			}
			if(S.charAt(i) == S.charAt(j)) {
				table[i] = ++j;
			}
		}
		long ans = sLen + ((long)(sLen - table[sLen - 1]) * (long)(K - 1));
		System.out.println(ans);
	}
}
