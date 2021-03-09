package hoyeong.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class back_2002 {
	static int N;
	static HashMap<String, Integer> dae = new HashMap<>();
	static String [] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new String [N];
		
		for(int i=0; i<N; i++) {
			dae.put(br.readLine(),i);
		}
		
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine();
		}
		
		int cnt=0;
		
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				if(dae.get(arr[i])>dae.get(arr[j])) {
					cnt++;
					break;
				}
			}
		}
		System.out.println(cnt);
	}

}
