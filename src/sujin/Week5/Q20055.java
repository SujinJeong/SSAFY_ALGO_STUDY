package sujin.Week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q20055 {
	static int[] belt;
	static boolean[] robot;
	static int n, k, rslt = 0;

	// 끝나는 조건인지 확인
	public static boolean isEnd() {
		int cnt = 0;

		for (int i = 0; i < belt.length; i++) {
			if (belt[i] == 0)
				cnt++;
			// k 이상으로 넘어가면 끝내야하므로
			if (cnt >= k)
				return true;
		}

		return false;
	}

	public static void solve() {

			// 1. 벨트 한 칸 회전! 이 때, 이미 있는 로봇이 있다면 벨트와 같이 회전시켜야함
			int last = belt[belt.length - 1];
			for (int i = belt.length - 1; i > 0; i--) {
				belt[i] = belt[i - 1];
			}
			belt[0] = last;
			
			for (int i = robot.length - 1; i > 0; i--) {
				robot[i] = robot[i - 1];
			}
			// 인덱스 0 은 true 그대로 있으므로 false 직접 설정
			robot[0] = false;
			// 내려가는 위치에 로봇이 있는 경우 로봇은 반드시 땅으로 내려가야 한다 1. 벨트에 의해 강제로 마지막으로 옮겨지는 경우
			robot[n-1] = false;
			
			// 2. 로봇이 이동 가능하면 이동 how? 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다
			for (int i = n-1; i > 0; i--) {
				if (robot[i-1] && !robot[i] && belt[i] >= 1) {
					robot[i] = true;
					robot[i-1] = false;
					belt[i]--;
				}
			}
			
			// 내려가는 위치에 로봇이 있는 경우 로봇은 반드시 땅으로 내려가야 한다 2. 자의적으로 마지막으로 옮겨지는 경우
			robot[n-1] = false;
			
			// 3. 올라가는 위치에 로봇 올리기 내구도가 0인 칸에는 로봇이 올라갈 수 없음
			if (belt[0] > 0 && !robot[0]) {
				robot[0] = true;
				belt[0]--;
			}
			
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");

		n = Integer.parseInt(line[0]);
		k = Integer.parseInt(line[1]);

		belt = new int[n * 2];
		robot = new boolean[n];

		String[] line2 = br.readLine().split(" ");

		for (int i = 0; i < belt.length; i++) {
			belt[i] = Integer.parseInt(line2[i]);
		}
		
		// 4. 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료
		while (!isEnd()) {
			solve();
			// 단계마다 카운트
			rslt++;
		}
		
		System.out.println(rslt);

	}
}
