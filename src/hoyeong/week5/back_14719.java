package hoyeong.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class back_14719 {
	static ArrayList<Integer> list = new ArrayList<>();
	static int [] arr;
	static int W=0,sum=0, r_sum=0;
	static boolean wall;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[W];
		
		for(int i=0; i<W; i++) {
			arr[i] = Integer.parseInt(st.nextToken());				
		}
		search();
		System.out.println(sum);
	}

	private static void search() {
		for (int i = 1; i < W; i++) {
			int left = 0, right = 0;

			for (int j = 0; j < i; j++) {
				left = Math.max(left, arr[j]);
			}

			for (int j = i + 1; j < W; j++) {
				right = Math.max(right, arr[j]);
			}
			if (arr[i] < left && arr[i] < right) {
				int min = Math.min(left, right);
				sum += (min - arr[i]);
			}
		}
	}
}

