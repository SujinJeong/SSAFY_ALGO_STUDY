package sujin.Week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Q1461 {

	public static void main(String[] args) throws IOException {
		ArrayList<Integer> positive = new ArrayList<>();
		ArrayList<Integer> negative = new ArrayList<>();
		int rslt = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);

		String[] line2 = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(line2[i]);
			if (num < 0)
				negative.add(-num);
			else
				positive.add(num);
		}

		// 내림차순 정렬
		Collections.sort(positive, Collections.reverseOrder());
		Collections.sort(negative, Collections.reverseOrder());

		// 한번에 움직일 수 있는만큼이 M이므로 M만큼 증가, 왕복을 계산해야하므로 *2
		for (int i = 0; i < positive.size(); i += M)
			rslt += 2 * positive.get(i);
		for (int i = 0; i < negative.size(); i += M)
			rslt += 2 * negative.get(i);

		// 마지막은 돌아오지 않아도 되므로 가장 큰 값이 양수인지 음수인지 판별
		int max = 0;
		if (!positive.isEmpty() && !negative.isEmpty()) {
			max = Math.max(positive.get(0), negative.get(0));
		} else if (positive.isEmpty()) { // negative 원소가 더 많은 경우
			max = negative.get(0);
		} else { // positive 원소가 더 많은 경우
			max = positive.get(0);
		}
		
		// 마지막은 왕복이 아니라 편도이므로 편도 값만큼 빼주기
		rslt -= max;

		System.out.println(rslt);
	}

}
