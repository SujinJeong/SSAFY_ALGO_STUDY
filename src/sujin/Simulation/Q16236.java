package sujin.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
1. 상어가 먹을 수 있는 물고기가 있는지 확인
2. 먹을 수 있는 물고기들의 정보를 저장
3. 거리가 가장 가까운 물고기를 먹으러 갑니다
-1순위: 거리가 제일 가까운것
-2순위: 가장 위에 있는거
-3순위: 그중 가장 왼쪽에 있는거

4. 먹을 수 있는 물고기가 없을때까지 반복
 */
public class Q16236 {
	static Pos shark;
	static ArrayList<Pos> fish;
	static int[][] map;
	
	public static class Pos {
		int x, y, size;

		public Pos(int x, int y, int size) {
			super();
			this.x = x;
			this.y = y;
			this.size = size;
		}
		
	}
	
	public static int getDist(int x1, int x2, int y1, int y2) {
		return Math.abs(x1-x2) + Math.abs(y1-y2);
	}
	public static void solve() {
		int time = 0;
		int min = Integer.MAX_VALUE;
		
		while (fish.size() != 0) {
			time++;
			
			if (fish.size() == 1) {
				shark = fish.get(0);
				fish.remove(0);
			}
			else {
				//  가까운 거리에 있는거 먹기
				Pos nextFish = fish.get(0);
				
				// min dist 구하기
				for (int i = 0; i < fish.size(); i++) {
					if (fish.get(i).size < shark.size)
						min = Math.min(getDist(fish.get(i).x, shark.x, fish.get(i).y, shark.y), min);
				}
				
				// 뭐 먹을지 고르기
				for (int i = 0; i < fish.size(); i++) {
					// 거리가 가까운 물고기가 많다면
					if (fish.get(i).size < shark.size && min == getDist(fish.get(i).x, shark.x, fish.get(i).y, shark.y)) {
						if (fish.get(i).x < nextFish.x) { // 더 위에 있으면
							nextFish = fish.get(i);
						}
						else if (fish.get(i).x == nextFish.x) { // 더 위가 여러마리면 가장 왼쪽
							if (fish.get(i).y < nextFish.y) {
								nextFish = fish.get(i);
							}
						}
					}
				}
				
				// 먹기
				// 사이즈 같으면 먹진 못하고 지나가기
				if (nextFish.size == shark.size) continue;
				else {
					
				}
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		fish = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) shark = new Pos(i, j, 2);
				else if (1 <= map[i][j] && map[i][j] <= 6) fish.add(new Pos(i, j, map[i][j]));
			}
		}
		
		solve();
		
		
	}

}
