package sujin.Week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q9935 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		// input
		String s = br.readLine();
		String bomb = br.readLine();
		
		// sol
		for (int i = 0; i < s.length(); i++) {
			sb.append(s.charAt(i));
			if (sb.charAt(sb.length()-1) == bomb.charAt(bomb.length()-1)) { // ��ź�� �� ������ ���ڸ� ��������
				// ���ڿ� ���̰� ���߹��ڿ� ���̺��� ª�� ���
				if(sb.length() < bomb.length()) continue;
				else {
					// �� ������ ���� �ٷ� �� ���ں��� ��ź���� �˾ƺ���
					if (sb.substring(sb.length()-bomb.length()).equals(bomb)) {
						sb.delete(sb.length() - bomb.length(), sb.length());
					}
				}
			}
		}
		
		// output
		if (sb.length() == 0)
			sb.append("FRULA");
		
		bw.write(sb.toString());
		bw.flush();
	}

}
