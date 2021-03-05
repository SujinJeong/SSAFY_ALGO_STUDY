package hashmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Solution_2002 {
	static int N;
	static HashMap<String, Integer> first = new HashMap<>();
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		for (int i = 1; i <= N; ++i) {
			String str = br.readLine();
			first.put(str, i);
		}
		for (int i = 1; i <= N; ++i) {
			String str = br.readLine();
			arr[i] = first.get(str);
		}
		int res = 0;
		for (int i = 1; i <= N; ++i) {
			for (int j = i + 1; j <= N; ++j) {
				if (arr[i] > arr[j]) {
					res++;
					break;
				}
			}
		}
		System.out.println(res);
	}
}
