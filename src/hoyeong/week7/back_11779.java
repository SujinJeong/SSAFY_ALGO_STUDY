package hoyeong.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

class Bus implements Comparable<Bus>{
	int end, distance;
	
	public Bus(int end, int distance) {
		super();
		this.end = end;
		this.distance = distance;
	}

	@Override
	public int compareTo(Bus o) {
		return distance - o.distance;
	}
	
}

public class back_11779 {
	static int N,M,Start,Dest;
	static long INF = Long.MAX_VALUE;
	static boolean [] visited;
	static long [] dis;
	static LinkedList<Bus> [] list;
	static int [] prenode;
	static PriorityQueue <Bus> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		list = new LinkedList[N+1];
		visited = new boolean[N+1];
		dis = new long[N+1];
		dis[0] = 0;
		prenode = new int [N+1];
		
		for(int i=1; i<=N; i++) {
			list[i] = new LinkedList<Bus>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			list[s].add(new Bus(e,d));
		}
		
		st = new StringTokenizer(br.readLine());
		Start = Integer.parseInt(st.nextToken());
		Dest = Integer.parseInt(st.nextToken());
		
		djikstra(Start);
		System.out.println(dis[Dest]);
		
/*		int cnt=0;
		while(true) {
			cnt++;
			sb.append(Dest+" ");
			Dest = prenode[Dest];
			if(Dest==Start) {
				cnt++;
				sb.append(Dest);
				break;
			}
		}
		System.out.println(cnt);
		System.out.println(sb.reverse().toString());*/
		
        Stack<Integer> stack = new Stack<>();
        while (true) {
            stack.push(Dest);
            Dest = prenode[Dest];
            if (Dest == Start) {
                stack.push(Dest);
                break;
            }
        }
        System.out.println(stack.size());
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
	}
	
	private static void djikstra(int start) {
		Arrays.fill(dis, INF);
		dis[start] = 0;
		pq.add(new Bus(start,0));
		
		while(!pq.isEmpty()) {
			Bus b = pq.poll();
			int e = b.end;
			int d = b.distance;
			if(e == Dest) break;
			if(dis[e]<d) continue;
			for(int i=0; i<list[e].size(); i++) {
				int next = list[e].get(i).end;
				int next_dis = d + list[e].get(i).distance;
				if(dis[next] > next_dis) {
					dis[next] = next_dis;
					prenode[next] = e;
					pq.add(new Bus(next,next_dis));
				}
			}
		}
	}

}
