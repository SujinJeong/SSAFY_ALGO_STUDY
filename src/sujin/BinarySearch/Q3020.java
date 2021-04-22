package sujin.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3020 {
	static int n, h;
	static int[] bottom, top;
	
	public static void search() {
		int min = 987654321;
		int cnt = 0;
		
		int[] top_total = new int[h+1];
		int[] bottom_total = new int[h+1];
		
		// 높이 하나씩 올릴때마다 걸리는애들 누적합 구하기
		for (int i = 1; i <= h; i++) {
			bottom_total[i] = bottom_total[i-1] + bottom[i];
			top_total[i] = top_total[i-1] + top[i];
		}
		
		// 한층씩 올라가면서 확인해보기
		for (int i = 1; i <= h; i++) {
			int total = 0;
			// i-1번째는 안걸리므로 전체에서 빼주기
			// 종유석의 경우 4층에 걸리는 구하려면 3까지 빼주기 = top index 1까지 빼주기 = h-i
			total += bottom_total[h] - bottom_total[i-1]
					+ top_total[h] - top_total[h-i];
			
			if (total < min) {
				min = total;
				// 처음 나타나는 min값이니까 1로 초기화
				cnt = 1;
			}
			else if (total == min) { // min값과 같은 경우 갯수 cnt
				cnt++;
			}
		}
		
		System.out.println(min + " " + cnt);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		bottom = new int[h+1]; // 석순
		top = new int[h+1]; // 종유

		for (int i = 0; i < n/2; i++) {
			// 높이 input
			bottom[Integer.parseInt(br.readLine())]++;
			top[Integer.parseInt(br.readLine())]++;
		}

		search();
	}

}
