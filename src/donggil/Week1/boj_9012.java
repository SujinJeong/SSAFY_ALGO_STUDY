package donggil.Week1;

import java.io.*;

public class boj_9012 {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();


        int TestCase = Integer.parseInt(br.readLine());
        while(TestCase-->0) {
            int peek = 0;
            String input = br.readLine();
            for(int i = 0; i < input.length(); i++) {
                if(input.charAt(i) == '(') {
                    peek++;
                } else {
                    peek--;
                }
                if(peek < 0) break;
            }
            if(peek == 0) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }
        bw.write(String.valueOf(sb));
        bw.close();
        br.close();
    }
}
