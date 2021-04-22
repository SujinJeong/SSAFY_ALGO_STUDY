package sujin.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q14719 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int rslt = 0;
		String[] line = br.readLine().split(" ");

		int h = Integer.parseInt(line[0]);
		int w = Integer.parseInt(line[1]);

		int[] arr = new int[w];
		String[] line2 = br.readLine().split(" ");
		for (int i = 0; i < w; i++) {
			arr[i] = Integer.parseInt(line2[i]);
		}

		// 맨 앞과 뒤는 절대 빗물을 채울 수 없기 때문에 인덱스가 1~n-1
		for (int i = 1; i <= w - 1; i++) {
			int left_max = 0;
			// 왼쪽에 높은 벽 확인
			for (int j = 0; j < i; j++) {
				left_max = Math.max(left_max, arr[j]);
			}

			int right_max = 0;
			// 오른쪽에서 높은 벽 확인
			for (int j = i + 1; j < w; j++) {
				right_max = Math.max(right_max, arr[j]);
			}
			
			// 둘중에서 낮은 벽만큼 빗물 채우기
			int min = left_max > right_max ? right_max: left_max;
			
			// 낮은 벽 - 본인 높이 했는데 0보다 작으면 본인 높이가 더 높은 것
			if (min - arr[i] > 0)
				rslt += min - arr[i];
		}
		
		System.out.println(rslt);
	}
}
