package hoyeong.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_2195 {
	static String S,P;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		S = br.readLine();
		P = br.readLine();
		
		int cnt=0, idx=0;
		outloop: while(idx!=P.length()) {
			for(int i=S.length()-1; i>=1; i--) {
				if(idx+i+1>P.length()) continue;
								
				if(S.contains(P.substring(idx, idx+i+1))) {
					idx = idx+i+1;
					cnt++;
					continue outloop;
				}
			}
					idx++;
					cnt++;
	}
		System.out.println(cnt);
	}
}
