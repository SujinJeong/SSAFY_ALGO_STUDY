package hoyeong.week5;
// leaf노드의 갯수 찾기 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class back_17073 {
	static LinkedList<Integer> [] list ;
	static int N,W,cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		list = new LinkedList[N+1];
		
		for(int i=1; i<=N; i++) {
			list[i] = new LinkedList<Integer>();
		}
		
		for(int i=0;i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int node = Integer.parseInt(st.nextToken());
			int branch = Integer.parseInt(st.nextToken());
			list[node].add(branch);
			list[branch].add(node);
		}
		cnt=0;
		for(int i=2; i<=N; i++) {
			if(list[i].size()==1) cnt++; //1은 무조건 부모노드 이므로 2부터 list의 size가 1인 노드의 갯수
		}
		System.out.printf("%.7f",(double)W/cnt);
		
	}

}
