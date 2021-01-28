package sujin.Jan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
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
        	int floor = Integer.parseInt(br.readLine()); // 층 수 입력받기
        	// 입력값보다 스택에 있는 값이 작은지 비교
        	// if가 아니라 while인게 핵심 ex) i=4인 경우
        	while (!st.empty() && st.peek() <= floor)
        		st.pop();
        	st.push(floor);
        	sum += st.size() - 1;
        }
        System.out.println(sum);
	}
}