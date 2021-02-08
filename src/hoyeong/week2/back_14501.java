package hoyeong.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class input2 {
	int a;
	int b;
	public input2(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
}


public class back_14501 {
	static List<input2> list;
	static int N;
	static int sum=0;
	static int max = Integer.MIN_VALUE;
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			list.add(new input2(T,P));
		}
		compare(0,0);
		System.out.println(max);
		
	}
	
	private static void compare(int idx, int sum) {
		max = Math.max(max, sum);
		if(idx==N) return;
		
		if(idx+list.get(idx).a<=N) { // 다음칸으로 갈 수 있으면
			compare(idx+list.get(idx).a,sum+list.get(idx).b);
		}
		compare(idx+1,sum);
		
		/*private static void compare(int idx, int sum) {
			max = Math.max(max, sum);
			for(int i=start; i<N; i++) {
				if(start==0) sum=0;
				if(i+list.get(i).a<N) {
				compare(i+list.get(i).a,sum+list.get(i).b);
			}
		}*/
	}
}
