package hoyeong.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_1806 {
	static int N,S, min=987654321;
	static int [] arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		two();
		if(min==987654321) System.out.println(0);
		else System.out.println(min);
	}
	
	private static void two() {
		int p1=0, p2=0, sum=arr[p1];
		
		while(true) {
			if(sum>=S) {
				min=Math.min(min, p1-p2+1);
				if(p1==p2) {
					if(p1==N-1) break; // p1이 마지막일경우 종료
					sum+=arr[++p1]; // p1과 p2가 같은 경우에는 p1이 증가해야함
					continue;
				}
				sum-=arr[p2];
				p2++;
			}
			
			else {
				if(p1==N-1) break;
				sum+=arr[++p1];
			}
		}
	}
}
