package hoyeong.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class back_16890 {
	
	static char [] apple, love;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		apple = new char[str1.length()];
		love = new char[str1.length()];
		
		for(int i=0; i<str1.length(); i++) {
			apple[i] = str1.charAt(i);
			love[i] = str2.charAt(i);
		}
		
		Arrays.sort(apple);
		Arrays.sort(love);
		
		int idx1=0, idx2=str2.length()-1;
		
		while (sb.length() != str1.length()) {
			if (sb.length() + 2 <= str1.length()) {
				if (apple[idx1] > love[idx2]) {
					sb.append(love[idx2]);
					if (sb.length() == str1.length())  break;
					sb.append(apple[idx1]);
				} else {
					sb.append(apple[idx1]);
					if (sb.length() == str1.length())  break;
					sb.append(love[idx2]);
				}
				idx1++;
				idx2--;
			}
			else {
				sb.append(apple[idx1]);
			}
		}
		System.out.println(sb.toString());
	}
}
