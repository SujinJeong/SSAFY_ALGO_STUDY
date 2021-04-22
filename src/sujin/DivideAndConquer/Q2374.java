package sujin.DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q2374 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> st = new Stack<>();
		int sum = 0;
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < n; i++) {
			if (st.isEmpty()) st.push(arr[i]);
			else {
				// 오름차순일때
				while (st.peek() < arr[i]) {
					int top = st.pop();
					
					// 오름차순 중 최종 높이 맞춰주기
					if (st.isEmpty() || st.peek() > arr[i]) {
						sum += arr[i] - top;
						break;
					}
					else { // arr[i]보다 큰거 만날때까지 한칸식 단계별로 맞춰주기
						sum += st.peek() - top;
					}
				}
				// 높이 계산 후 본인 넣어주기
				st.push(arr[i]);
			}
		}
		
		// 내림차순인 애들 높이 맞춰주기
		if (!st.empty()) {
			int low = st.peek();
			// 중간에 있는 애들 제거
			while (st.size() > 1) st.pop(); 
			int high = st.pop();
			sum +=  (high - low);
		}
		System.out.println(sum);
	}
}
