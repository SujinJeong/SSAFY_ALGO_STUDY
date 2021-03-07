package sujin.Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1806 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		
		int N = Integer.parseInt(line[0]);
		int S = Integer.parseInt(line[1]);
		
		int[] arr = new int[N];
		line = br.readLine().split(" ");
		for (int i = 0; i < arr.length; i++)
			arr[i] = Integer.parseInt(line[i]);
		
		int s = 0, e = 0, sum = 0;
		int min = 987654321;
		
		while(e <= N) {
			if (sum >= S) {
				min = Math.min(min, e-s);
				sum -= arr[s];
				s++;
			}
			else {
				// 마지막 원소까지 확인해서 sum인 경우 알아주기 위해 걸었지만 e는 또 늘어나면 안되므로
				if (e == N) break;
				sum += arr[e];
				e++;
			}
		}
		
		if (min == 987654321) System.out.println(0);
		else System.out.println(min);
	}

}
