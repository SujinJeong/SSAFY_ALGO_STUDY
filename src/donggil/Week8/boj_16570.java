package donggil.Week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Logic
//접두와 접미가 같은 길이를 저장하는 KMP의 특성을 이용하여 문제에서 앞을 연속되게 자른다른 것을
//보고 뒤집으면 되겠다는 생각을 하였다
//풀이 시간 : 3시간

public class boj_16570 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] pattern = new int[N], table;
        String[] input = br.readLine().split(" ");

        for(int i = N - 1; i >= 0; i--) {
            pattern[N - 1 - i] = Integer.parseInt(input[i]);
        }

        table = makeTable(pattern);
        int max = -1, cnt = 0;

        for(int i = 0; i < N; i++) {
            if(max < table[i]) {
                max = table[i];
                cnt = 1;
            } else if(max == table[i]) {
                cnt++;
            }
        }
        if(max == 0) {
            System.out.println(-1);
        } else {
            System.out.println(max + " " + cnt);
        }
    }
    private static int[] makeTable(int[] pattern) {
        int length = pattern.length, j = 0;
        int[] table = new int[length];

        for(int i = 1; i < length; i++) {
            while(j > 0 && pattern[j] != pattern[i]) {
                j = table[j - 1];
            }
            if(pattern[j] == pattern[i]) {
                table[i] = ++j;
            }
        }

        return table;
    }
}
