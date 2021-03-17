package donggil.Week2;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1260 {
    static StringBuilder sb = new StringBuilder();
    static int[][] arr1;
    static int[][] arr2;
    static boolean[] visited1;
    static boolean[] visited2;
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int start = Integer.parseInt(stk.nextToken());

        arr1 = new int[N + 1][N + 1];
        arr2 = new int[N + 1][N + 1];
        visited1 = new boolean[N + 1];
        visited1[start] = true;
        visited2 = new boolean[N + 1];
        visited2[start] = true;

        for(int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int V1 = Integer.parseInt(stk.nextToken());
            int V2 = Integer.parseInt(stk.nextToken());
            arr1[V1][V2] = 1;
            arr1[V2][V1] = 1;
        }

        for(int i = 0; i <= N; i++) {
            System.arraycopy(arr1[i], 0, arr2[i], 0, arr1[i].length);
        }

        DFS(start, 1);
        sb.delete(sb.length() - 1, sb.length());
        sb.append("\n");
        BFS(start);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
    private static void DFS(int start_idx, int depth) {
        sb.append(start_idx).append(" ");
        if(depth == arr1.length) return;

        for(int i = 1; i < arr1[start_idx].length; i++) {
            if(arr1[start_idx][i] == 1 && !visited1[i]) {
                visited1[i] = true;
                arr1[start_idx][i] = 0;
                arr1[i][start_idx] = 0;
                DFS(i, depth + 1);
            }
        }
    }
    private static void BFS(int start_idx) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(start_idx);

        while(!Q.isEmpty()) {
            int start = Q.poll();
            sb.append(start);
            for(int i = 1; i < arr2[start_idx].length; i++) {
                if(arr2[start][i] == 1 && !visited2[i]) {
                    visited2[i] = true;
                    arr2[start][i] = 0;
                    arr2[i][start] = 0;
                    Q.offer(i);
                }
            }

            if(Q.size() != 0) sb.append(" ");
        }
        sb.append("\n");
    }
}
