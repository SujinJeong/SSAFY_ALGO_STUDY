package study_0222;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15683 {
	static int N, M, numOfCam, ans = 987654321;
	static char[][] map = new char[8][8];
	static char[][] arr = new char[8][8];
	static int[] dir = new int[8];
	static int[] type = new int[8];
	static ArrayList<Cam> cam = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if (map[i][j] != '0' && map[i][j] != '6') {
					type[numOfCam++] = map[i][j] - '0';
					cam.add(new Cam(i,j,map[i][j]));
				}
			}
		}
		sel(0);
		System.out.println(ans);
	}
	
	private static void sel(int cnt) {
		if (cnt == numOfCam) {
			sol();
			return;
		}

		if (type[cnt] == 1) {
			for (int i = 0; i < 4; i++) {
				dir[cnt] = i;
				sel(cnt + 1);
			}
		}
		else if (type[cnt] == 2) {
			for (int i = 0; i < 2; i++) {
				dir[cnt] = i;
				sel(cnt + 1);
			}
		}
		else if (type[cnt] == 3) {
			for (int i = 0; i < 4; i++) {
				dir[cnt] = i;
				sel(cnt + 1);
			}
		}
		else if (type[cnt] == 4) {
			for (int i = 0; i < 4; i++) {
				dir[cnt] = i;
				sel(cnt + 1);
			}
		}
		else if (type[cnt] == 5) {
			sel(cnt + 1);
		}
	}

	private static void sol() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = map[i][j];
			}
		}
		
		for (int i = 0; i < (int)cam.size(); i++) {
			int ny = cam.get(i).y;
			int nx = cam.get(i).x;

			if (cam.get(i).type == '1') {
				switch (dir[i]) {
				case 0:
					up(ny, nx); break;
				case 1:
					right(ny, nx); break;
				case 2:
					down(ny, nx); break;
				case 3:
					left(ny, nx); break;
				}
			}

			else if (cam.get(i).type == '2') {
				switch (dir[i]) {
				case 0:
					up(ny, nx); down(ny, nx); break;
				case 1:
					left(ny, nx); right(ny, nx); break;
				}
			}

			else if (cam.get(i).type == '3') {
				switch (dir[i]) {
				case 0:
					up(ny, nx); right(ny, nx); break;
				case 1:
					right(ny, nx); down(ny, nx); break;
				case 2:
					down(ny, nx); left(ny, nx); break;
				case 3:
					left(ny, nx); up(ny, nx); break;
				}
			}

			else if (cam.get(i).type == '4') {
				switch (dir[i]) {
				case 0:
					up(ny, nx); right(ny, nx); down(ny, nx); break;
				case 1:
					right(ny, nx); down(ny, nx); left(ny, nx); break;
				case 2:
					down(ny, nx); left(ny, nx); up(ny, nx); break;
				case 3:
					left(ny, nx); up(ny, nx); right(ny, nx); break;
				}
			}
			else if (cam.get(i).type == '5') {
				up(ny, nx);
				right(ny, nx);
				down(ny, nx);
				left(ny, nx);
			}
		}
		int temp = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == '0') {
					temp++;
				}
			}
		}
		ans = Math.min(ans, temp);
	}

	private static void up(int ny, int nx) {
		while (true) {
			ny -= 1;
			if (ny < 0 || arr[ny][nx] == '6') break;
			if (arr[ny][nx] == '0') arr[ny][nx] = '#';
		}
	}

	private static void down(int ny, int nx) {
		while (true) {
			ny += 1;
			if (ny >= N || arr[ny][nx] == '6') break;
			if (arr[ny][nx] == '0') arr[ny][nx] = '#';
		}
	}
	
	private static void left(int ny, int nx) {
		while (true) {
			nx -= 1;
			if (nx < 0 || arr[ny][nx] == '6') break;
			if (arr[ny][nx] == '0') arr[ny][nx] = '#';
		}
	}

	private static void right(int ny, int nx) {
		while (true) {
			nx += 1;
			if (nx >= M || arr[ny][nx] == '6') break;
			if (arr[ny][nx] == '0') arr[ny][nx] = '#';
		}
	}
	
	static class Cam{
		int y;
		int x;
		char type;
		public Cam(int y, int x, char type) {
			super();
			this.y = y;
			this.x = x;
			this.type = type;
		}
	}
}
