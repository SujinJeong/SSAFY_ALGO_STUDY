package sujin.Jan;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q11866 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();
		Queue<Integer> q = new LinkedList<Integer>();
		
		int cnt = 1; // 모든 원소를 다 돌았는지 확인
		
		for (int i = 0; i < N; i++)
			q.add(i+1);
		
		System.out.print("<");
		while (!q.isEmpty()) {
			if (cnt != K) { // 아직 K번째가 아닌 경우
				q.add(q.peek()); // 뒤에다가 다시 붙여주기
				q.poll();
				cnt++;
			}
			else {
				if (q.size() == N) System.out.print(q.peek());
				else System.out.print(", " + q.peek());
				q.poll();
				cnt = 1; // 다시 해당번째 원소 찾아주기 위해 초기화
			}
		}
		System.out.println(">");
		sc.close();
	}

}
