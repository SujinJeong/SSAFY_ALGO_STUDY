package hoyeong.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
// mid 이하인 값으로 5까지 갈 수 있는가? mid 넘는 값의 허용 횟수 K개 줌
class b_1800 implements Comparable<b_1800>{
	int t,p;

	public b_1800(int t, int p) {
		super();
		this.t = t;
		this.p = p;
	}

	@Override
	public int compareTo(b_1800 o) {
		return this.t - o.t;
	}	
}

public class back_1800 {
	static int N,P,K,INF=987654321;
	static int [] dis,cnt;
	static ArrayList<b_1800> [] list;
	static PriorityQueue<b_1800> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		dis = new int[N+1];
		
		int high = 0;
		for(int i=0; i<P; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			list[from].add(new b_1800(to,price)); // b_1800에 to,와 가격이 들어감
			list[to].add(new b_1800(from,price));
			high = Math.max(high, price);
		}
		
		int result=INF;
		int low = 0;
		
		while(low<=high) {
			int mid = (low+high)/2; // 넘을 수 있는 가격의 최대 노드
			
			if (dijk(mid)) {
				result = Math.min(result, mid);
				high = mid - 1;
			}
			else low = mid+1;
		}
		if(result==INF) System.out.println(-1); // 연결할 수 없는 경우
		else System.out.println(result);
	}
	
	private static boolean dijk(int mid) {
		pq.clear();
		Arrays.fill(dis, INF);
		dis[1] = 0;
		pq.add(new b_1800(1,0));
		
		while(!pq.isEmpty()) {
			b_1800 b = pq.poll();
			int to = b.t;
			int p = b.p; // 넘은것이 몇개인지 판단하는 기준
			
			if(to==N) {
				if(p<=K) return true;
			}
			
			for(int i=0; i<list[to].size(); i++) {
				int next = list[to].get(i).t;
				int next_p = p;
				
				if(list[to].get(i).p > mid) {
					next_p++; // 결과적으로 5까지 가는 p가 K 넘는지 확인
				}
				
				if (dis[next] > next_p) { // 최단거리
					dis[next] = next_p;
					pq.add(new b_1800(next, next_p));
				}
				
			}
		}		
		return false;
	}
}
