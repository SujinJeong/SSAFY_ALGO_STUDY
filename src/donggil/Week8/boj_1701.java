package donggil.Week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Logic
//KMP를 사용하되 최대 길이가 5000안 문자열이 들어오므로 앞에서 하나씩 잘라가며 접두 접미 길이를 하나씩 체크해 가장 긴 경우를 정답으로 출력
//풀이 시간 : 25분
public class boj_1701 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int length = str.length();
        int max = 0;

        for(int i = 0; i < length; i++) {
            max = Math.max(max, makeTable(str.substring(i, length)));
        }
        System.out.println(max);
    }
    private static int makeTable(String pattern) {
        int length = pattern.length(), j = 0, max = 0;
        int[] table = new int[length];

        for(int i = 1; i < length; i++) {
            while(j > 0 && pattern.charAt(j) != pattern.charAt(i)) {
                j = table[j - 1];
            }

            if(pattern.charAt(j) == pattern.charAt(i)) {
                j += 1;
                table[i] = j;
                max = Math.max(max, table[i]);
            }
        }

        return max;
    }
}
