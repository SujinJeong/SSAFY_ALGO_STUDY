package study_0201;

import java.io.*;
import java.util.*;

public class BOJ_2617 {
	static int N, M;
	static ArrayList<Integer>[] heavy;
	static ArrayList<Integer>[] light;
	static boolean[] visit, valid;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		heavy = new ArrayList[N + 1];
		light = new ArrayList[N + 1];
		
		visit = new boolean[N + 1];
		valid = new boolean[N + 1];
		for (int i = 0; i <= N; i++) {
			heavy[i] = new ArrayList<>();
			light[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			heavy[h].add(l);
			light[l].add(h);
		}
		// 풀이
		for (int i = 1; i <= N; i++) {
			init();
			if(HDfs(i) >  (N + 1) / 2) valid[i] = true;
			init();
			if(LDfs(i) >  (N + 1) / 2) valid[i] = true;
		}
		// 출력
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			if (valid[i]) {
				ans++;
			}
		}
		System.out.println(ans);
	}

	public static int HDfs(int start) {
		int cnt = 1; 
		for (int i = 0; i < heavy[start].size(); i++) {
			if (!heavy[start].isEmpty() && !visit[heavy[start].get(i)]) {
				visit[heavy[start].get(i)] = true;
				cnt += HDfs(heavy[start].get(i));
			}
		}
		return cnt;
	}

	public static int LDfs(int start) {
		int cnt = 1;
		for (int i = 0; i < light[start].size(); i++) {
			if (!light[start].isEmpty() && !visit[light[start].get(i)]) {
				visit[light[start].get(i)] = true;
				cnt += LDfs(light[start].get(i));
			}
		}
		return cnt;
	}

	public static void init() {
		for (int i = 0; i <= N; i++) {
			visit[i] = false;
		}
	}

}
