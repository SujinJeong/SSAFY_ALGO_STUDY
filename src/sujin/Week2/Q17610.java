package sujin.Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
1. �׸� �ݴ��ʿ� �߸� �ø��� ��� ��� ++
=> scale(i + 1, ���� ���� + i��° �� ����); 
2. �׸��ʿ� �߸� �÷� ���� ��� ���繫�Կ��� --
=> scale(i + 1, abs(���� ���� - i��° �� ����); 
3. �ش� �߸� �ƹ����� �÷� ���� �ʴ� ��� ���� ����
=> scale(i + 1, ���� ����);
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
			// 0~num-1��° �߸� ���������� 3���� ����� �� �� �Ѱ� ����
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
		
		// 1~sum���� �� �߿� ���� ���Դ��� Ȯ��
		visited = new boolean[sum+1];
		scale(0, 0);
		
		for (int i = 1; i <= sum; i++)
			if (!visited[i]) cnt++;
		System.out.println(cnt);
	}

}
