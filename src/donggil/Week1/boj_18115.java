package donggil.Week1;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
//Logic

//DeQue를 이용하여 구현한 문제이다
//처음에 너무 복잡해서 갈피를 잘 못잡았지만 그림을 그려봤으면 좀 더 빨리 풀었을 문제
//카드가 놓인 순서에 따라 역으로 추적하여 원래 있던 카드의 순서를 출력해주면 된다
//모든 큐를 DeQue를 쓰기보다 배열을 적적히 섞어 사용하는 것이 효율적이다
//정말 시간을 빠르게 하기 위해서는 DeQue를 직접 배열로 구현하면되지만 시간이 별로 없었기에 그냥 제출

//풀이 시간 : 30분
public class boj_18115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        Deque<Integer> deQ = new LinkedList<>();

        int[] oper = new int[N];
        for(int i = 0; i < N; i++) {
            oper[i] = Integer.parseInt(stk.nextToken());
        }

        int num = 1;

        for(int i = N - 1; i >= 0; i--, num++) {
            int cmd = oper[i];
            int tmp;
            switch (cmd) {
                case 1:
                    deQ.addFirst(num);
                    break;
                case 2:
                    tmp = deQ.pollFirst();
                    deQ.addFirst(num);
                    deQ.addFirst(tmp);
                    break;
                case 3:
                    deQ.addLast(num);
                    break;
            }
        }

        while(!deQ.isEmpty()) {
            sb.append(deQ.poll()).append(" ");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
