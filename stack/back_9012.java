package stack;

import java.util.Scanner;
import java.util.Stack;

public class back_9012 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Stack <String> stack = new Stack<>();
		int T = sc.nextInt();
		
		String[] arr = new String[T];
		for(int i=0; i<T; i++) {
			String[] ps = sc.next().split("");
			for(int j=0; j<ps.length; j++) { //괄호가 들어갔을 때
				if(j==0 && ps[j].equals(")")) {arr[i]="NO"; break;}
				//시작할 때 닫으면 No
				
				if(ps[j].equals("("))  stack.push(ps[j]);
					
				else {
					if(!stack.isEmpty()) stack.pop(); // ")" pop
					else {arr[i]="NO"; break;} // ")" && 스텍이 비어있으면 No
				}
			}
			if(arr[i]==null && stack.isEmpty()) arr[i]="YES";
			else arr[i]="NO";
			stack.clear();
		}
		for(String x:arr) {
			System.out.println(x);
		}
		sc.close();
	}
}

