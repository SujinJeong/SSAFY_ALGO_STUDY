package donggil.Week2;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_2617 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        ArrayList<Integer>[] descList = new ArrayList[N + 1];
        ArrayList<Integer>[] ascList = new ArrayList[N + 1];


        for(int i = 1; i <= N; i++) {
            descList[i] = new ArrayList<>();
            ascList[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int high = Integer.parseInt(stk.nextToken());
            int low = Integer.parseInt(stk.nextToken());
            descList[high].add(low);
            ascList[low].add(high);
        }
        int mid = N / 2;
        int answer = 0;
        for(int i = 1; i <= N; i++) {
            boolean[] visited = new boolean[N + 1];
            visited[i] = true;
            int downDepth = DFS(i, ascList, visited);

            visited = new boolean[N + 1];
            visited[i] = true;
            int upDepth = DFS(i, descList, visited);

            if(downDepth > mid || upDepth > mid) {
                answer++;
            }
        }
        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
    }
    private static int DFS(int startNode, ArrayList<Integer>[] list, boolean[] visited) {
        int sum = 0;

        for(int num : list[startNode]) {
            if(!visited[num]) {
                visited[num] = true;
                sum += DFS(num, list, visited) + 1;
            }
        }

        return sum;
    }
}
