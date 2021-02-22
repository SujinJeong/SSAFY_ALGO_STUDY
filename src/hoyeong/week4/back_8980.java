package hoyeong.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class box {
	int from;
	int to;
	int num;
	public box(int from, int to, int num) {
		super();
		this.from = from;
		this.to = to;
		this.num = num;
	}
}

public class back_8980 {
	static int N, C, M, to, from, num, sum;
	static ArrayList<box> list = new ArrayList<>();
	static Queue<box> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			from= Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			num = Integer.parseInt(st.nextToken());
			list.add(new box(from,to,num));
		}
		
		Collections.sort(list,new Comparator<box>() {
			public int compare(box a, box b) {
				int result;
				if(a.to==b.to) {
					result = a.from<b.from ? -1:1;
				}
				else result = a.to<b.to ? -1:1;
				return result;
			}
		});
		
		for(box x : list)	{
			System.out.println(x.from+" "+x.to+" "+x.num);
			q.add(x);
		}
		
		sum=0;
		move();
		System.out.println(sum);
	}
	private static void move() {
		int [] weight = new int[N+1];
		for(int i=1; i<=N; i++) {
			weight[i] = C;
		}
		while(!q.isEmpty()) {
			int min = 987654321;
			for(int i=q.peek().from; i<q.peek().to; i++) {
				min = Math.min(min, weight[i]);
			}
			if(q.peek().num > min) {
				for(int i=q.peek().from; i<q.peek().to; i++) {
					weight[i]-=min;
				}
				sum+=min;
			}
			else {
				for(int i=q.peek().from; i<q.peek().to; i++) {
					weight[i]-=q.peek().num;
				}
				sum+=q.peek().num;
			}
			q.poll();
		}
	}
}
