package sujin.Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
1. 그릇 반대쪽에 추를 올리는 경우 계속 ++
=> scale(i + 1, 현재 무게 + i번째 추 무게); 
2. 그릇쪽에 추를 올려 놓는 경우 현재무게에서 --
=> scale(i + 1, abs(현재 무게 - i번째 추 무게); 
3. 해당 추를 아무데도 올려 놓지 않는 경우 무게 유지
=> scale(i + 1, 현재 무게);
 */
public class Q17610 {
	public static int num;
	public static int[] arr;
	public static boolean[] visited;
	public static int sum = 0, cnt = 0;
	
	public static void scale(int idx, int weight) {
		if (idx == num) {
			if (weight > 0) visited[weight] = true;
			return;
		}
			scale(idx+1, weight+arr[idx]);
			scale(idx+1, weight-arr[idx]);
			scale(idx+1, weight);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		num = Integer.parseInt(br.readLine());
		arr = new int[num];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0 ; i < num; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
		}
		
		visited = new boolean[sum+1];
		scale(0, 0);
		
		for (int i = 1; i <= sum; i++)
			if (!visited[i]) cnt++;
		System.out.println(cnt);
	}

}
