package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_19539 {
	static int N;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		int sum = 0;
		int sumDivideTwo = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum+=arr[i];
			sumDivideTwo += arr[i]/2;
		}
		if(sum%3 == 0) {
			if(sumDivideTwo >= sum/3) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}else
			System.out.println("NO");
	}
}
