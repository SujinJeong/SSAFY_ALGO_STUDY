package donggil.Week1;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

//Logic

//그냥 우선순위 큐 조건만 잘 넣어주면 되는 문제

public class boj_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> Q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) == Math.abs(o2)) {
                    return o1 - o2;
                } else {
                    return Math.abs(o1) - Math.abs(o2);
                }
            }
        });

        int N = Integer.parseInt(br.readLine());

        while(N --> 0) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) {
                if(Q.isEmpty()) sb.append(0);
                else sb.append(Q.poll());

                sb.append("\n");
            } else {
                Q.add(num);
            }
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
