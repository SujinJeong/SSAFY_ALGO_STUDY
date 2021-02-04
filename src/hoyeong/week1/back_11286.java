package hoyeong.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;

class Abs implements Comparable<Abs>{
	int x;

	public Abs(int x) {
		super();
		this.x = x;
	}
	@Override
	public int compareTo(Abs o) {
		if(Math.abs(this.x)==Math.abs(o.x)) return this.x>o.x?1:-1;
		return Math.abs(this.x)-Math.abs(o.x);
	}
}
public class back_11286{
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		PriorityQueue<Abs> pq = new PriorityQueue<Abs>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		List <Integer> arr = new ArrayList<>();
		for(int i=0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x==0) {
				if(pq.isEmpty()) arr.add(0);
				else arr.add(pq.poll().x);
			}
			else 
			pq.offer(new Abs(x));
		}
		for(int x:arr) {
			System.out.println(x);
		}
	}
}
/*
18
1
-1
0
0
0
1
1
-1
-1
2
-2
0
0
0
0
0
0
0
*/