package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//2798
public class Solution_2798 {
	public static int N, M, res;
	public static int[] arr;
	public static boolean[] visited;

	public static int combination() {
		for (int i = 0; i < N - 2; i++) {
			for (int j = i + 1; j < N - 1; j++) {
				for (int k = j + 1; k < N; k++) {
					int tmp = arr[i] + arr[j] + arr[k];		
					if (M == tmp) {	
						return tmp;
					}				
					if(res < tmp && tmp < M) {
						res = tmp;
					}
				}
			}
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		res = 0;
		visited = new boolean[N];
		System.out.println(combination());
	}
}
