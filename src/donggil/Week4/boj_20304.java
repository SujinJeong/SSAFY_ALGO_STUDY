package donggil.Week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_20304 {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<int[]> Q = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        int cpy = N;
        int M = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[N + 1];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int answer = 0;
        int length = 0;
        while(cpy > 0) {
            length++;
            cpy/=2;
        }
        while(M --> 0) {
            Q.offer(new int[]{Integer.parseInt(stk.nextToken()), 0});
        }

        while(!Q.isEmpty()) {
            int[] tmp = Q.poll();
            answer = tmp[1];
            for(int i = 0; i < length; i++) {
                int num = tmp[0] ^ (1 << i);

                if(num <= N && !visited[num]) {
                    visited[num] = true;
                    Q.offer(new int[]{num, tmp[1] + 1});
                }
            }
        }
        System.out.println(answer);
    }
}
