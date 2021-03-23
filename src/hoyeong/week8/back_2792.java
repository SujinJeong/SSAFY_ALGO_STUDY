package hoyeong.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class back_2792 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long N = Long.parseLong(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long [] arr = new long[M];
		
		long max=0;
		for(int i=0; i<M; i++) {
			arr[i] = Long.parseLong(br.readLine());
			max = Math.max(max, arr[i]);
		}
		long result = Long.MAX_VALUE;
		long L=1, H=max;
		while(L<=H) {
			long mid = (L+H)/2;
			int cnt=0;
			for(int i=0; i<M; i++) {
				cnt += arr[i]/mid;
				if(arr[i]%mid >0) cnt++;
			}
			if(cnt<=N) {
				result = Math.min(result, mid);
				H = mid-1;
			}
			else {
				L = mid+1;
			}
		}
		System.out.println(result);
		
	}

}
