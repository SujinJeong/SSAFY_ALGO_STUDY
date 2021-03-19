package hoyeong.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class back_1477 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int [] arr = new int[N+2];
		arr[N+1] = L;
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int low=0, high=L;
		int result=987654321;
		while(low<=high) {
			int mid = (low+high)/2; // 찾으려고하는 거리 차이
			int cnt=0;
			for(int i=0; i<=N; i++) {
				cnt += (arr[i+1]-arr[i]-1) / mid; // 차이가 arr[i+1]-arr[i]인 경우에는 휴게소 중복이 발생한다
			}
			if(cnt<=M) { // 구간 최댓값의 최솟값을 찾아야 하므로 cnt가 같더라도 더 작은게 있는지 찾아봐야함
				result = Math.min(result, mid);
				high = mid-1;
			}
			else {
				low = mid+1;
			}
		}
		System.out.println(result);
	}
}
