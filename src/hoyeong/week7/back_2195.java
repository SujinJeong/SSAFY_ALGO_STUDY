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
			for(int i=S.length()-1; i>=1; i--) { // P의 문자열을 앞에서부터 최대 S의 크기만큼 잘라서 생각
				if(idx+i+1>P.length()) continue; // 예외처리
								
				if(S.contains(P.substring(idx, idx+i+1))) { // P의 문자열 중 S내에 존재하는지 비교
					idx = idx+i+1;
					cnt++;
					continue outloop; // 존재한다면 다음 단계
				}
			}
					idx++;
					cnt++;
	}
		System.out.println(cnt);
	}
}
