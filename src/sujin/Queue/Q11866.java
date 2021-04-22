package sujin.Queue;

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
		
		int cnt = 1; // ��� ���Ҹ� �� ���Ҵ��� Ȯ��
		
		for (int i = 0; i < N; i++)
			q.add(i+1);
		
		System.out.print("<");
		while (!q.isEmpty()) {
			if (cnt != K) { // ���� K��°�� �ƴ� ���
				q.add(q.peek()); // �ڿ��ٰ� �ٽ� �ٿ��ֱ�
				q.poll();
				cnt++;
			}
			else {
				if (q.size() == N) System.out.print(q.peek());
				else System.out.print(", " + q.peek());
				q.poll();
				cnt = 1; // �ٽ� �ش��° ���� ã���ֱ� ���� �ʱ�ȭ
			}
		}
		System.out.println(">");
		sc.close();
	}

}
