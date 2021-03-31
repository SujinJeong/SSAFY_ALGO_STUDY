package donggil.Week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Logic
//KMP사용되는 패턴에 대한 테이블 즉 특정 인덱스에서 prefix, postfix가 동일한 길이를 저장한 배열을 이용해
//문자열을 얼마나 최대로 겹쳐서 최종적인 문자열을 만들 수 있나의 문제
public class boj_16900 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        char[] S = input[0].toCharArray();
        int[] table = new int[S.length];
        long K = Long.parseLong(input[1]);

        table = makeTable(S, table);
        int length = table.length, max = table[length - 1];
        long answer = length;

        answer += ((length - max) * (K - 1));

        System.out.println(answer);
    }
    private static int[] makeTable(char[] S, int[] table) {
        int length = S.length, j = 0;

        for(int i = 1; i < length; i++) {
            while(j > 0 && S[i] != S[j]) {
                j = table[j - 1];
            }

            if(S[i] == S[j]) {
                table[i] = ++j;
            }
        }

        return table;
    }
}
