package sujin.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
while(flag) // 1번
	현재 위치를 청소
	while (true) //2번
		if(사방을 다 돌았는데도 갈 곳이 없다면)
			if(뒷칸이 벽) d
			else (뒷칸 이동가능) c
		
		왼쪽으로 방향 바꾸기
		
		if (왼쪽이 청소가능하면) a
		else (청소할 공간이 없으면) b
		
1. 로봇이 가리키는 방향값: 0,1,2,3 -> 각각 북,동,남,서
2. 이를 기준으로 왼쪽: 3,0,1,2 -> 서,북,동,남
 */
public class Q14503 {
	static int n, m;
	static int x, y, d;
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static int clean(int x, int y, int d) {
		int clean_cnt = 0;
		int dir_cnt = 0;
		int nx, ny;
		boolean canClean = true;

		while (canClean) { // 1번
			if (map[x][y] == 0) { // 청소가능
				map[x][y] = -1;
				clean_cnt++;
			}

			while (true) { // 2번
				// 사방을 다 돌았는데도 청소할 곳 찾지 못함

				if (dir_cnt == 4) {
					// 후진
					nx = x - dx[d];
					ny = y - dy[d];

					if (map[nx][ny] == 1) { // 후진했으나 뒷칸이 벽이면 후진할수없음 d. 작동끝
						canClean = false;
						break;
					} else { // 한칸 후진 c
						x = nx;
						y = ny;
						dir_cnt = 0;
					}
				}

				// a,b 공동수행
				d = (d + 3) % 4; // 북,동,남,서 -> 서,북,동,남
				nx = x + dx[d];
				ny = y + dy[d];

				if (map[nx][ny] == 0) { // 한칸 전진하고 다시 청소부터 수행 a
					x = nx;
					y = ny;
					dir_cnt = 0;
					break;
				} else { // 이미 회전은 했으니
					dir_cnt++;
					continue; // 다시 2번으로 돌아가기
				}
			}
		}
		return clean_cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");

		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);

		map = new int[n][m];

		String[] line2 = br.readLine().split(" ");
		x = Integer.parseInt(line2[0]);
		y = Integer.parseInt(line2[1]);
		d = Integer.parseInt(line2[2]);

		for (int i = 0; i < n; i++) {
			String[] line3 = br.readLine().split(" ");
			for (int j = 0; j < m; j++)
				map[i][j] = Integer.parseInt(line3[j]);
		}
		System.out.println(clean(x, y, d));
	}

}
