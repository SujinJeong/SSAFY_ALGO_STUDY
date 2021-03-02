package hoyeong.week5;

import java.util.Arrays;
import java.util.Scanner;

public class back_9663 {
	static int [][] map;
	static int N, result;
	static int [] visited; // 같은 행 검사 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		visited = new int[N];

		for (int i = 0; i < N; i++) {
			Arrays.fill(visited, -1); // 초기화
			visited[i] = 0;
			Queen(0);
		}
		System.out.println(result);
		sc.close();
	}
	
	private static void Queen(int r) {
		if(r==N-1) { // 마지막 줄에 도달했을 때 
			result++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i]==-1 && dfs(r+1,i)) { // 동일한 행이 없고, 다음 행으로 갈 수 있을 때
				visited[i]=r+1; // visited에 row의 값 넣음 >> 결국 visited만 보고도 모든 Queen의 위치를 알 수 있음
				Queen(r+1);
				visited[i]=-1; // 나왔을때 visited 지워줌
			}
		}
	}
	
	private static boolean dfs(int r, int c) {
		for(int i=0; i<N; i++) {
			if(visited[i]!=-1) { // Queen이 있는 경우
				if(Math.abs(visited[i]-r) == Math.abs(i-c)) return false; // 같은 대각선 위에 있는지 비교(r의 크기와 c의 크기가 같을 때)
			}
		}
		return true;
	}
}
