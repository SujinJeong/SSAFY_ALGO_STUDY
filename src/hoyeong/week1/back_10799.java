package hoyeong.week1;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

class In{
	String gual;
	int cnt;
	public In(String gual, int cnt) {
		super();
		this.gual = gual;
		this.cnt = cnt;
	}
}

public class back_10799 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<In> stack = new Stack<>();
		String[] arr = sc.next().split("");
		int sum=0;
		int LC=0;
		for(int i=0; i<arr.length;i++) {
			if(arr[i].equals("(")) stack.push(new In("(",0)); // "(" 일때는 무조건 push
			else if((arr[i].equals(")"))){					 // ")" 일 때
				try {
					if(stack.peek().gual.equals("(") && stack.peek().cnt==0) { // 레이저일 때
						stack.pop();
						++stack.peek().cnt;
					}
					else { // 막대가 끝날 때
						sum += stack.peek().cnt+1;
						LC = stack.peek().cnt;
						stack.pop();
						stack.peek().cnt += LC;
					}
				} catch (EmptyStackException e) {
				}
			}
			
		}
		System.out.println(sum);
		sc.close();
	}
}
