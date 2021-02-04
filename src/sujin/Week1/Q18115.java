package sujin.Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q18115 {
	static Deque<Integer> dq = new ArrayDeque<Integer>(); 
	static ArrayList<Integer> arr;
	static int N;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// input
		N = Integer.parseInt(br.readLine());
		arr = new ArrayList<>();
		st = new StringTokenizer(br.readLine());;
		while(st.hasMoreTokens()) 
			arr.add(Integer.parseInt(st.nextToken())); // 몇번빼 스킬 쓸건지 저장
		
		// sol
		dq.addLast(1); // 어차피 마지막 카드는 두개 이상 카드가 없기 때문에 1 전략임
		for (int i = N-2; i >= 0; i--) {
			if (arr.get(i) == 1) { // 제일 위의 카드 1장
				dq.addFirst(N-i); // 제일 위 카드는 맨앞으로
			}
			else if (arr.get(i) == 2) { // 두번째 위에 카드 1장
				int tmp = dq.removeFirst(); // 두번째가 되어야할 원소 저장 위해서 빼주기
				dq.addFirst(N-i); // 두번째꺼 저장
				dq.addFirst(tmp); // 저장해둔 원소를 맨 앞으로 다시 밀어넣기
			}
			else { // 제일 밑에 카드 1장
				dq.addLast(N-i);
			}
		}
		
		// output
		StringBuilder sb = new StringBuilder();
		for (Integer d : dq)
			sb.append(d + " "); // 맨위부터 출력
		
		System.out.println(sb);
		br.close();
	}

}
