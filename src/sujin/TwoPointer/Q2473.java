package sujin.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2473 {
	static long min = Long.MAX_VALUE;
	
	public static long[] sol(long[] arr, int n) {
		// 결과 세 용액이 담기는 배열
		long[] ans = new long[3];
		
		// i값을 고정으로 두고 나머지 2개를 투포인터 이용해서 찾기
		for (int i = 0; i < n-2; i++) {
			int s = i+1;
			int e = n-1;
			
			while (s < e) { // start와 end가 만나지 않을때 반복
				long sum = arr[s]+arr[e]+arr[i];
				// 절대값이 가장 작아야함!
				if (Math.abs(sum) < Math.abs(min)) {
					min = sum;
					ans[0] = arr[i];
					ans[1] = arr[s];
					ans[2] = arr[e];
				}
				
				// 양수쪽이 더 크면 오른쪽 포인터 땡겨주기
				if (sum > 0) e--;
				else s++;
			}
		}
		
		Arrays.sort(ans);
		return ans;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[n];
		
		String[] line = br.readLine().split(" ");
		for (int i = 0; i < n; i++)  arr[i] = Long.parseLong(line[i]);
		Arrays.sort(arr);
		
		for (long l : sol(arr, n))
			System.out.print(l + " ");
	}
}
