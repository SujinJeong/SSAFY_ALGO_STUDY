package donggil.Week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//Logic

//1. 왼쪽, 오른쪽 둘 중에 가장 끝에 있는 목표가 제일 짧은 쪽을 먼저 방향으로 잡는다
//2. 해당 방향에 있는 총 목표 개수를 최대 들 수 있는 책의 갯수로 나누어 나머지를 구해준다.
//  2-1. 그 이유는 맨 끝에 있는 목표점에 대해서 불필요하게 두번 왔다갔다 하지 않게 딱 떨어지게 갖다놓기 위함이다.
//  2-2. 앞 쪽에 있는 조무래기 목표들에 대해서 먼저 왔다갔다 해주고 먼 거리로 갈 수록 깔끔하게 M만큼 왔다 갔다.
//       그리고 맨 마지막 목표(제일 거리 오래걸리는거)에 대해서도 동일하게 적용하기 위함이다.
//3. 반대쪽도 마찬가지로 동일하게 해준다.
//4. 수행하는 도중에 갖다놓을 개수가 0이 되는 순간은 돌아올 필요가 없는 순간이므로 다시 0 으로 올 필요 없음

public class boj_1461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> minusQ = new PriorityQueue<>();
        PriorityQueue<Integer> plusQ = new PriorityQueue<>();
        PriorityQueue<Integer> Q;
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int[] arr = new int[N];
        long answer = 0;

        stk = new StringTokenizer(br.readLine());
        int num, maxDir = -1;
        for(int i = 0; i < N; i++) {
            num = Integer.parseInt(stk.nextToken());
            arr[i] = num;
            if(num < 0) {
                minusQ.add(-num);
            } else {
                plusQ.add(num);
            }
        }
        Arrays.sort(arr);
        if(Math.abs(arr[0]) > Math.abs(arr[N -1])) maxDir = 1;

        for(int i = 0; i < 2; i++) {
            int dist = 0, idx = 0, rem = 0;
            if(maxDir < 0) {
                Q = minusQ;
            } else {
                Q = plusQ;
            }
            maxDir *= -1;

            rem = Q.size() % M;

            while(rem --> 0) {
                dist = Q.poll();
                N--;
            }
            if(N == 0) answer += dist;
            else answer += dist * 2;

            while(!Q.isEmpty()) {
                dist = Q.poll();
                N--;
                idx++;
                if(idx == M) {
                    if(N == 0) {
                        answer += dist;
                    } else {
                        answer += dist * 2;
                    }
                    idx = 0;
                }
            }

            if(N == 0) break;
        }
        System.out.println(answer);
        br.close();
    }
}
