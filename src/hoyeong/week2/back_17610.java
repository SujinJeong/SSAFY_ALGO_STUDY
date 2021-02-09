package hoyeong.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_17610 {
	static int N;
	static int [] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		compare(0, new boolean[N]);
	}	
	
	private static void compare(int cnt, boolean [] flag) {
		if(cnt==N) {
			for(int i=0; i<N; i++) {
				if(flag[i]) System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		}
		
		flag[cnt]=true;
		compare(cnt+1, flag);
		flag[cnt]=false;
		compare(cnt+1, flag);
	}
	
}
