package sujin.Week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 원래방식 : P->S
//int length = pattern.length();
//int cnt = 0;	
//while (string.length() != 0) {
//int s = 0;
//int e = s + length;
//
//while (e <= pattern.length()) {
//String tmp = pattern.substring(s, e);
//while (string.contains(tmp)) {
//	cnt++;
//	// 가장 먼저 만난 원소만 replace
//	string = string.replaceFirst(tmp, "");
//}
//s++;
//e = s+length;
//}
//length--;
//}
public class Q2195 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		String P = br.readLine();
		
		// 바꾼 방법: S->P 방식
		int s = 0, e = 0, cnt = 0;
		while (true) {
			e = s;
			while (S.contains(P.substring(s, e))) {
				if (e == P.length()) {
					System.out.println(cnt+1);
					return;
				}
				e++;
			}
			cnt++;
			// 붙인만큼 인덱스 증가
			s += (e-s)-1;
		}
	}
}
