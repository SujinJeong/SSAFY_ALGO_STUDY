package sujin.Deque;

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
			arr.add(Integer.parseInt(st.nextToken())); // ����� ��ų ������ ����
		
		// sol
		dq.addLast(1); // ������ ������ ī��� �ΰ� �̻� ī�尡 ���� ������ 1 ������
		for (int i = N-2; i >= 0; i--) {
			if (arr.get(i) == 1) { // ���� ���� ī�� 1��
				dq.addFirst(N-i); // ���� �� ī��� �Ǿ�����
			}
			else if (arr.get(i) == 2) { // �ι�° ���� ī�� 1��
				int tmp = dq.removeFirst(); // �ι�°�� �Ǿ���� ���� ���� ���ؼ� ���ֱ�
				dq.addFirst(N-i); // �ι�°�� ����
				dq.addFirst(tmp); // �����ص� ���Ҹ� �� ������ �ٽ� �о�ֱ�
			}
			else { // ���� �ؿ� ī�� 1��
				dq.addLast(N-i);
			}
		}
		
		// output
		StringBuilder sb = new StringBuilder();
		for (Integer d : dq)
			sb.append(d + " "); // �������� ���
		
		System.out.println(sb);
		br.close();
	}

}
