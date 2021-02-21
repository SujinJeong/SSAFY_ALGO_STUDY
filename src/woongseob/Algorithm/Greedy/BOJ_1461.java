package study_0215;

import java.io.*;
import java.util.*;

public class BOJ_1461 {
	static int N, M;
	static ArrayList<Integer> plus = new ArrayList<>();
	static ArrayList<Integer> minus = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int val = Integer.parseInt(st.nextToken());
			if (val < 0) {
				minus.add(val);
			} else {
				plus.add(val);
			}
		}
		
		Collections.sort(plus, Collections.reverseOrder());
		Collections.sort(minus);
		
		int ans = 0;
		for (int i = 0; i < plus.size(); i += M) {
			ans += 2 * plus.get(i);
		}
		for(int i = 0; i < minus.size(); i+= M) {
			ans += (-2 * minus.get(i));
		}
		
		int back = 0;
		if(!minus.isEmpty() && !plus.isEmpty()) {
			back = Math.max(plus.get(0), (-1 * minus.get(0)));
		}
		else if(minus.isEmpty()) {
			back = plus.get(0);
		}
		else {
			back = (-1) * minus.get(0);
		}
		ans -= back;
		
		System.out.println(ans);
	}
}
