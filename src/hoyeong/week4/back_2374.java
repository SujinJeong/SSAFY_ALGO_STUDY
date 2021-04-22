package hoyeong.week4;

import java.util.*;
import java.io.*;

public class back_2374 {
	static int N,max;
	static int [] arr;
	static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int [N];
		
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(br.readLine());
			arr[i] = n;
			if(!list.contains(n)) list.add(n);
		}
		Collections.sort(list);
		System.out.println(devide());
	}
	private static int devide() {
		int result=0;
		
		for(int i=0; i<list.size()-1; i++) { // 숫자
			for(int j=0; j<N; j++) {
				if(arr[j]==list.get(i)) { // 작은 숫자 찾음
					int cnt=0;
					for(int k=j+1; k<N; k++) {
						if(arr[k]==arr[j]) cnt++;
						else break;
					}
		
					for(int k=j; k<=j+cnt; k++) {
						arr[k] = list.get(i+1);
					}
					result += list.get(i+1)-list.get(i);
					j = j+cnt;
				}
			}
			
		}
		return result;
	}
}
