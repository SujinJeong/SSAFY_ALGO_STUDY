package sujin.Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

//ž
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
		int num = Integer.parseInt(br.readLine()); // ž ����
		StringTokenizer s = new StringTokenizer(br.readLine());

		// sol
		for(int i=0;i<num;i++){
			int h = Integer.parseInt(s.nextToken());
			while(!st.empty()) {
				// ���� �ֻ�� �� > �Է°�
				if (st.peek().height > h) {
					// ��ȣ ���� �� �ִ� ž ã���� ���� �ֻ�ܰ� index ����ϰ� while Ż��
					bw.write((st.peek().index+1) + " ");
					break;
				}
				// ���� �ֻ�� �� > �Է°� �϶����� �����ֱ� ���� ���� �ȸ����� pop
				st.pop();
			}
			
			// ������ ����ִٸ� 0 ���
			if (st.empty())
				bw.write("0 ");
			st.push(new Top(i, h));
		}
		bw.flush();
	}
}
