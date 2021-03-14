package sujin.Week7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Q11657 {

	public static class Edge {
        int u, v, w;
 
        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int INF = 987654321;
        StringBuilder sb = new StringBuilder();
        
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        Edge[] edge = new Edge[m + 1];
        long[] dist = new long[n+1];
        
        // 시작점에서 각 정점으로 가는 최단 거리 저장 배열 초기화
        Arrays.fill(dist, INF);
        
        for (int i = 1; i <= m; i++) {
        	line = br.readLine().split(" ");
            int u = Integer.parseInt(line[0]);
            int v = Integer.parseInt(line[1]);
            int w = Integer.parseInt(line[2]);
            edge[i] = new Edge(u, v, w);
 
        }
        
        // 벨만포드
        boolean cycle = false;
        dist[1] = 0;        // 1번 정점이 시작점
        
        for (int i = 0; i < n; i++) {       // v - 1 번 수행
            for (int j = 1; j <= m; j++) {  // 모든 간선
                Edge curr = edge[j];
                if (dist[curr.u] != INF && dist[curr.v] > dist[curr.u] + curr.w) {
                    dist[curr.v] = dist[curr.u] + curr.w;
                    if (i == n-1)
                    	cycle = true;
                }
            }
        }
 
        if (cycle) sb.append(-1);
        else {
	        for (int i = 2; i <= n; i++) {
	            if (dist[i] != INF) {
	                sb.append(dist[i] + "\n");
	            } else {
	                sb.append("-1\n");
	            }
	        }
        }
        bw.write(String.valueOf(sb));
        bw.flush();
    }
}
