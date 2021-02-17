package hogyun.Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_9935 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] arr = br.readLine().toCharArray();
		char[] bomb = br.readLine().toCharArray();
		int bombSize = bomb.length;
		int checkCnt = 0;
		boolean check = false;
		ArrayList<Character> aL = new ArrayList<Character>();
		for (int i = 0; i < arr.length; ++i) {
			aL.add(arr[i]);
			if (arr[i] == bomb[bombSize - 1]) {
				if(aL.size() < bombSize)
					continue;
				for (int j = 0; j < bombSize; ++j) {
					if (aL.get(aL.size() - j - 1) == bomb[bombSize - j - 1]) {
						checkCnt++;
						check = true;
					} else {
						check = false;
						break;
					}
				}
			}
			if (check && checkCnt == bombSize) {
				int Size = aL.size();
				for (int j = 0; j < bombSize; ++j) {
					aL.remove(Size - j - 1);
				}
			}
			check = false;
			checkCnt = 0;
		}
		if (aL.size() == 0) {
			sb.append("FRULA");
			System.out.println(sb.toString());
		}
		else {	
			for(char c : aL) {
				sb.append(c);
			}
			System.out.println(sb.toString());
		}
	}
}
