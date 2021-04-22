package sujin.DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1. 전위 순회의 첫번째 값은 root이다. -> pre_order[r]은 루트값
2. 해당 범위에서 루트값과 같은 중위 순회를 찾는다.
3. left 재귀, right 재귀 반복.
4. 후위순회 : left -> right -> root출력 순으로 해주면된다
5. ex) 전위 순회하면 3,6,5,4,8,7,1,2, 중위 순회하면 5,6,8,4,3,1,2,7
 */

public class Q4256 {
	static int n;
	static int[] pre, in;
	static int idx = 0;
	static StringBuilder sb = new StringBuilder();;

	public static void post(int start, int end, int root) {
		
		
		for (int i = start; i < end; i++) {
			// 전위순회의 첫번째 값은 root!
			if (in[i] == pre[root]) {
				// 왼쪽자식 -> 3 다음 6이 왼쪽 자식의 루트노드이므로 root+1
				post(start, i, root+1);
				// 오른쪽자식 -> +i를 해주는 이유는 자식수만큼 더해줘야 다음 루트노드가 나옴
				post(i+1, end, root+1+i-start);
				sb.append(pre[root]+ " ");
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			n = Integer.parseInt(br.readLine());
			
			pre = new int[n];
			in = new int[n];
			
			// 전위순회
			String[] line = br.readLine().split(" ");
			for (int i = 0; i < n; i++)
				pre[i] = Integer.parseInt(line[i]);
			
			// 중위순회
			String[] line2 = br.readLine().split(" ");
			for (int i = 0; i < n; i++)
				in[i] = Integer.parseInt(line2[i]);
			
			post(0, n, 0);
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
