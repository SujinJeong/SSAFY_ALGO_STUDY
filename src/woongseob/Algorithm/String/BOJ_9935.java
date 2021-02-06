package study_0201;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_9935 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < s1.length(); i++) {
			sb.append(s1.charAt(i));
			if(sb.length() >= s2.length() && sb.charAt(sb.length() - 1) == s2.charAt(s2.length() - 1)) {
				if(sb.substring(sb.length() - s2.length()).equals(s2)) {
					sb.delete(sb.length() - s2.length(),sb.length());
				}
			}
		}
		if(sb.length() == 0) {
			sb.append("FRULA");
		}
		System.out.println(sb);
	}
}
