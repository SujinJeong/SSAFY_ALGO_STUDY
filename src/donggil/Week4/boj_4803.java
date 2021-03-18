package donggil.Week4;

import java.io.*;
import java.util.StringTokenizer;

//Logic
//1. 입력으로 들어온 두 노드 연결 정보를 가지고 각 노드의 루트 노드를 찾아낸다 => findParent
//2. findParent는 들어온 노드번호를 가지고 해당 노드의 루트노드를 찾아간다.
//  2-1. 이 과정은 루트노드를 찾을때까지 진행되는데 idx를 계속해서 현재 노드번호릐 부모노드번호로 바꿔주고 계속해서 루트로 진행해 나간다
//  2-2. idx, 즉 현재 탐색하고 있는 노드번호와 해당 노드 안에 있는 값이 동일할 경우에는 루트에 도달한 경우이므로 해당 idx를 리턴해준다
//3. UnionFind 함수는 각 노드 번호를 두개 받고 내부적으로 각 노드에 대해서 findparent를 수행한다.
//  3-1. findParent 함수를 통해서 나온 두 노드의 루트 노드가 동일할 경우에는 사이클이 존재한다는 것이므로 이 경우에는 해당 노드의 check를 0으로 세팅
//  3-2. 결과적으로 1부터 n까지 루프를 돌면서 각 노드번호의 루트노드를 찾고 해당 노드의 check배열을 통해 트리 유효성을 검증해 treeCnt를 증가시켜주어 결과값 도출

public class boj_4803 {
    private static int[] treeMap = new int[501];
    private static int[] length = new int[501];
    private static int[] check = new int[501];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk;

        int tc = 1;
        int n, m;
        while(true) {
            stk = new StringTokenizer(br.readLine());
            n = Integer.parseInt(stk.nextToken());
            m = Integer.parseInt(stk.nextToken());
            if(n == 0 && m == 0) break;

            for(int i = 1; i <= n; i++) {
                treeMap[i] = i;
                length[i] = 1;
                check[i] = 1;
            }

            for(int i = 1; i <= m; i++) {
                stk = new StringTokenizer(br.readLine());
                int node1 = Integer.parseInt(stk.nextToken());
                int node2 = Integer.parseInt(stk.nextToken());
                if(node1 != node2) unionFind(node1, node2);
                else check[node1] = 0;
            }

            int treeCnt = 0;

            for(int i = 1; i <= n; i++) {
                int root = findParent(i);
                if(check[root] > 0) {
                    check[root] = 0;
                    treeCnt++;
                }
            }

            sb.append("Case " + tc + ": ");

            if(treeCnt == 0) {
                sb.append("No trees.");
            } else if(treeCnt == 1) {
                sb.append("There is one tree.");
            } else {
                sb.append("A forest of " + treeCnt + " trees.");
            }
            sb.append("\n");
            tc++;
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    private static int findParent(int idx) {
        while(idx != treeMap[idx]) {
            //부모노드 번호를 현재 노드에 넣어줌
            treeMap[idx] = treeMap[treeMap[idx]];
            idx = treeMap[idx];
        }
        return idx;
    }
    private static void unionFind(int node1, int node2) {
        int root1 = findParent(node1);
        int root2 = findParent(node2);

        if(root1 == root2) {
            check[root1] = 0;
        } else {
            if(length[root1] < length[root2]) {
                treeMap[root1] = root2;
                length[root2] += length[root1];
            } else {
                treeMap[root2] = root1;
                length[root1] += length[root2];
            }
        }
    }
}
