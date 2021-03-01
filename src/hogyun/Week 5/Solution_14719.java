package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_14719 {
	static int H, W, res;
	static int[] arr;
	static Stack<Integer> stk = new Stack<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		arr = new int[W];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; ++i)
			arr[i] = Integer.parseInt(st.nextToken());

		for (int i = 1; i < W - 1; ++i) {
			int leftMax = 0;
			int rightMax = 0;
			for (int j = 0; j < i; ++j) {
				leftMax = Math.max(leftMax, arr[j]);
			}
			for (int j = i + 1; j < W; ++j) {
				rightMax = Math.max(rightMax, arr[j]);
			}
			if (Math.min(leftMax, rightMax) > arr[i])
				res += Math.min(leftMax, rightMax) - arr[i];
		}
		System.out.println(res);
	}
}
