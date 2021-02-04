package sujin.Week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

//탑
public class Q2493 {

	public static class Top {
		public int index;
		public int height;
		
		public Top(int index, int height) {
			super();
			this.index = index;
			this.height = height;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Top> st = new Stack<Top>();
		
		// input
		int num = Integer.parseInt(br.readLine()); // 탑 개수
		StringTokenizer s = new StringTokenizer(br.readLine());

		// sol
		for(int i=0;i<num;i++){
			int h = Integer.parseInt(s.nextToken());
			while(!st.empty()) {
				// 스택 최상단 값 > 입력값
				if (st.peek().height > h) {
					// 신호 받을 수 있는 탑 찾으면 스택 최상단값 index 출력하고 while 탈출
					bw.write((st.peek().index+1) + " ");
					break;
				}
				// 스택 최상단 값 > 입력값 일때까지 비교해주기 위해 조건 안맞으면 pop
				st.pop();
			}
			
			// 스택이 비어있다면 0 출력
			if (st.empty())
				bw.write("0 ");
			st.push(new Top(i, h));
		}
		bw.flush();
	}
}
