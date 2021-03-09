package hoyeong.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class back_2473 {
	static int N;
	static long min=Long.MAX_VALUE;
	static long [] arr;
	static long [] r = new long [3];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new long [N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(arr); // 오름차순으로 정렬
		
		pointer();
		
		for(long x:r)
		System.out.print(x+" ");
	}
	
	private static void pointer() {
		for(int i=0; i<N-2; i++) { // i번째 숫자, i+1번째 숫자, N-1번째 숫자의 합
			
			int j=i+1;
			int k=N-1;
			
			while(j!=k) { // 투포인터
				long result = arr[i]+arr[j]+arr[k]; 
				
				if(min>Math.abs(result)) {
					min=Math.abs(result);
					r[0] = arr[i];
					r[1] = arr[j];
					r[2] = arr[k];
				}
				
				if(result>=0) k--;
				else j++;
			}
			
		}
	}
}
