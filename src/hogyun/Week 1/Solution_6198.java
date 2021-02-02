package stack;

import java.util.Scanner;
import java.util.Stack;

public class Solution_6198 {
	public static int N;
	public static int []arr; 
	public static Stack<Integer> st = new Stack<>();
	public static long sum;
	
	public static void getSum() {
		for(int i=0; i<N; ++i) {
			while(st.empty() == false && st.peek() <= arr[i]) {
				st.pop();
			}
			st.push(arr[i]);
			sum += st.size() - 1;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		
		for(int i=0; i<N; ++i) 
			arr[i] = sc.nextInt();
		
		getSum();
		System.out.println(sum);
		sc.close();
		
	}
}
