package donggil.Week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1939 {
    private static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        PriorityQueue<Node> Q = new PriorityQueue<>((o1, o2) -> o2.weight - o1.weight);
        int N = Integer.parseInt(stk.nextToken()), M = Integer.parseInt(stk.nextToken());
        parents = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        for(int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            int weight = Integer.parseInt(stk.nextToken());
            Q.add(new Node(start, end, weight));
        }

        stk = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(stk.nextToken()), E = Integer.parseInt(stk.nextToken());
        int answer = Integer.MAX_VALUE;
        while(!Q.isEmpty()) {
            Node node = Q.poll();
            union(node.start, node.end);
            answer = Math.min(answer, node.weight);
            if(findParent(S) == findParent(E)) {
                System.out.println(answer);
                break;
            }
        }
    }
    private static class Node {
        int start, end, weight;
        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
    private static int findParent(int x) {
        if(parents[x] == x) return x;
        return parents[x] = findParent(parents[x]);
    }
    private static void union(int a, int b) {
        int rootA = findParent(a);
        int rootB = findParent(b);

        if(rootA > rootB) parents[rootB] = rootA;
        else parents[rootA] = rootB;
    }
}

//Logic
//이분탐색으로 정답을 도출해낼 수 있는 문제
//이분탐색의 범위는 다리가 버틸 수 있는 하중의 범위이다 ( 1 ~ 주어지는 값 중 가장 큰 값 )
//1. 1부터 가장 큰 값에서 중간 값으로 지정해놓는다
//2. 1에서 값 지정 이후에 BFS를 돈다, 돌때 지정한 mid값보다 탐색 중에 다리의 가중치가 더 큰 것들만 골라서 연결시켜본다
//3. 그런 애들만 골라서 연결해봤을때 끝점이랑 연결되면 해당 mid보다 큰 값들만 가지고 시작점과 끝점을 연결할 수 있다는 것
    //3-1. true인 경우에는 start값을 mid + 1로 바꿔주어 다리값의 범위를 바꿔준다
    //3-2. false인 경우에는 end값을 mid - 1로 바꾸어 다리값의 범위를 바꿔준다.

//public class boj_1939 {
//    private static class Node {
//        int node, weight;
//        public Node(int node, int weight) {
//            this.node = node;
//            this.weight = weight;
//        }
//    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer stk = new StringTokenizer(br.readLine());
//        int N = Integer.parseInt(stk.nextToken());
//        int M = Integer.parseInt(stk.nextToken());
//        int start = 1, end = Integer.MIN_VALUE;
//        boolean[] visited = new boolean[N + 1];
//        ArrayList<Node>[] graph = new ArrayList[N + 1];
//
//        for(int i = 0; i <= N; i++) {
//            graph[i] = new ArrayList<>();
//        }
//
//        for(int i = 0 ; i < M; i++) {
//            stk = new StringTokenizer(br.readLine());
//            int startNode = Integer.parseInt(stk.nextToken());
//            int endNode = Integer.parseInt(stk.nextToken());
//            int weight = Integer.parseInt(stk.nextToken());
//
//            graph[startNode].add(new Node(endNode, weight));
//            graph[endNode].add(new Node(startNode, weight));
//            if(weight > end) end = weight;
//        }
//
//        stk = new StringTokenizer(br.readLine());
//        int S = Integer.parseInt(stk.nextToken());
//        int E = Integer.parseInt(stk.nextToken());
//        int answer = -1;
//
//        Queue<Integer> Q = new LinkedList<>();
//
//        while(start <= end) {
//            int mid = (start + end) / 2;
//            Arrays.fill(visited, false);
//            Q.clear();
//            Q.add(S);
//            visited[S] = true;
//
//            if(BFS(Q, visited, graph, E, mid)) {
//                answer = Math.max(answer, mid);
//                start = mid + 1;
//            } else {
//                end = mid - 1;
//            }
//        }
//
//        System.out.println(answer);
//    }
//    private static boolean BFS(Queue<Integer> Q, boolean[] visited, ArrayList<Node>[] graph, int endNode, int mid) {
//        while(!Q.isEmpty()) {
//            int startNode = Q.poll();
//            visited[startNode] = true;
//
//            for(Node node : graph[startNode]) {
//                if(mid <= node.weight) {
//                    if(node.node == endNode) {
//                        return true;
//                    }
//
//                    if(!visited[node.node]) {
//                        visited[node.node] = true;
//                        Q.add(node.node);
//                    }
//                }
//            }
//        }
//        return false;
//    }
//}