package study_0125;

import java.io.*;
import java.util.*;

public class BOJ_3190 {
	static int dy[] = new int[] { 0, -1, 0, 1 };
	static int dx[] = new int[] { 1, 0, -1, 0 };
	static int N, K, L;
	static int map[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			String[] list = br.readLine().split(" ");
			map[Integer.parseInt(list[0])][Integer.parseInt(list[1])] = 1;
		}

		L = Integer.parseInt(br.readLine());
		Dir[] dir = new Dir[L];
		for (int i = 0; i < L; i++) {
			String[] list = br.readLine().split(" ");
			char pos = list[1].charAt(0);
			dir[i] = new Dir(Integer.parseInt(list[0]), pos);
		}

		Deque<SnakePos> snake = new LinkedList<>();
		SnakePos head = new SnakePos(1, 1);
		snake.addLast(head);

		int ans = 0, idx = 0;
		while (true) {
			ans++;
			int y = head.y + dy[idx];
			int x = head.x + dx[idx];
			if (y > N || y <= 0 || x > N || x <= 0 || map[y][x] == -1) {
				break;
			}
			head = new SnakePos(y, x);
			snake.addLast(head);

			if (map[snake.peekLast().y][snake.peekLast().x] != 1) {
				map[snake.peek().y][snake.peek().x] = 0;
				snake.poll();
			}
			map[snake.peekLast().y][snake.peekLast().x] = -1;

			for (int i = 0; i < dir.length; i++) {
				if (ans != dir[i].getTime()) {
					continue;
				}
				if (dir[i].getPos() == 'L') {
					idx += 1;
					if (idx > 3) {
						idx -= 4;
					}
				} else {
					idx -= 1;
					if (idx < 0) {
						idx += 4;
					}
				}
			}
		}
		System.out.println(ans);
	}
}

class SnakePos {
	public int y, x;

	public SnakePos(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}
}

class Dir {
	private int time;
	private char pos;

	public Dir(int time, char pos) {
		super();
		this.time = time;
		this.pos = pos;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public char getPos() {
		return pos;
	}

	public void setPos(char pos) {
		this.pos = pos;
	}

}