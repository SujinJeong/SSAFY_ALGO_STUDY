package donggil.Week7;

import java.io.*;

//Logic
//KMP를 이용하여 문자열을 비교하여주면 되는 문제이다
//풀이 시간 : 10분
public class boj_16916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        char[] parent = br.readLine().toCharArray();
        char[] pattern = br.readLine().toCharArray();
        int[] table = new int[pattern.length];
        makeTable(pattern, table);
        KMP(parent, pattern, table, sb);

        bw.write(sb.toString());
        bw.flush();
    }
    private static void KMP(char[] parent, char[] pattern, int[] table, StringBuilder sb) {
        int parentSize = parent.length, patternSize = pattern.length;
        int j = 0;

        for(int i = 0; i < parentSize; i++) {
            while(j > 0 && pattern[j] != parent[i]) {
                j = table[j - 1];
            }
            if(pattern[j] == parent[i]) {
                if(j == patternSize - 1) {
                    sb.append(1);
                    return;
                } else {
                    j++;
                }
            }
        }
        sb.append(0);
        return;
    }
    private static void makeTable(char[] pattern, int[] table) {
        int patternSize = pattern.length, j = 0;

        for (int i = 1; i < patternSize; i++) {
            while (j > 0 && pattern[j] != pattern[i]) {
                j = table[j - 1];
            }
            if(pattern[j] == pattern[i]) {
                table[i] = ++j;
            }
        }
    }
}
