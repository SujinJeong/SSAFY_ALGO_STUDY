package sujin.Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2961 {
	static int[] arr; // »ÌÈù ¼öÀÇ ÀÎµ¦½º ÀúÀå, visited¿Í ºñ½ÁÇÑ °³³ä
	static int[] S, B;
	static int N;
	static int min = Integer.MAX_VALUE;
	
	static void Comb(int cnt, int idx, int r) {
	    if (cnt == r) {
	    	int sum = 0; int multi = 1;
	    	for (int i = 0 ; i < arr.length; i++) {
	    		// ÇöÀç »ÌÀÎ ÀÎµ¦½ºµéÀÌ ´ã±ä arr ÀÌ¿ëÇØ µ¡¼À, °ö¼À
	    		multi *= S[arr[i]];
	    		sum += B[arr[i]];
	    	}
	    	// ½Å¸À°ú ¾´¸ÀÀÇ ÃÖ¼Ò°ª ±¸ÇÏ±â
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
		S = new int[N]; // ½Å¸À
		B = new int[N]; // ¾´¸À
		
		// input
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			S[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int r = 1; r <= N; r++) { // nCr¿¡¼­ r°ª
			arr = new int[r]; // »Ì´Â ¼ö¸¸Å­ ÀÎµ¦½º ´ã¾ÆÁÖ±â À§ÇØ ¹è¿­»ı¼º
			Comb(0, 0, r); // CombÇÔ¼ö´Ô r°³¸¸Å­ »Ì°í½Í¾î¿ä
		}
		System.out.println(min);
	}

}
