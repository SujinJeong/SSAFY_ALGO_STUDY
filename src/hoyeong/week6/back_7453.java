package hoyeong.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class back_7453 {
	static int N; 
	static long cnt=0; // cnt의 최대가 N*N*N*N이 될 수 있으므로 long으로 놓아야함
	static long [] A;
	static long [] B;
	static long [] C;
	static long [] D;
	static long [] AB;
	static long [] CD;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		A = new long[N];
		B = new long[N];
		C = new long[N];
		D = new long[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
				A[i] = Long.parseLong(st.nextToken());
				B[i] = Long.parseLong(st.nextToken());
				C[i] = Long.parseLong(st.nextToken());
				D[i] = Long.parseLong(st.nextToken());
		}
		
		AB = new long[N*N];
		CD = new long[N*N];
		
		int idx=0;
		for(int i=0; i<N; i++) { 
			for(int j=0; j<N; j++) {
				AB[idx] = A[i]+B[j];  // A와B의 합으로 구성된 AB 배열 생성
				CD[idx] = C[i]+D[j];  // C와D의 합으로 구성된 CD 배열 생성
				idx++;
			}
		}
		
		Arrays.sort(AB);
		Arrays.sort(CD);
				
		point();
		System.out.println(cnt);
	}
	
	private static void point() {
		int idx1=0, idx2=N*N-1;
		while(idx1<N*N && idx2>=0) {
			if(AB[idx1]+CD[idx2]<0) {
				idx1++;
			}
			else if(AB[idx1]+CD[idx2]>0) {
				idx2--;
			}
			else {
				long cnt1=0, cnt2=0; // cnt의 갯수가 int 값을 벗어날 수 있으므로 long
				long ab=AB[idx1], cd=CD[idx2];
				while(idx1<AB.length && AB[idx1]==ab) { // 합이 중복일 경우 중복 값들의 갯수 카운팅
					idx1++;
					cnt1++;
				}
				
				while(idx2>=0 && CD[idx2]==cd) {
					idx2--;
					cnt2++;
				}
				cnt+=cnt1*cnt2;
			}
		}
	}
	
}
