package study_0316;

import java.io.*;
import java.util.*;

public class BOJ_1477 {
	static int N, M, L;
	static int[] pos;
	static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		input();
		solve();
	}
	private static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
	}
	
	private static void solve() {
		list.add(0);
		list.add(L);
		Collections.sort(list);
		// 기존 편의점 사이의 거리를 구한 후, 거리별로 지을 수 있는  편의점의 개수를 구하기
		int l = 0, r = L, mid, ans = 0;
		while(l <= r) {
			mid = (l + r) / 2;
			int sum = 0;
			for(int i = 0; i < N + 1; i++) {
				int store = list.get(i + 1) - list.get(i);
				sum += store/ mid;
				if(store % mid == 0) sum--;
			}
			if(sum > M) {
				l = mid + 1;
			}
			else if(sum == M) {
				ans = mid;
				r = mid-1;
			}
			else {
				r = mid - 1;
			}
		}
		System.out.println(l);
		System.out.println(ans);
	}
}
