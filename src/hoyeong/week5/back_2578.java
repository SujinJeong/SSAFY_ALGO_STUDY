package hoyeong.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class back_2578 {
	static int result=0, cnt=0;
	static int [][] map = new int [5][5];
	static boolean [][] visited = new boolean [5][5];
	static Queue<Integer> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i=0; i<5;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<5;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				result=0;
				cnt++;
				visit(Integer.parseInt(st.nextToken()));
				check();
				if(result>=3) {
					System.out.println(cnt);
					System.exit(0);
				}
			}
		}
	}

	private static void check() {
		int cnt1 =0, cnt2=0;
		for (int i = 0; i < 5; i++) {
			int bingo = 0;
			for (int j = 0; j < 5; j++) { // 가로 확인
				if (visited[i][j])
					bingo++;
			}
			if (bingo == 5)
				result++;

			bingo = 0;
			for (int j = 0; j < 5; j++) { // 세로 확인
				if (visited[j][i])
					bingo++;
			}
			if (bingo == 5)
				result++;

			if (visited[i][i]) { // 대각선 확인
				cnt1++;
			}

			if (visited[i][4-i]) {
				cnt2++;
			}
		}
		if(cnt1==5) result++;
		if(cnt2==5) result++;
	}
	
	private static void visit(int n) { // 
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(map[i][j] == n) {
					visited[i][j] = true;
				}
			}
		}
	}
}

