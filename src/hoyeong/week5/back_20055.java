package hoyeong.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_20055 {
	static int N,K,cnt;
	static Deque <Integer> d = new ArrayDeque<>();
	static int [] arr;
	static int [] robot;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		robot = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N*2; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(i<N) arr[i] = num;
			else d.addFirst(num);
		}
		belt();
		System.out.println(cnt);
		
		for(int x:arr)
			System.out.print(x+" ");
		System.out.println();
		for(int x:d)
			System.out.print(x+" ");
		
	}
	private static void belt() {
		cnt=0;
		while(true) {
			cnt++;
			int result=0;
			for(int i=N-1; i>0; i--) { // 컨베이어 벨트 회전
				if(i==N-1) d.addLast(arr[i]);
				arr[i] = arr[i-1];
				robot[i] = robot[i-1];
			}
			arr[0] = d.pollFirst();
			robot[0]=0;
			robot[N-1]=0;
			
			for(int i=N-1; i>0; i--) { // 로봇 이동
				if(robot[i-1]==1 && robot[i]==0 && arr[i]>=1) {
					robot[i] = robot[i-1];
					robot[i-1]=0;
					arr[i] = arr[i]-robot[i];
				}
			}
						
			if(arr[0]>0) { // 1번째 칸에서 로봇 새로 생성
				robot[0] = 1;
				arr[0]--;
			}
			else robot[0] = 0;
			
			for(int x:d) {
				if(x==0) result++;
			}
			for(int x: arr) {
				if(x==0) result++;
			}
			
			if(result>=K) break;
		}
	}
}
