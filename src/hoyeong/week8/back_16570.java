package hoyeong.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class back_16570 {
	static int N;
	static int [] arr, table;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		arr = new int [N];
		
		// 원래 KMP에서 접두사를 기준으로 뒤에 오는 값들을 비교
		// 이 문제에선 후미의 수열을 기준으로 앞의 수열을 비교하므로 거꾸로 입력받음
		st =new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[N-1-i] = Integer.parseInt(st.nextToken());
		}
		table = new int [N];
		
		make();
		
		int result=0;
		int result_cnt=0;
		for(int i=0; i<N; i++) {
			if(table[i]>result) {
				result=table[i];
				result_cnt=1;
			}
			else if(table[i]==result) {
				result_cnt++;
			}
		}
		if(result==0) sb.append("-1\n");
		else sb.append(result+" "+result_cnt);
		System.out.println(sb);
	}
	private static void make() {
		int j=0;
		for(int i=1; i<N; i++) {
			while(j>0 && arr[i]!=arr[j]) {
				j = table[j-1];
			}
			if(arr[i]==arr[j]) {
				table[i] = ++j;
			}
		}
	}
}
