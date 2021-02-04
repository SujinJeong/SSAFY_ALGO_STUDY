package hoyeong.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_11866 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		List<Integer> arr = new ArrayList<>();
		int K = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=N;i++) {
			q.add(i);
		}
		
		while(!q.isEmpty()) {
			for(int j=0; j<K-1; j++) q.add(q.poll());
			arr.add(q.poll());
		}
		
		System.out.print("<");
		for(int i=0; i<arr.size();i++) {
		System.out.print(arr.get(i));
		if(i==arr.size()-1) break;
		System.out.print(", ");
		}
		System.out.println(">");
	}
}
