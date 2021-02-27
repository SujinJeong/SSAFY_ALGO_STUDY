package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2578 {
	static int[][] arr;
	static int res;
	static boolean[][] visited;
	static Queue<Integer> q = new LinkedList<>();

	public static int[] findXY(int num) {
		int[] tmp = new int[2];
		for (int i = 0; i < 5; ++i) {
			for (int j = 0; j < 5; ++j) {
				if (num == arr[i][j]) {
					tmp[0] = i;
					tmp[1] = j;
				}
			}
		}
		return tmp;
	}

	public static void check1() {
		for (int i = 0; i < 5; ++i) {
			int check = 0;
			for (int j = 0; j < 5; ++j) {
				if (visited[i][j])
					check++;
			}
			if (check == 5)
				res++;
		}
	}

	public static void check2() {
		for (int i = 0; i < 5; ++i) {
			int check = 0;
			for (int j = 0; j < 5; ++j) {
				if (visited[j][i])
					check++;
			}
			if (check == 5)
				res++;
		}
	}
	
	public static void check3() {
		int check = 0;
		for (int i = 0; i < 5; ++i) {
			if(visited[i][i])
				check++;
		}
		if (check == 5)
			res++;
	}
	
	public static void check4() {
		int check = 0;
		for (int i = 0; i < 5; ++i) {
			if(visited[4 - i][i])
				check++;
		}
		if (check == 5)
			res++;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		arr = new int[5][5];
		visited = new boolean[5][5];
		for (int i = 0; i < 5; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 5; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; ++j) {
				q.add(Integer.parseInt(st.nextToken()));
			}
		}
		int cnt = 0;
		while (!q.isEmpty()) {
			res = 0;
			cnt++;
			int hx = q.poll();
			int[] hPos = new int[2];
			hPos = findXY(hx);
			visited[hPos[0]][hPos[1]] = true;
			check1();
			check2();
			check3();
			check4();			
			if(res >= 3) { // ==3이 아니다. 2개가 한 번에 증가할 수 있으므로..
				System.out.println(cnt);
				break;
			}
		}
	}
}
