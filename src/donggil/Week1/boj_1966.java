package donggil.Week1;

import java.io.*;
import java.util.*;

public class boj_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int TestCase = Integer.parseInt(br.readLine());
        StringTokenizer stk;

        while(TestCase --> 0) {
            stk = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(stk.nextToken()), M = Integer.parseInt(stk.nextToken()), ans = 0;
            PriorityQueue<Integer> Q = new PriorityQueue<>(Collections.reverseOrder());
            Queue<int[]> Printer = new LinkedList<>();
            stk = new StringTokenizer(br.readLine());

            for(int i = 0; i < N; i++) {
                int num = Integer.parseInt(stk.nextToken());
                Q.add(num);
                Printer.add(new int[]{num, i});
            }

            for(int i = 1; i <= Integer.MAX_VALUE; i++) {
                if(Printer.peek()[0] == Q.peek()) {
                    int[] arr = Printer.poll();
                    Q.poll();
                    ans++;
                    if(arr[1] == M) {
                        sb.append(ans).append("\n");
                        break;
                    }
                } else if(Printer.peek()[0] != Q.peek()){
                    Printer.add(Printer.poll());
                }
            }
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
