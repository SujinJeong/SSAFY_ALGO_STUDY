package hoyeong.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class taste{
	int sour;
	int bitter;
	public taste(int s, int b) {
		super();
		sour = s;
		bitter = b;
	}
	@Override
	public String toString() {
		return "taste [sour=" + sour + ", bitter=" + bitter + "]";
	}
	
}

public class back_2961 {
	static List<taste> list = new ArrayList<>();
	static int N;
	static int result=Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sour = Integer.parseInt(st.nextToken());
			int bitter = Integer.parseInt(st.nextToken());
			list.add(new taste(sour, bitter));
		}
		compare(0,new boolean[N]);
		System.out.println(result);
	}
	
	private static void compare(int select,boolean[] flag) {
		if(select==N) {
			int cnt=0;
			int sum_s=1;
			int sum_b=0;
			for(int i=0; i<N; i++) {
				if(flag[i]) {
					cnt++;
					sum_s = sum_s *list.get(i).sour;
					sum_b += list.get(i).bitter;
				}
				if(cnt!=0 && Math.abs(sum_b-sum_s)<result) result=Math.abs(sum_b-sum_s);
			}
			return;
			
		}
		//선택
		flag[select] = true;
		compare(select+1,flag);
		// 비선택
		flag[select]=false;
		compare(select+1,flag);
	}
}
