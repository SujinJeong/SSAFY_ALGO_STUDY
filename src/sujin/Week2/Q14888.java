package sujin.Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14888 {

	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	static int TC;
	static int[] calc, arr;
	
	public static void calculate(int num, int idx) {
		if (idx == TC) {
			// num에는 연산을 계속적으로 한 것이 쌓여서 최종 결과가 저장되어 있음!
			max = Math.max(max, num);
			min = Math.min(min, num);
		}
		for (int i = 0; i < 4; i++) {
			if (calc[i] > 0) {
				// 연산 한번 할꺼니까 연산횟수 뺴주기
				calc[i]--;
				switch(i) {
					case 0:	calculate(num + arr[idx], idx + 1);	break;
					case 1:	calculate(num - arr[idx], idx + 1);	break;
					case 2:	calculate(num * arr[idx], idx + 1);	break;
					case 3:	calculate(num / arr[idx], idx + 1);	break;
				}
				// 다시 원상복귀시켜야 다른 경우의 수를 구할 수 있다
				calc[i]++;
			}
			
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// input
		TC = Integer.parseInt(br.readLine());
		arr = new int[TC];
		calc = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < TC; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++)
			calc[i] = Integer.parseInt(st.nextToken());
		
		calculate(arr[0], 1);
		System.out.println(max);
		System.out.println(min);
	}

}
