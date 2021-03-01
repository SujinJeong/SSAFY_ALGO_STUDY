package sujin.Week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Q13164 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		
		int n = Integer.parseInt(line[0]);
		int k = Integer.parseInt(line[1]);
		int sum = 0;
		
		// input
		String[] line2 = br.readLine().split(" ");
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(line2[i]);
		}
		
		// solve
		Integer[] diff = new Integer[n-1];
		for (int i = 0; i < n-1; i++) {
			diff[i] = arr[i+1]- arr[i];
		}
		
		// 차이를 내림차순으로 정렬 why? 차이가 가장 큰 k-1개 부분에서 끊어줘야하므로
		Arrays.sort(diff, Collections.reverseOrder());
		
		// 끊어준 k-1개 부분 빼고 나머지 차이 모두 더하기
		for (int i = k-1; i < diff.length; i++)
			sum += diff[i];
		
		System.out.println(sum);
	}

}
