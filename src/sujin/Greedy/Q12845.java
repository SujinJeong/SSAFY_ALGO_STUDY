package sujin.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/*
1. 내림차순으로 정렬해서 큰 곳부터 작은 곳으로 합치기

 */
public class Q12845 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Integer[] num = new Integer[n];
		
		String[] s = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(s[i]);
		}
		Arrays.sort(num, Collections.reverseOrder());
		
		int gold = 0;
		int level = num[0];
		// 인덱스 작은거 -> 큰거로 덧붙여야 max
		for (int i = 1; i < n; i++) {
			gold += level + num[i];
		}
		
		System.out.println(gold);
	}

}
