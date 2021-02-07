package sujin.Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1. 0,0���� dfs -> �̵��� ���� ġ���� +1 (1: �ܺΰ���� ���� ����, 2:1�鸸 ����, 3: 2�� ����, 4: 3�� ~)
2. ����(�� 0�̸�) -1�� �� �ٲ��ֱ� -> ��� �ٲ� ��ǥ���� -1�� �ȹٲ� 0�� ���ΰ���
3. 1�ð� �� : 1 or 2�̸� 1�� �ٲ��ֱ�, 3�̻��̸� 0���� �ٲ��ֱ� , -1�� 0���� �����ֱ� , cnt ����
4. map�� ��� 0�� �ɶ����� ���� ���� �ݺ� �� cnt ���
 */
public class Q2671 {
	static int n, m, cnt;
	static int[][] map;
	static int dy[] = { 1, -1, 0, 0 }, dx[] = { 0, 0, -1, 1 };

	static void dfs(int x, int y) {
		// �ܺΰ���ϱ� -1�� �ٲ��ֱ�
		map[x][y] = -1;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < n && nx >= 0 && ny < m && ny >= 0) {
				// �ű���� ���� �� �ܺΰ���
				if (map[nx][ny] == 0)
					dfs(nx, ny);
				// �ű���� ���� ġ���� ��� �ܺΰ��⿡ ����� ����� �� ���
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
					// ġ� ����ִ� ���
					if (map[i][j] == 1 || map[i][j] == 2) {
						// ���� ����� ���� ġ�� ����α�
						map[i][j] = 1;
					} else { // 3�̻��̿��� �ܺ� ���⿡ ��Ұų�, ���� �ܺΰ��⿴�� ��� 0 ���� �����ֱ�
						map[i][j] = 0;
					}
				}
		}

		System.out.println(cnt);
	}

}
