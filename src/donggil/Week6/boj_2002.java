package donggil.Week6;

import java.io.*;
import java.util.HashMap;

public class boj_2002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> hash1 = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        int[] outputOrder = new int[1001];
        for(int i = 0; i < N; i++) {
            hash1.put(br.readLine(), i);
        }

        for(int i = 0; i < N; i++) {
            outputOrder[i] = hash1.get(br.readLine());
        }

        for(int i = 0; i < N - 1; i++) {
            for(int j = i + 1; j < N; j++) {
                if(outputOrder[i] > outputOrder[j]) {
                    answer++;
                    break;
                }
            }
        }
        sb.append(answer).append("\n");
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
