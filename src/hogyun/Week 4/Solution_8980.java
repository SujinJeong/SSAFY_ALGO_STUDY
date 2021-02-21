package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_8980 {
	static int N, C, M, res, truck;
	static int[] truckSize;
	static ArrayList<Info> arr = new ArrayList<>();

	static class Info implements Comparable<Info> {
		int start, end, num;

		public Info(int start, int end, int num) {
			super();
			this.start = start;
			this.end = end;
			this.num = num;
		}

		@Override
		public int compareTo(Info rhs) {
			if (this.end == rhs.end)
				return rhs.start - this.start;
			return this.end - rhs.end;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());
		truckSize = new int[N + 1];
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			arr.add(new Info(start, end, num));
		}
		Collections.sort(arr);

		for (int i = 0; i < M; ++i) {
			int start = arr.get(i).start;
			int end = arr.get(i).end;
			int num = arr.get(i).num;
			int tmpMax = 0;
			
			for (int j = start; j < end; ++j) {
				tmpMax = Math.max(tmpMax, truckSize[j]);
			}
			if (tmpMax + num <= C) {
				res += num;
				for (int j = start; j < end; ++j) {
					truckSize[j] += num;
				}
			} else {
				int minus = C - tmpMax;
				res += minus;
				for (int j = start; j < end; ++j) {
					truckSize[j] += minus;
				}
			}
		}
		System.out.println(res);
	}
}
