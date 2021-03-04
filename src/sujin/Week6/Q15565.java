package sujin.Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q15565 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] line = br.readLine().split(" ");
		int s = 0, e = 0, cnt = 0;
		int min = 987654321;
		
		int n = Integer.parseInt(line[0]);
		int k = Integer.parseInt(line[1]);
		int[] arr = new int[n];
		
		line = br.readLine().split(" ");
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(line[i]);
		
		while (e <= n) {
			if (cnt == k) {
				min = min < e-s? min: e-s;
			}
			
			if (cnt < k) {
				if (e == n) break;
				if (arr[e] == 1) cnt++;
				e++;
			}
			else { // cnt >= k
				// 시작점이 라이언인 경우 cnt 줄여주는 조건 추가
				if (arr[s] == 1) cnt--;
				s++;
			}
		}
		
		if (min == 987654321) sb.append(-1);
		else sb.append(min);
		
		System.out.println(sb);
	}
}
