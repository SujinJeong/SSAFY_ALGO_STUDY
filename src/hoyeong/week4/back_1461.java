package hoyeong.week4;

import java.io.*;
import java.util.*;

public class back_1461 {
	static int N, M, result;
	static ArrayList<Integer> plus = new ArrayList<>();
	static ArrayList<Integer> minus = new ArrayList<>();
	static ArrayList<Integer> res = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			if (n > 0)
				plus.add(n);
			else
				minus.add(n);
		}
		
		Collections.sort(plus,Collections.reverseOrder());
		Collections.sort(minus);
		
		for(int i=0; i<plus.size(); i++) 
			if(i%M==0) res.add(plus.get(i));
		
		for(int i=0; i<minus.size(); i++)
			if(i%M==0) res.add(Math.abs(minus.get(i)));
		
		Collections.sort(res);
		for(int i=0; i<res.size()-1; i++)
			result += 2*res.get(i);
		result+=res.get(res.size()-1);
		System.out.println(result);
	}
}
