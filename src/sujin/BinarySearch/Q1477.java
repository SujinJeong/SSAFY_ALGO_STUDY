package sujin.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1477 {

	public static class Info implements Comparable<Info> {
		double length;
		int cnt;

		public Info(double length, int cnt) {
			super();
			this.length = length;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Info o) {
			return Double.compare(o.length, this.length);
		}

	}

	public static void solve(int[] arr, int m) {
		PriorityQueue<Info> pq = new PriorityQueue<>();

		for (int i = 1; i < arr.length; i++) {
			pq.add(new Info(arr[i] - arr[i - 1], 1));
		}

		// System.out.println(Arrays.toString(arr));
		int total_cnt = 0;

		while (total_cnt < m) {
			total_cnt++;
			// 가장 차이가 많이 나는 구간 pop해서 재계산 필요
			Info i = pq.poll();
			// System.out.println(total_cnt + " " + i.length);

			// 원래 길이 회복 후에 나누기 원래 나눈 구간+1 해서 다시 나눠주기
			int next_cnt = i.cnt + 1;
			double next_length = (i.length * i.cnt);
			pq.offer(new Info(next_length/ next_cnt, next_cnt));
		}

		// 다 세우고나서 max 길이 출력 - 정수 위치에만 세울 수 있으므로 이에 대한 처리 필요
		double rslt = pq.peek().length;
		int atoi = (int) rslt;
		
		// 소수점 없는 경우
		if (rslt == atoi) System.out.println(atoi);
		// 소수점 아래 숫자가 있을 경우 1을 더해줌
		else System.out.println(atoi + 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		int[] arr = new int[n + 2];
		st = new StringTokenizer(br.readLine());

		// 고속도로 처음부터 끝까지 길이 구해야 하므로 앞, 뒤 추가
		arr[0] = 0;
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		arr[n + 1] = l;

		// 오름차순 정렬
		Arrays.sort(arr);
		solve(arr, m);

	}

}
