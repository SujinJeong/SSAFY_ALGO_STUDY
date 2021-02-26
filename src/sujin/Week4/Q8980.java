package sujin.Week4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Delivery implements Comparable<Delivery> {
	int start; // 보내는 마을
	int end; // 받는 마을
	int boxNum; // 박스의 개수

	Delivery(int start, int end, int boxNum) {
		this.start = start;
		this.end = end;
		this.boxNum = boxNum;
	}

	
	@Override
	public int compareTo(Delivery arg0) {
		if (end == arg0.end) {
			return start - arg0.start;
		}
		return end - arg0.end;
	}
}

public class Q8980 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 마을의 수
		int C = Integer.parseInt(st.nextToken()); // 트럭의 용량

		int M = Integer.parseInt(br.readLine()); // 보낼 박스 정보의 개수

		// 택배 정보 저장
		Delivery[] post = new Delivery[M + 1];
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int boxNum = Integer.parseInt(st.nextToken());

			post[i] = new Delivery(start, end, boxNum);
		}
		
		// 시작점을 기준으로 하면 먼거리를 이동하는데(1->4) 용량까지 max일 경우 문제
		// 도착점 기준으로 오름차순 정렬, 같다면 시작점 기준 정렬
		Arrays.sort(post, 1, M + 1);

		// 각마을의 최대용량 저장되어있는 배열 - 후에 택배의 개수만큼 순차적으로 뻄
		int[] weight = new int[N + 1];
		for (int i = 1; i < N; i++) {
			weight[i] = C;
		}

		int ans = 0;
		for (int i = 1; i <= M; i++) {
			Delivery d = post[i];
			int maxBox = Integer.MAX_VALUE;
			// 보내는 마을과 받는 마을 사이의 중 택배차에 실을 수 있는 최대 (maxBox)구하기
			// how? maxBox와 해당 마을 택배 개수 비교
			// end를 포함하지 않는 이유는 end에는 택배를 태우지 않기 때문에
			for (int j = d.start; j < d.end; j++) {
				maxBox = Math.min(maxBox, weight[j]);
			}

			// 택배 태우고 가야하므로 보내는 마을과 받는 마을 사이의 경로 마을 모두 용량에서 현재 보내려는 택배의 개수를 뺴기
			
			if (maxBox >= d.boxNum) { // 근데 이떄, 경우의 수 1: 위에서 구한 보낼 수 있는 최대 한도 > 현재 보내려는 택배의 개수
				for (int j = d.start; j < d.end; j++) {
					weight[j] -= d.boxNum;
				}
				ans += d.boxNum;
			} else { // 경우의 수 2: 보낼 수 있는 최대 한도 < 현재 보내려는 택배의 개수
				// 현재 보내려는 택배의 개수가 아닌 위에서 구한 최대 한도를 기준으로 한다.
				for (int j = d.start; j < d.end; j++) {
					weight[j] -= maxBox;
				}
				ans += maxBox;
			}
		}

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
