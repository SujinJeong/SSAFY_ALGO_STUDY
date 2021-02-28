package hoyeong.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class DRG{
	int D;
	int R;
	int G;
	public DRG(int d, int r, int g) {
		super();
		D = d;
		R = r;
		G = g;
	}
}
public class back_2980 {
	static ArrayList<DRG> list = new ArrayList<>();
	static boolean [] arr;
	static int [][] set;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		arr = new boolean[L+1];
		set = new int [L+1][2]; // G/R을 구분해 줄 2차원 배열 생성
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			list.add(new DRG(d,r,g));
		}
		
		for(DRG x:list) { //2차원 배열에서 0일때 G(false) 1일때 R(true)
			set[x.D][1] = x.R; //초기값이 R부터 시작이므로 2차원 배열에 R값 채워줌
		}
		
		int cnt=1;
		int time=0;
		while(true) {
			setting();
			time++;
			if(arr[cnt]) { //빨간불이면 시간만 늘려주고 다음으로 진행
				continue; 
			}
			cnt++; //초록불
			if(cnt==L) break;
		}
		System.out.println(time);
	}
	
	private static void setting() {
		for(DRG x:list) {
			if(set[x.D][0]>0) { // set[index][0]이 0보다 큰 값이면 Green
				arr[x.D] = false; // arr false로 바꿔줌
				--set[x.D][0]; // 1초가 지났으므로 set[index][0]의 값을 내려줌
				if(set[x.D][0]==0) { // Green이 0 이라면 Red값을 채워줌
					set[x.D][1]=x.R;
					continue;
				}
			}
			else if(set[x.D][1]>0) { // set[index][1]이 0보다 큰 값이면 Red
				arr[x.D] = true; // arr true로 바꿔줌
				--set[x.D][1]; // 1초가 지났으므로 set[index][1]의 값을 내려줌
				if(set[x.D][1]==0) { // Red가 0 이라면 Green 값을 채워줌
					set[x.D][0]=x.G;
					continue;
				}
			}
		}
	}
}
