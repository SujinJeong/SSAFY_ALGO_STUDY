package donggil.Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14888 {
    static int N;
    static int[] An;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] op = new int[4];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());//입력받을 숫자들의 개수 입력
        An = new int[N];
        StringTokenizer stk = new StringTokenizer(br.readLine());//An입력 받아와서

        for(int i = 0; i < N; i++) {//배열에 A1부터 An까지 저장
            An[i] = Integer.parseInt(stk.nextToken());
        }
        stk = new StringTokenizer(br.readLine());//주어진 연산자 개수 토크나이저
        op[0] = Integer.parseInt(stk.nextToken());
        op[1] = Integer.parseInt(stk.nextToken());
        op[2] = Integer.parseInt(stk.nextToken());
        op[3] = Integer.parseInt(stk.nextToken());

        calculate(1, An[0], op[0], op[1], op[2], op[3]);

        System.out.println(max);
        System.out.println(min);
    }
    private static void calculate(int depth, int sum, int op1, int op2, int op3, int op4) {
        //더하기 부터 순차적으로 연산자 하나씩 뺴서 계산해봄
        if(op1 > 0) {
            calculate(depth + 1, sum + An[depth], op1 - 1, op2, op3, op4);
        }
        if(op2 > 0) {
            calculate(depth + 1, sum - An[depth], op1, op2 - 1, op3, op4);
        }
        if(op3 > 0) {
            calculate(depth + 1, sum * An[depth], op1, op2, op3 - 1, op4);
        }
        if(op4 > 0) {
            calculate(depth + 1, sum / An[depth], op1, op2, op3, op4 - 1);
        }

        if(depth == N) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
        }
    }
}
