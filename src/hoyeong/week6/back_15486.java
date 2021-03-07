package hoyeong.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class work{
	int t,p;

	public work(int t, int p) {
		super();
		this.t = t;
		this.p = p;
	}
}
public class back_15486 {
	static int N, max=0;
	static int [] dp;
	static ArrayList<work> list = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			list.add(new work(t,p));
		}
		for(int i=N-1; i>=0; i--)
		move(i);
		
		System.out.println(dp[0]);
	}
	private static void move(int idx) {
		if(idx + list.get(idx).t<=N) {
			dp[idx] = Math.max(dp[idx+1], dp[idx+list.get(idx).t]+list.get(idx).p);
		}else dp[idx] = dp[idx+1];
	}
}
