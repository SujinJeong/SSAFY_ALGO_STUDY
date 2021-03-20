package donggil.Week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_2374 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> S = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        long answer = 0;

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < N; i++) {
            //스택이 비어있으면 그냥 값 하나 넣어줌
            if(S.isEmpty()) S.push(arr[i]);
            //비어 있지 않은 경우에
            else {
                //스택 맨 위에 있는 값이 배열의 현재값보다 작으면 A[i]연산이 필요
                if(S.peek() < arr[i]) {
                    //스택이 비지 않을때까지 수행
                    while(!S.isEmpty()) {
                        int num = S.pop();
                        //팝하자마자 스택이 비었거나 스택의 가장 윗값이 현재 i보다 작으면 그 사이에 껴있던 숫자를
                        //arr[i]로 증가연산 해줌, 그럼 스택에 하나만 있을때는 어쩐거냐? => 아래 조건문을 통해 해당 값이
                        //arr[i]보다 작음을 알 수 있기에 arr[i]에서 num을 빼주기만 하면됨
                        if(S.isEmpty() || S.peek() > arr[i]) {
                            answer += (arr[i] - num);
                            break;
                            //S.peek()보다 arr[i]가 더 큰 경우에는 S.peek()가 더 작은거니까 거기서 num뺴줌
                        } else {
                            answer += (S.peek() - num);
                        }
                    }
                    S.push(arr[i]);
                } else S.push(arr[i]);
            }
        }

        if(!S.isEmpty()) {
            int low = S.peek();
            while(S.size() != 1) {
                S.pop();
            }
            int high = S.peek();
            answer += (high - low);
        }
        System.out.println(answer);
    }
}