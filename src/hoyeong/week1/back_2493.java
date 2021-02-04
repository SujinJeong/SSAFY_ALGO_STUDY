package hoyeong.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

class Top{
	int idx;
	int height;
	public Top(int idx, int height) {
		super();
		this.idx = idx;
		this.height = height;
	}
}

public class back_2493 {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		Stack<Top> stack = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
 
		for(int i=1; i<=N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(stack.isEmpty()) { //stack이 비어있을 때
				System.out.print("0 ");
				stack.push(new Top(i,num)); //i = index, height = num
			}
			else { // stack이 비어있지 않을 때
				while(true) {
					if(stack.isEmpty()) { //stack이 비어있을 때
						System.out.print("0 ");
						stack.push(new Top(i,num));
						break;
					}
					
					if(stack.peek().height<num) {
						stack.pop();
					}
					else {
						System.out.print(stack.peek().idx+" ");
						stack.push(new Top(i,num));
						break;
					}
				}
			}	
		}
	}
}
