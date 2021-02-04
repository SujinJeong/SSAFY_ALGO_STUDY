package hoyeong.week1;
/*
6
10
3
7
4
12
2
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class back_6198 {
	public static int N;
	public static int [] arr;
	public static long sum=0;
	public static void main(String[] args) throws NumberFormatException,IOException {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		for(int i=0; i<N;i++) 
			arr[i] = Integer.parseInt(br.readLine());
		for(int i=0; i<N;i++) {
			while(!stack.isEmpty()&& stack.peek()<=arr[i]) {
					stack.pop();
				}
			sum+=stack.size(); // stack에 쌓여있는 모든 수보다 h가 작기 때문에 카운팅 해줘야함
			stack.push(arr[i]);
			}
		System.out.println(sum);
		}	
}
