package sujin.Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1. 0,0부터 dfs -> 이동한 곳이 치즈라면 +1 (1: 외부공기와 닿지 않음, 2:1면만 닿음, 3: 2면 닿음, 4: 3면 ~)
2. 공기(즉 0이면) -1로 값 바꿔주기 -> 모두 바뀐 좌표에서 -1로 안바뀐 0은 내부공기
3. 1시간 후 : 1 or 2이면 1로 바꿔주기, 3이상이면 0으로 바꿔주기 , -1은 0으로 돌려주기 , cnt 증가
4. map이 모두 0이 될때까지 위의 과정 반복 후 cnt 출력
 */
public class Q2671 {
	static int n, m, cnt;
	static int[][] map;
	static int dy[] = { 1, -1, 0, 0 }, dx[] = { 0, 0, -1, 1 };

	static void dfs(int x, int y) {
		// 외부공기니까 -1로 바꿔주기
		map[x][y] = -1;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < n && nx >= 0 && ny < m && ny >= 0) {
				// 옮기려는 곳이 또 외부공기
				if (map[nx][ny] == 0)
					dfs(nx, ny);
				// 옮기려는 곳이 치즈인 경우 외부공기에 노출된 경우의 수 계산
				else if (map[nx][ny] > 0)
					map[nx][ny]++;
			}
		}
	}

	static boolean checkCheese() {
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1)
					return false;
			}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line[] = br.readLine().split(" ");
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			line = br.readLine().split(" ");
			for (int j = 0; j < m; j++)
				map[i][j] = Integer.parseInt(line[j]);
		}

		while (!checkCheese()) {
			cnt++;
			dfs(0, 0);
			for (int i = 0; i < n; i++)
				for (int j = 0; j < m; j++) {
					// 치즈가 살아있는 경우
					if (map[i][j] == 1 || map[i][j] == 2) {
						// 다음 계산을 위해 치즈 살려두기
						map[i][j] = 1;
					} else { // 3이상이여서 외부 공기에 녹았거나, 원래 외부공기였던 경우 0 으로 돌려주기
						map[i][j] = 0;
					}
				}
		}

		System.out.println(cnt);
	}

}
