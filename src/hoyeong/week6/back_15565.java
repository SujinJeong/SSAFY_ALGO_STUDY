package hoyeong.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class back_15565 {
	static int N,K,min=987654321;
	static int [] arr;
	static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i]==1) list.add(i);
		}
		
		if(list.size()<K) {
			System.out.println(-1);
			System.exit(0);
		}

		/*for(int i=0; i<=list.size()-K; i++) {
			min = Math.min(min, list.get(i+K-1)-list.get(i)+1);
		}*/
		
		int cnt=2, start=0, end=1;
		while(true) {
			if(cnt<K) {
				end++;
				cnt++;
				if(cnt==K) {
					min = Math.min(min, list.get(end)-list.get(start)+1);
					start++;
					cnt--;
				}
			}
			if(end==list.size()-1) break;
			
		}
		System.out.println(min);
		
	}
}
