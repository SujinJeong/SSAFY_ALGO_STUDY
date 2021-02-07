package study_0201;

import java.io.*;
import java.util.*;

public class BOJ_17610 {
	static int k, sum;
	static int[] ary;
	static boolean[] weight;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		ary = new int[k];
		StringTokenizer st= new StringTokenizer(br.readLine());
		for(int i = 0 ; i < k; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
			sum += ary[i];
		}
		weight = new boolean[sum + 1];
		// 풀이
		recursive(0,0);
		// 출력
		int ans = 0;
		for(int i = 1; i <= sum; i++) {
			if(!weight[i]) {
				ans++;
			}
		}
		System.out.println(ans);
	}
	
	public static void recursive(int cnt,int w) {
		if(w > 0 && w <= sum) {
			weight[w] = true;
		}
		if(cnt == k) {
			return;
		}
		recursive(cnt + 1, w + ary[cnt]);
		recursive(cnt + 1, w);
		recursive(cnt + 1, w - ary[cnt]);
	}
}
