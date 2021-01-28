package stack;

import java.util.Scanner;

public class back_9012 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String[] arr = new String[T];
		for(int i=0; i<T; i++) {
			String[] ps = sc.next().split("");
			int cnt=0;
			for(int j=0; j<ps.length; j++) {
			if(ps[j].equals("(")) {
				cnt++;
			}
			else if(ps[j].equals(")")){
				cnt--;
			}
			if(cnt<0) {
				arr[i]="NO";
				break;
			}
			}
			if(cnt==0) arr[i]="YES";
			else arr[i]="NO";
		}
		for(String x:arr) {
			System.out.println(x);
		}
		sc.close();
	}
}

