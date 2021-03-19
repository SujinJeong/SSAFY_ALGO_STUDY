package donggil.Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// Logic
// 스택을 이용해서 현재 이전까지의 자기보다 높은 애가 있는지 없는지 체크
public class boj_6198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long answer = 0;
        Stack<Long> S = new Stack<>();

        for(int i = 0; i < N; i++) {
            long input = Long.parseLong(br.readLine());

            while(!S.isEmpty()) {
                if(S.peek() <= input) S.pop();
                else break;
            }
            answer += S.size();
            S.push(input);
        }

        System.out.println(answer);
    }
}
