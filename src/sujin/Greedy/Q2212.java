package sujin.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2212 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int sum = 0;
		int[] arr = new int[n];
		int[] diff = new int[n-1];
		
		String[] s = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(s[i]);
		}
		
		Arrays.sort(arr);
		
		// 거리 차이 가장 큰 쪽 자르기 위해
		for(int i = 0; i < n-1; i++)
        {
        	diff[i] = arr[i+1] - arr[i];
        }
		Arrays.sort(diff);
		
		for (int i = 0; i < n - k; i++)
			sum += diff[i];
		System.out.println(sum);
	}

}
