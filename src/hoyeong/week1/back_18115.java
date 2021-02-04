package hoyeong.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;


public class back_18115 {
	public static int save=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		Deque<Integer> d = new ArrayDeque<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int [] arr = new int[(int) (N+1)];
		for(int i=(int) N; i>0; i--) { // A 거꾸로 저장
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=N; i++) {
			switch(arr[i]) {
			case 1:  d.addFirst(i); break; //1번 기술일 때
			case 2: { // 2번 기술일 때
				save=d.pollFirst();
				d.addFirst(i);
				d.addFirst(save);
				break;
				}
			case 3: d.addLast(i); break; //3번 기술일 때
			}
		}
		StringBuilder sb = new StringBuilder();
        for(int i=1;i<=N;i++)
        {
            sb.append(d.pollFirst()+" ");
        }
        System.out.println(sb);
}
}
/*
5
1 1 1 1 1

5
2 3 3 2 1
*/
