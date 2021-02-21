package study_0215;

import java.io.*;
import java.util.*;

public class BOJ_2234 {
	static int n, m, roomNum;
	static int[][] arr, room;
	static int[] dy = { 0, -1, 0, 1 };
	static int[] dx = { -1, 0, 1, 0 };
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		room = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (room[i][j] == 0) {
					roomNum++;
					room[i][j] = roomNum;
					list.add(dfs(i, j));
				}
			}
		}

		int maxRoomSize = 0;
		for (int i = 0; i < list.size(); i++) {
			if (maxRoomSize < list.get(i)) {
				maxRoomSize = list.get(i);
			}
		}

		sb.append(roomNum + "\n" + maxRoomSize + "\n" + del());
		System.out.println(sb);
	}

	private static int dfs(int y, int x) {
		int cnt = 1;
		room[y][x] = roomNum;
		for (int i = 0; i < 4; i++) {
			if((arr[y][x] &(1<<i)) != 0) {continue;}
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
				continue;
			}
			if (room[ny][nx] == 0) {
				room[ny][nx] = roomNum;
				cnt += dfs(ny, nx);
			}
		}
		return cnt;
	}

	private static int del() {
		int ret = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int k = 0; k < 4; k++) {
					int ny = i + dy[k];
					int nx = j + dx[k];
					if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
						continue;
					}
					if(room[ny][nx] != room[i][j]) {
						ret = Math.max(ret, list.get(room[ny][nx] - 1) + list.get(room[i][j] - 1));
					}
				}
			}
		}
		return ret;
	}
}