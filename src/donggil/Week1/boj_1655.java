package donggil.Week1;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class boj_1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> orderedQ = new PriorityQueue<>();
        PriorityQueue<Integer> reverseQ = new PriorityQueue<>(Collections.reverseOrder());

        //Logic
        //우선 순위큐를 두개를 생성해서 한쪽에는 중간값부터 내림차순으로 가는 우선순위 큐를
        //반대편에는 중간부분부터 해서 꼭대기까지 올라가는 큐를
        //이 문제의 핵심은 reverseQ의 peek에서 중간값을 꺼내와야 하는것
        //중간값은 두개의 사이즈가 같을때 작은 값을 리턴해줘야하기에 orderedQ와 비교해서 reverseQ가 더 크면 reverseQ와 peek값 switch
        int N = Integer.parseInt(br.readLine());
        while(N --> 0) {
            int num = Integer.parseInt(br.readLine());
            if(orderedQ.size() == reverseQ.size()) reverseQ.add(num);
            else orderedQ.add(num);

            if((!orderedQ.isEmpty() && !reverseQ.isEmpty()) && (orderedQ.peek() < reverseQ.peek())) {
                int tmp = orderedQ.poll();
                orderedQ.add(reverseQ.poll());
                reverseQ.add(tmp);
            }
            sb.append(reverseQ.peek()).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
