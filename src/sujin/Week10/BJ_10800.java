package sujin.Week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
각각의 색마다 총합을 저장한다 --> 배열에 저장
자신의 번호와 색, 크기를 담은 배열을 크기순으로 정렬한다.
뒤에서부터 자신의 색을 제외한 다른 합의 값을 자신의 번호에 저장한다.
이때 주의할 점은 같은 무게를 따로 처리해야 한다는 것이다.
 */
public class BJ_10800 {

	static class Ball implements Comparable<Ball>{
		int color, size, original_idx;

		public Ball(int color, int size, int original_idx) {
			super();
			this.color = color;
			this.size = size;
			this.original_idx = original_idx;
		}

		@Override
		public int compareTo(Ball o) {
			return o.size - this.size;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		Ball[] balls = new Ball[n];
		//  자신의 색에 담겨있는 size 누적합
		int[] clr = new int[200001];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			balls[i] = new Ball(c , s, i);
			// 해당 color size 더하기
			clr[c] += s;
		}
		
		// 크기 큰거부터 정렬
		Arrays.sort(balls);
		// 합을 담을 배열
		int[] sum = new int[n];
		
// 시간초과코드
//		
//		// 누적합 저장 dp
//		for (int i = 0; i < balls.length; i++) {
//			for (int j = i+1; j < balls.length; j++) {
//				if (balls[j].color == balls[i].color 
//						|| balls[j].size == balls[i].size) continue;
//				// 원래 인덱스에 dp 값 집어넣어주기
//				sum[balls[i].original_idx] += balls[j].size;
//			}
//		}
//		
//		Arrays.sort(balls, new Comparator<Ball>() {
//
//			@Override
//			public int compare(Ball o1, Ball o2) {
//				return o1.original_idx - o2.original_idx;
//			}
//		});
		
		Queue<Ball> q = new LinkedList<Ball>();
		// 맨 뒤부터 더해주기 위해
		int idx = n - 1;
		q.offer(balls[idx]);
		// index와 사이즈가 같을때 고려해주기
		while (idx > 0 && q.peek().size != balls[idx-1].size) {
			
		}
			
		// output
		for (int i = 0; i < n; i++) {
			sb.append(sum[i]).append("\n");
		}
		
		System.out.println(sb);
	}

}
