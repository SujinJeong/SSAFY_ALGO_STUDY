package donggil.Week1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        List<Integer> Q = new ArrayList<>();

        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        for(int i = 1; i <= N; i++) {
            Q.add(i);
        }

        int idx = K - 1;
        sb.append("<");
        while(Q.size() > 1) {
            if(idx >= Q.size()) idx %= Q.size();

            sb.append(Q.get(idx)).append(", ");
            Q.remove(idx);
            idx += ( K - 1 );
        }
        sb.append(Q.get(0)).append(">");
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
