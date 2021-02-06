package hoyeong.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class back_14888 {
	static int N;
	static List<String> arr = new ArrayList<>(); 
	static List<String> change = new ArrayList<>();
	static int [] cal = new int[4];
	static int max = Integer.MIN_VALUE;;
	static int min = Integer.MAX_VALUE;;
	
	private static void permu(int cnt, String[] save, boolean[] flag) { // change 리스트의 값들 순열
		if(cnt == N-1) {
			calculate(save);
			return;
		}
		for(int i=0; i<change.size(); i++) {
			if(!flag[i]) {
				flag[i]=true;
				save[cnt]=change.get(i);
				permu(cnt+1,save,flag);
				flag[i]=false;
			}
		}
	}
	
	static void calculate(String [] save) { // 들어온 배열 계산하여 min,max 출력
		int result = 0;
		int cnt=0;
		for(int i=0; i<arr.size(); i++) {
			if(i%2==1) {arr.set(i,save[cnt]);cnt++;}
			if(i==0) result = Integer.parseInt(arr.get(i));
			if(i>=2) {
				switch(arr.get(i-1)) {
				case "+": result = result+Integer.parseInt(arr.get(i)); break;
				case "-": result = result-Integer.parseInt(arr.get(i)); break;
				case "x": result = result*Integer.parseInt(arr.get(i)); break;
				case "/": result = result/Integer.parseInt(arr.get(i)); break;
				}
			}
		}
		if(result>max) max=result;
		if(result<min) min=result;		
	}
	
	static void trans(int [] cal) { // cal 배열 사칙연산 기호로 변환 후 change 리스트에 보관
		for(int i=0; i<cal.length; i++) {
			for(int j=0; j<cal[i]; j++) {
				switch(i) {
				case 0: change.add("+"); break;
				case 1: change.add("-"); break;
				case 2: change.add("x"); break;
				case 3: change.add("/"); break;
				}
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr.add(st.nextToken());
			if(i==N-1) break;
			arr.add(null);
			}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			cal[i] = Integer.parseInt(st.nextToken());
			}
		
		trans(cal); //cal 배열에 들어온 값으로 사칙연산 기호로 변환
		permu(0,new String[N-1],new boolean[change.size()]); //들어온 사칙연산 순열로 선택
		
		System.out.println(max); //-- 출력
		System.out.println(min);
	}
}
