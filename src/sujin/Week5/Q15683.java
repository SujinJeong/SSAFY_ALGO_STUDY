package sujin.Week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q15683 {
	/*
	 * 1. 1, 2, 3, 4 -> 4가지 2. 01, 23 -> 2가지 3. 02, 03, 12, 13 -> 4가지 4. 012, 013,
	 * 023, 123 -> 4가지 5. 0123 -> 1가지
	 */
	
	static int n, m, rslt = 987654321;
	static int[][] map, new_map;
	// 동, 남, 서, 북
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static ArrayList<Info> cctv;

	public static class Info {
		int x, y, type, dir;

		public Info(int x, int y, int type, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.type = type;
			this.dir = dir;
		};

	}

	public static void copyArr() {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				new_map[i][j] = map[i][j];
			}
		}
	}

	// 사각지대 몇개인지 찾기
	public static int count() {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (new_map[i][j] == 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	// 총 cctv 갯수 중에서 타입별로 뽑아서 새로운 arr에 넣어주기
	public static void comb(int idx) {
		if (idx == cctv.size()) {
			copyArr();
			for (int i = 0; i < cctv.size(); i++)
				// 모든 cctv에 대해서 감시할 수 있는 범위 검사
				cctv(cctv.get(i).x, cctv.get(i).y, cctv.get(i).type, cctv.get(i).dir);

			// min값 계속 갱신
			rslt = Math.min(count(), rslt);
			return;
		}

		// 방향 조합으로 정해주기
		for (int i = 0; i < 4; i++) {
			cctv.get(idx).dir = i;
			comb(idx + 1);
		}
	}

	public static boolean check(int nx, int ny) {
		// 유효성 체크
		if (nx < 0 || nx >= n || ny < 0 || ny >= m)
			return false;
		// 벽인지 체크
		if (new_map[nx][ny] == 6)
			return false;
		return true;
	}

	// 돌아다니면서 사각지대 찾기
	public static void cctv(int x, int y, int type, int dir) {
		// 전달받은 dir 기준으로 탐색

		// 1방향탐색
		if (type == 1) {
			// 초기값 설정
			int nx = x;
			int ny = y;
			while (true) {
				nx = nx + dx[dir];
				ny = ny + dy[dir];
				if(!check(nx, ny)) break;
				if (new_map[nx][ny] == 0)
					new_map[nx][ny] = -1;
			}
		}
		// 양쪽 방향 탐색
		else if (type == 2) {
			for (int i = 0; i < 3; i += 2) {
				// 초기값 설정
				int nx = x;
				int ny = y;
				while (true) {
					nx = nx + dx[(dir + i) % 4];
					ny = ny + dy[(dir + i) % 4];
					if(!check(nx, ny)) break;
					if (new_map[nx][ny] == 0)
						new_map[nx][ny] = -1;
				}
			}
		}
		// 2방향 탐색
		else if (type == 3) {
			for (int i = 0; i < 2; i++) {
				// 초기값 설정
				int nx = x;
				int ny = y;
				while (true) {
					nx = nx + dx[(dir + i) % 4];
					ny = ny + dy[(dir + i) % 4];
					if(!check(nx, ny)) break;
					if (new_map[nx][ny] == 0)
						new_map[nx][ny] = -1;
				}
			}
		}
		// 3방향 탐색
		else if (type == 4) {
			for (int i = 0; i < 3; i++) {
				// 초기값 설정
				int nx = x;
				int ny = y;
				while (true) {
					nx = nx + dx[(dir + i) % 4];
					ny = ny + dy[(dir + i) % 4];
					if(!check(nx, ny)) break;
					if (new_map[nx][ny] == 0)
						new_map[nx][ny] = -1;
				}
			}
		}
		// 4방향 탐색
		else if (type == 5) {
			for (int i = 0; i < 4; i++) {
				// 초기값 설정
				int nx = x;
				int ny = y;
				while (true) {
					nx = nx + dx[(dir + i) % 4];
					ny = ny + dy[(dir + i) % 4];
					if(!check(nx, ny)) break;
					if (new_map[nx][ny] == 0)
						new_map[nx][ny] = -1;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line = br.readLine().split(" ");

		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		map = new int[n][m];
		new_map = new int[n][m];
		cctv = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String[] line2 = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(line2[j]);
				// cctv 정보 담아주기
				if (map[i][j] != 0 && map[i][j] != 6)
					cctv.add(new Info(i, j, map[i][j], 0));
			}
		}

		comb(0);
		System.out.println(rslt);

	}
}
