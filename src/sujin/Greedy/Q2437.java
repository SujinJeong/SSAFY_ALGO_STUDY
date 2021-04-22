package sujin.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2437 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] weight = new int[n];
		int sum = 0;

		for (int i = 0; i < n; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}

		// default는 오름차순 정렬
		Arrays.sort(weight);

		// 오름차순 정렬이기 때문에 지금까지 더한값 +1이 안만들어지면 최솟값
		for (int i = 0; i < n; i++) {
			if (sum + 1 < weight[i]) {
				System.out.println(sum + 1);
				break;
			}
			
			sum += weight[i];
		}

		
	}

}
