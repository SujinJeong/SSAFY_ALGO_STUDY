package sujin.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1. 현재 빨간불인 경우 얼마나 빨간불을 기다려야 하는지 구하는 방법: 총걸린시간%(r+g) 왜냐면 r+g 만큼 계속 반복되므로.
총 빨간불R - time % (r+g) 더해주기
2. 
 */
public class Q2980 {
	public static class Sinho {
		int d, r, g;

		public Sinho(int d, int r, int g) {
			super();
			this.d = d;
			this.r = r;
			this.g = g;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");

		int n = Integer.parseInt(line[0]);
		int l = Integer.parseInt(line[1]);
		// 예제기준 1~10까지
		Sinho[] arr = new Sinho[l+1];

		for (int i = 0; i < n; i++) {
			String[] line2 = br.readLine().split(" ");
			int d = Integer.parseInt(line2[0]);
			int r = Integer.parseInt(line2[1]);
			int g = Integer.parseInt(line2[2]);

			// 해당 위치에 신호등 정보 넣어주기
			arr[d] = new Sinho(d, r, g);
		}

		// 1번 자리부터 시작
		int position = 1;
		int total_time = 0;

		while (position < l) {
			// 한칸이동
			position++;
			// 1초 증가
			total_time++;

			// 신호등이 있는 자리로 가면
			if (arr[position] != null) {
				// 도착했을 때 현재 신호등 상태
				int now_sinho = total_time % (arr[position].r + arr[position].g);
				
				// 현재 빨간불인 경우 ( 이논리는 빨간불이 먼저이기 때문에 가능 )
				if (now_sinho <= arr[position].r)
					// 빨간불이여서 대기하는 시간만큼 시간 더해주기
					total_time += arr[position].r - now_sinho;
			}
		}
		System.out.println(total_time);
	}

}
