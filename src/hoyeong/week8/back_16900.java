package hoyeong.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_16900 {
	static int K,N;
	static String S;
	static int [] table;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		S = st.nextToken();
		K = Integer.parseInt(st.nextToken());
		table = new int[S.length()];
		N = S.length();
		
		make();
		long a = N*(long)K; // 오버플로우 발생
		long b = table[N-1]*(long)(K-1);
		System.out.println(a-b);
	}
	private static void make() {
		int j=0;
		for(int i=1; i<N; i++) {
			while(j>0 && S.charAt(i)!=S.charAt(j)) {
				j = table[j-1];
			}
			if(S.charAt(i)==S.charAt(j)) {
				table[i] = ++j;
			}
		}
	}
}
