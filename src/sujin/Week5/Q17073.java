package sujin.Week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
자식한테 계속 나눠주고 종료조건이  더 이상 물이 움직이지 않는 상태가 되었을 때 이므로
자식노드 갯수 세준 다음에 w에서 나누기 해주면 되겠는데..? 동일한 확률이니까 가능
예시 6.666666 * 자식노드 3개하면 20 되는것처럼
 */
public class Q17073 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");

		int n = Integer.parseInt(line[0]);
		int w = Integer.parseInt(line[1]);

		int[] edge = new int[n+1];
		
		// 간선 정보 input
		// leaf 노드가 몇개인지만 찾아주면 된다 간선 정보에 1개만 포함되면 그것이 leaf!
		for (int i = 0; i < n-1; i++) {
			String[] line2 = br.readLine().split(" ");
			edge[Integer.parseInt(line2[0])]++;
			edge[Integer.parseInt(line2[1])]++;
		}
		
		double leaf_cnt = 0;
		// 1번 정점이 무조건 루트 노드 이므로 2부터 검사
		for (int i = 2; i <= n; i++) {
			if (edge[i] == 1) leaf_cnt++;
		}
		System.out.printf("%.10f", w/leaf_cnt);
	}

}
