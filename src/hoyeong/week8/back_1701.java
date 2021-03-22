package hoyeong.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class back_1701 {
	static int N;
	static String str;
	static int [] table;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		N = str.length();
		
		table = new int [N];
				
		int result=0;
		for(int x=0; x<N; x++) { // 접두사를 바꿔가며 최대를 찾아야함  ex)baaa
			Arrays.fill(table, 0);
			String str1 = str.substring(x);
			maketable(str1);
			for(int t:table) // 접두사에서 한번 나왔으므로 table 안에 0이 아닌 숫자가 나오면 2번 이상 나온것
				result = Math.max(result, t);
		}
		
		System.out.println(result);
	}
	
	private static void maketable(String str1) {
		int j=0;
		for(int i=1; i<str1.length(); i++) {
			while(j>0 && str1.charAt(j)!=str1.charAt(i) ) {
				j = table[j-1];
			}
			if(str1.charAt(i)==str1.charAt(j)) {
				table[i] = ++j;
			}
		}
	}
}
