package donggil.Week3;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
//문제 설명
//트리는 사이클이 없는 무방향 그래프, 그렇기에 어떤 두 노드를 선택해도 둘 사이에 경로가 항상 하나만 존재
//트리에서 어떤 두 노드를 선택해서 양쪽으로 당겼을 시 가장 길게 늘어나는 경우가 있는데 그 두 노드 사이의 거리가 트리의 지름

//Logic
//어떤 곳에서든 가장 갈 수 있는 깊은 곳까지 가보면 트리의 지름 경계선에 도달하게됨 -> 또 여기서 출발해서 갈 수 있는 가장 깊은 곳까지가면 또 다른 트리 지름의 경계선에 도달
//두 점 사이의 거리는 즉 트리의 지름이 되게 된다.

//이전에 1167 문제와 동일해서 빨리 풀었다
//풀이 시간 : 10분
public class boj_1967 {
    private static int answer = 0, endNode;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk;

        int N = Integer.parseInt(br.readLine());
        ArrayList<int[]>[] Tree = new ArrayList[N + 1];
        boolean[] visited = new boolean[N + 1];

        for(int i = 0; i < N-1; i++) {
            stk = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(stk.nextToken());
            int child = Integer.parseInt(stk.nextToken());
            int length = Integer.parseInt(stk.nextToken());

            if(Tree[parent] == null) Tree[parent] = new ArrayList<>();
            if(Tree[child] == null) Tree[child] = new ArrayList<>();

            Tree[parent].add(new int[]{child, length});
            Tree[child].add(new int[]{parent, length});
        }

        DFS(1, 0, Tree, visited);
        visited = new boolean[N + 1];
        DFS(endNode, 0, Tree, visited);
        sb.append(answer);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
    private static void DFS(int node, int length, ArrayList<int[]>[] Tree, boolean[] visited) {
        visited[node] = true;
        if(length > answer) {
            answer = length;
            endNode = node;
        }
        if(Tree[node] == null) return;
        for(int[] sub : Tree[node]) {
            if(!visited[sub[0]]) {
                DFS(sub[0], length + sub[1], Tree, visited);
            }
        }
    }
}
