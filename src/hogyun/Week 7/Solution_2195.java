package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2195 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		int res = 0;
		int idx = 0;
		while (true) {
			int tmpMax = 0;
			int cnt = 1;
			for (int i = 0; i <= str1.length() - cnt; ++i) {
				int tmpCnt = 0;
				for (int j = 0; j < cnt; ++j) {
					if(idx + j >= str2.length())
						break;
					if (str1.charAt(i + j) == str2.charAt(idx + j)) {
						tmpCnt++;
					}else {
						break;
					}
				}
				if (tmpMax < tmpCnt) {
					i--;
					cnt++;
					tmpMax = tmpCnt;
				}
			}
			idx += tmpMax;
			res++;
			if (idx >= str2.length())
				break;
		}
		System.out.println(res);
	}
}
