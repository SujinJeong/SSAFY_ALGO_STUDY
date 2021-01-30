package hogyun.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_2493 {
	public static int N;
	public static int[] arr, res;
	public static Stack<Top> stk = new Stack<>();

	static class Top {
		int first;
		int second;

		public Top(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //scanner 사용 시 메모리 초과
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		arr = new int[N + 1];
		res = new int[N + 1];
		for (int i = 1; i <= N; ++i)
			arr[i] = Integer.parseInt(st.nextToken());

		stk.push(new Top(arr[N], N));
		for (int i = N - 1; i > 0; --i) {
			if (stk.peek().first > arr[i]) {
				stk.push(new Top(arr[i], i));
			} else {
				while (!stk.empty() && stk.peek().first < arr[i]) {
					res[stk.peek().second] = i;
					stk.pop();
				}
				stk.push(new Top(arr[i], i));
			}
		}
		for (int i = 1; i <= N; ++i) {
			System.out.print(res[i] + " ");
		}
	}
}
