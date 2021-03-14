package hoyeong.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_16916 {
	static String S,P;
	static int[] table;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		S = br.readLine();
		P = br.readLine();
		
		table = new int[P.length()];
		
		maketable();
		KMP();
		System.out.println(0);
	}
	
	private static void maketable() {
		int j=0;
		for(int i=1; i<table.length; i++) {
			while(j>0 && P.charAt(i)!=P.charAt(j)) { 
				j=table[j-1]; // why?????????????????????? j--??
				// abacabbd >> j-- (00101220) table[j-1] (00101200)
				// 5번의 b의 ab는 접두사와 같으나 2가 되나 6번의 b의 abb는 접두사와 다르므로 0이 와야함 
			}
			if(P.charAt(i)==P.charAt(j)) {
				table[i] = ++j;
			}
		}
	}
	
	private static void KMP() {
		int j=0;
		for(int i=0; i<S.length(); i++) {
			while(j>0 && S.charAt(i)!=P.charAt(j)) { // while을 쓰는 이유 >> https://bowbowbow.tistory.com/6
				j=table[j-1];
			}
			if(S.charAt(i)==P.charAt(j)) {
				if(j == P.length()-1){
					System.out.println(1);
					System.exit(0);
				}
				else j++;
			}
		}
	}
}
