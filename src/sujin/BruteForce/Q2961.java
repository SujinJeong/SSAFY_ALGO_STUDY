package sujin.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2961 {
	static int[] arr; // 뽑힌 수의 인덱스 저장, visited와 비슷한 개념
	static int[] S, B;
	static int N;
	static int min = Integer.MAX_VALUE;
	
	static void Comb(int cnt, int idx, int r) {
	    if (cnt == r) {
	    	int sum = 0; int multi = 1;
	    	for (int i = 0 ; i < arr.length; i++) {
	    		// 현재 뽑인 인덱스들이 담긴 arr 이용해 덧셈, 곱셈
	    		multi *= S[arr[i]];
	    		sum += B[arr[i]];
	    	}
	    	// 신맛과 쓴맛의 최소값 구하기
	    	min = Math.min(min, Math.abs(multi-sum));
	    	return;
	    }
	    
	    for (int i = idx; i < N; i++) {
	    	arr[cnt] = i;
	    	Comb(cnt+1, i+1, r);
	    }
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		S = new int[N]; // 신맛
		B = new int[N]; // 쓴맛
		
		// input
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			S[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int r = 1; r <= N; r++) { // nCr에서 r값
			arr = new int[r]; // 뽑는 수만큼 인덱스 담아주기 위해 배열생성
			Comb(0, 0, r); // Comb함수님 r개만큼 뽑고싶어요
		}
		System.out.println(min);
	}

}
