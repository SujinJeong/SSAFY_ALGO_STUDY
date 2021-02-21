package study_0215;

import java.io.*;
import java.util.*;

public class BOJ_8980 {
	static int N, C, M;
	static ArrayList<Info> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int box = Integer.parseInt(st.nextToken());
			list.add(new Info(from, to, box));
		}
		Collections.sort(list);
		
		// 출력확인용
		for(Info i: list) {
			System.out.println(i.from + " " + i.to + " " + i.box);
		}
		//
		int[] storage = new int[N + 1];
		int ans = 0;
		for(int i = 0 ; i < M; i++) {
			// 차있는 만큼
			int box = 0;
			for(int j = list.get(i).from; j < list.get(i).to; j++) {
				box = Math.max(box, storage[j]);
			}
			
			// 담을 수 있는 만큼
			int load = Math.min(C - box, list.get(i).box);
			ans += load;
			
			// 갱신
			for(int j = list.get(i).from; j < list.get(i).to; j++) {
				storage[j] += load;
			}
		}
		System.out.println(ans);
	}
	
	static class Info implements Comparable<Info>{
		int from;
		int to;
		int box;	
		public Info(int from, int to, int box) {
			super();
			this.from = from;
			this.to = to;
			this.box = box;
		}
		@Override
		public int compareTo(Info o) {
			if(this.to == o.to) {
				return this.from - o.from;
			}
			return this.to - o.to;
		}
	}
}
