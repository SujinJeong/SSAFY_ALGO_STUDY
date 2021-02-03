package hoyeong.Brute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

class input{
	int a;
	int b;
	public input(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
}

public class back_15686 {
	public static int N;
	public static int M;
	public static List<input> house;
	public static List<input> chicken;
	static Stack<input> select;
	public static int Real_Min=Integer.MAX_VALUE;
	
	private static void makeCombination(int start, int count) {
		if(count==M) {
			dis();
			return;
		}
		for(int i=start; i<chicken.size(); i++) {
				select.push(chicken.get(i));
				makeCombination(i+1,count+1);
				select.pop();
			} 
	}
	
	public static void dis() {
		int sum=0;
		for(input h:house) {
			int min = 999;
			for(input s:select){
				int d = Math.abs(s.a-h.a) + Math.abs(s.b-h.b);
				min = Math.min(min, d);
			}
			sum+=min;
		}
		if(sum<Real_Min) {
			Real_Min=sum;
		}
		
		}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int [][] map = new int[N][N];
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		select = new Stack<>();
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N;j++) {
			map[i][j]=Integer.parseInt(st.nextToken());
			if(map[i][j]==1) house.add(new input(i,j));
			else if(map[i][j]==2) chicken.add(new input(i,j));
			}
		}
		makeCombination(0,0);
		System.out.println(Real_Min);
	}
}

/*
5 3
0 0 1 0 0
0 0 2 0 1
0 1 2 0 0
0 0 1 0 0
0 0 0 0 2
*/
