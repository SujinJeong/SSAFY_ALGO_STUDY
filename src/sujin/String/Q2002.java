package sujin.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Q2002 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<String, Integer> in = new HashMap<>();
		int[] out = new int[n];
		
		for (int i = 1; i <= n; i++) {
			// 우선순위대로 넣기
			in.put(br.readLine(), i);
		}
		
		for (int i = 0; i < n; i++) {
			// 나온 순위 저장
			out[i] = in.get(br.readLine());
		}
		
		// sol
		int rslt = 0;
		// 하나씩 탐색해주기
		for (int i = 0; i < out.length; i++)
			for (int j = i+1; j < out.length; j++) 
				// 추월해서 우선순위가 더 낮은데 앞에 있는 경우
				if (out[i] > out[j]) {
					rslt++;
					break;
				}
		
		System.out.println(rslt);
	}
}
