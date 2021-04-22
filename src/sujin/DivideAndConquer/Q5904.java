package sujin.DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*

middle = 새로운 수열 길이
size = 전체 문자열 길이
새로운수열 기준으로 나눌 인덱스 t = (size-middle)/2

구하는 문자의 위치 경우의 수
1. 새로운 수열 middle 안에 존재할 경우 t < n <= t+middle
2. 새로운 수열 middle 보다 앞에 존재할 경우 n <= t
3. 새로운 수열 middle 보다 뒤에 존재할 경우 t+middle < n

다시 자르기 필요
2 (앞에 존재할 경우) -> (새로운 수열 사이즈-1 : middle--, 기존의 size = t)
3 (뒤에 존재할 경우) ->  t+middle만큼 앞의 문자열이 잘리는 것이므로 n도 t+middle만큼 감소
*/

public class Q5904 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		int middle = 4; // 초기 개인수열 "mooo" s(1)
		int size = 3; // 초기 "moo" s(0)

		while (n > size) {
			// n을 구할 수 있을 때까지 늘려주기
			size = size * 2 + middle;
			middle += 1;
		}

		// 다음 S(K) 구하기 위해 middle 늘려줬던것 하나 마이너스
		middle--;

		while (true) {
			// 맨 앞 부분에 있는게 아닌이상 n을 조정
			int t1 = (size - middle) / 2; // 앞 split
			int t2 = t1 + middle; // 뒤 split
			if (n <= t1) { // 새로운 수열 middle 보다 앞에 존재할 경우
				middle--;
				size = t1;
			} else if (n > t2) { // 새로운 수열 middle 보다 뒤에 존재할 경우
				n -= t2;
				middle--;
				size = t1;
			} else { // 새로운 수열에 존재
				n -= t1;
				break;
			}
		}

		// 계속 짤라서 결과적으로 봤을때 첫글자인지 나머지 글자인지
		if (n == 1) {
			sb.append("m");
		} else {
			sb.append("o");
		}

		System.out.println(sb);
	}

}
