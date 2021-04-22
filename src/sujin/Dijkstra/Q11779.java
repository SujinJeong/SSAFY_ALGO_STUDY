package sujin.Dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q11779 {
	static int from,to, cnt = 0;
	static int N, M;
	static int[] parent, distance;
	static ArrayList<Edge>[] graph;
	
	static class Edge implements Comparable<Edge>{
	    int vertex;
	    int weight;
	    public Edge(int vertex, int weight) {
	        this.vertex = vertex;
	        this.weight = weight;
	    }
	    @Override
	    public int compareTo(Edge o) {
	        return this.weight - o.weight;
	    }
	}
	public static void dijkstra() {
		
	        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
	        
	        pq.offer(new Edge(from, 0));
	        distance[from] = 0;
	        
	        while(!pq.isEmpty()) {
	            Edge edge = pq.poll();

	            if(distance[edge.vertex] < edge.weight) continue;
	            
	            for (int i = 0; i < graph[edge.vertex].size(); i++) {
	                Edge tmp = graph[edge.vertex].get(i);
	                
	                // 최소값 갱신
	                if(distance[tmp.vertex] > edge.weight + tmp.weight) {
	                    distance[tmp.vertex] = edge.weight + tmp.weight;
	                    pq.add(new Edge(tmp.vertex, distance[tmp.vertex]));
	                    // 경로 정보 출력 위해 시작점 저장
	                    parent[tmp.vertex] = edge.vertex;
	                }
	            }
	        }
	}
	
//	public static StringBuilder print() {
//		StringBuilder sb = new StringBuilder();
//		
//		int idx = to;
//        while (idx != from) {
//        	sb.append(idx+ " ");
//        	idx = parent[idx];
//        	cnt++;
//        }
//        sb.append(from+" ");
//        cnt++;
//        
//        return sb;
//	}
	
	public static Stack<Integer> printStack() {
		Stack<Integer> st = new Stack<>();
		
		int idx = to;
		while (idx != from) {
			if (idx == 0) break;
			st.push(idx);
			// 내려온 간선루트 따라가기
			idx = parent[idx];
			cnt++;
		}
		// 시작점 붙여주기
		st.push(from);
		cnt++;
		
		return st;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();
        
		N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        // 최소 거리가 계속 갱신되는 배열
        distance = new int[N + 1];
        // INF 값으로 초기값 채우기
        Arrays.fill(distance, Integer.MAX_VALUE);
        // 그래프 정보
        graph = new ArrayList[N + 1];
        // 경로 역추적을 위한 배열
        parent = new int[N + 1];
        
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int V1 = Integer.parseInt(stk.nextToken());
            int V2 = Integer.parseInt(stk.nextToken());
            int weight = Integer.parseInt(stk.nextToken());
            graph[V1].add(new Edge(V2, weight));
        }
        
        stk = new StringTokenizer(br.readLine());
        from = Integer.parseInt(stk.nextToken());
        to = Integer.parseInt(stk.nextToken());
        parent[from] = from;
        // 최단 거리 찾기
        dijkstra();

//        StringBuilder sb = new StringBuilder(print().reverse());
        Stack<Integer> st = printStack();
        while (!st.empty()) {
        	sb.append(st.pop() + " ");
        }
        bw.write(distance[to]+"\n");
        bw.write(Integer.valueOf(cnt)+"\n");
        bw.write(sb.toString());
        bw.flush();
    }

}
