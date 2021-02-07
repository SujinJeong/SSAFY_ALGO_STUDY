package sujin.Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
   1. 해당 날에 상담을 하지 않고, 그 다음날로 넘어가는 방법. => 전 dp값이 해당 날의 dp값이 된다
   2. 해당 날에 상담을 하고, 해당 상담을 하는데 걸리논 총 일수 만큼 넘어가는 방법 => 1과 비교해서 max 값을 dp값에 넣어준다
 */
public class Q14501 {
	static int[] days, money, dp;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// input
		int TC = Integer.parseInt(br.readLine());
		days = new int[TC+1];
		money = new int[TC+1];
		// 마지막 인덱스 뒤에 저장된 0값도 끌어오기 위해
		dp = new int[TC+2];
		
		for (int i = 1; i <= TC; i++) {
			st = new StringTokenizer(br.readLine());
			days[i] = Integer.parseInt(st.nextToken());
			money[i] = Integer.parseInt(st.nextToken());
		}
		
		// sol
		for (int i = TC; i >= 1; i--) {
			// 퇴사 시기를 넘으면 더 큰 이익을 낼 수 없기 때문에 전 이익과 변동없음
			if (i + days[i] > TC+1)
				dp[i] = dp[i+1];
			// 뒤부터 차례대로 계산해온 총이익 = dp[i+1]과 
			// 이를 버리고 걸리는 일수가 더 크지만 이익이 클 때 dp[i+days[i]] = 걸리는 일수 + money[i] = 이익
			// 중 무엇을 선택하는 것이 좋은지 연산하기
			else {
				dp[i] = Math.max(dp[i+1], dp[i+days[i]]+ money[i]);
			}
		}
		
		// output
		System.out.println(dp[1]);
	}

}
