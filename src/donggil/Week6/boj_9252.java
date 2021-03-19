package donggil.Week6;

import java.io.*;
//Logic
//LCS 알고리즘

public class boj_9252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String input1 = "0" + br.readLine();
        String input2 = "0" + br.readLine();
        int length1 = input1.length();
        int length2 = input2.length();

        int[][] DP = new int[length2][length1];

        for(int i = 1; i < length2; i++) {
            for(int j = 1; j < length1; j++) {
                if(input2.charAt(i) == input1.charAt(j)) {
                    DP[i][j] = DP[i - 1][j - 1] + 1;
                } else {
                    DP[i][j] = Math.max(DP[i][j - 1], DP[i - 1][j]);
                }
            }
        }

        int num1 = DP[length2 - 1][length1 - 1];
        int num2 = num1 - 1;
        int start_idx = length1 - 1;

        for(int i = length2 - 1; i > 0; i--) {
            for(int j = start_idx; j > 0; j--) {
                if(DP[i][j] == num1 && DP[i - 1][j - 1] == num2 && DP[i][j - 1] == num2 && DP[i - 1][j] == num2) {
                    start_idx = j;
                    num1--;
                    num2--;
                    sb.insert(0, input2.charAt(i));
                    break;
                }
            }
        }
        sb.insert(0, "\n").insert(0, DP[length2 - 1][length1 - 1]);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
