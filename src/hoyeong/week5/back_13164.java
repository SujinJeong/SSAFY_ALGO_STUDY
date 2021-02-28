package hoyeong.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class back_13164 {
	static ArrayList<Integer> list = new ArrayList<>();
	static int N,K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int [] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<N; i++) {
			list.add(arr[i]-arr[i-1]);
		}
		
		Collections.sort(list,Collections.reverseOrder());
		
		int sum=0;
		for(int i=K-1; i<list.size(); i++) {
			sum+=list.get(i);
		}
		System.out.println(sum);
	}
	
}
