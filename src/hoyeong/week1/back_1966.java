package hoyeong.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



class Index implements Comparable<Index>{
	int idx;
	int num;
	public Index(int idx, int num) {
		super();
		this.idx = idx;
		this.num = num;
	}
	public int compareTo(Index o) {
		if(o.num==this.num) return Integer.compare(this.idx,o.idx);
		return Integer.compare(o.num,this.num);
	}
	
}

public class back_1966 {
	public static int N;
	public static int M;
	static Index[] list;
	public static int idx;
	public static int num;
	public static int cnt;
	static int [] arr;
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		Queue <Index> q = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		arr = new int[t];
		for(int i=0; i<t; i++) {
			cnt=0;
			q.clear();
				StringTokenizer st = new StringTokenizer(br.readLine());
				N = Integer.parseInt(st.nextToken());
				list = new Index[N];
				M = Integer.parseInt(st.nextToken());
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N;j++) {
					num = Integer.parseInt(st.nextToken());
					q.add(new Index(j,num));
					list[j] = new Index(j,num);
					}
				
				Arrays.sort(list);
						
				for(int k=0; k<N;k++) {
					while(q.peek().num < list[k].num) {
						q.add(q.poll());
					}
					if(q.peek().idx==M) {cnt++; break;}
					q.remove(); // 출력
					cnt++;					
				}
			arr[i]=cnt;
			}
		br.close();
		for(int i:arr)
		System.out.println(i);
	}
/*
3
1 0
5
4 2
1 2 3 4
6 0
1 1 9 1 1 1
*/
}

