package hoyeong.week4;

import java.io.*;
import java.util.*;

public class back_19539 {
	static int N, mok,na;
	static int [] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(st.nextToken());
			mok += n/2;
			na += n%2;
		} // 나무를 쪼갠다고 생각 (x : 원래 2 뿌릴 나무이지만 1로 쪼개서 뿌릴 나무)
		// mok-x = na+2x
		// 3x = mok-na  : x가 정수이어야 가능
		
		if((mok-na)%3==0 && mok>=na) System.out.println("YES");
		else System.out.println("NO");
	}

}
