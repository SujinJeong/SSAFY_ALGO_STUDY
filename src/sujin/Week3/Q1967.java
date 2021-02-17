package sujin.Week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
2번의 dfs
1. 루트기준으로 dfs 수행 -> 루트에서 가장 거리가 먼, 가장 큰 weight 가진 노드 구하기
2. 가장 큰 weight 가진 노드를 구한 것 기준으로 다시 dfs를 돌리면 가장 긴 트리의 지름을 구할 수 있음
 */
public class Q1967 {

	static ArrayList<Node> list[];
	static int n;
	static int max_value = Integer.MIN_VALUE;
	static boolean visited[];
	static int max_idx = Integer.MIN_VALUE;

	static class Node {
		int idx, weight;

		Node(int idx, int weight) {
			this.idx = idx;
			this.weight = weight;
		}
	}

	public static void dfs(int idx, int weight) {

		if (max_value < weight) {
			max_value = weight;
			max_idx = idx;
		}

		for (Node a : list[idx]) {
			if (!visited[a.idx]) {
				visited[a.idx] = true;
				// 최대 지름을 구하기 위해 가중치를 계속 ++
				dfs(a.idx, weight + a.weight);
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		list = new ArrayList[n + 1];

		// <i, <idx,weight>> 형식! ex) i가 1~12
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		// 간선의 수는 노드의 수-1
		for (int i = 1; i < n; i++) {
			String[] t = br.readLine().split(" ");
			int parent = Integer.parseInt(t[0]);
			int child = Integer.parseInt(t[1]);
			int weight = Integer.parseInt(t[2]);
			// 부모에게 자식달기
			list[parent].add(new Node(child, weight));
			// 자식에게 부모달기
			list[child].add(new Node(parent, weight));
		}

		// 루트에서 제일 멀리 떨어진 노드 찾기
		visited = new boolean[n + 1];
		visited[1] = true;
		dfs(1, 0);

		// 지름을 구하기 위한 노드 찾기
		visited = new boolean[n + 1];
		visited[max_idx] = true;
		dfs(max_idx, 0);
		
		System.out.println(max_value);

	}

}
