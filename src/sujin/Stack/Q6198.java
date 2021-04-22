package sujin.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/*
6
10
3
7
4
12
2
 */
public class Q6198 {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> st = new Stack<Integer>();
        // int < long
        long sum = 0;
        
        int TC = Integer.parseInt(br.readLine());
        for (int i = 0; i < TC; i++) {
        	int floor = Integer.parseInt(br.readLine()); // �� �� �Է¹ޱ�
        	// �Է°����� ���ÿ� �ִ� ���� ������ ��
        	// if�� �ƴ϶� while�ΰ� �ٽ� ex) i=4�� ���
        	while (!st.empty() && st.peek() <= floor)
        		st.pop();
        	st.push(floor);
        	sum += st.size() - 1;
        }
        System.out.println(sum);
	}
}