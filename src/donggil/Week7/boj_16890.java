package donggil.Week7;

import java.io.*;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class boj_16890 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Character> guDeQ = new LinkedList<>();
        Deque<Character> cubeDeQ = new LinkedList<>();

        char[] guArr = br.readLine().toCharArray(), cubeArr = br.readLine().toCharArray();
        int length = guArr.length;
        char[] answer = new char[length];
        int front = 0, end = length - 1;

        Arrays.sort(guArr);
        Arrays.sort(cubeArr);

        //홀수 길이일 경우 구사과는 하나 더 넣어야 하므로 전체 길이의 + 1의 절반을 디큐에 넣어줌
        for (int i = 0; i < (length + 1) / 2; i++) {
            guDeQ.addLast(guArr[i]);
        }


        int size = guDeQ.size();
        //큐브러버는 구사과와 같거나 더 작게 넣을 수 밖에 없으므로 정답 문자열 길이에서 구사과 큐 길이 빼준만큼 큐에 넣어줌
        for (int idx = cubeArr.length - 1, cnt = 0; cnt < length - size; cnt++, idx--) {

            cubeDeQ.addLast(cubeArr[idx]);
        }

        //앞과 뒤를 가르키는 포인터가 만나기까지 수행
        while (end >= front) {
            if (cubeDeQ.isEmpty() || guDeQ.peekFirst() >= cubeDeQ.peekFirst()) {
                //구사과는 자기가 가진 가장 작은 것이 큐브러버보다 크거나 같아지게 될 경우에는
                answer[end--] = guDeQ.pollLast(); //자기가 넣을 수 있는 것 중에 가장 큰 문자를 맨 뒤에 넣어줘야함
            } else {
                //그 외의 경우에는 자기가 가지고 있는 가장 작은거 넣어주면됨
                answer[front++] = guDeQ.pollFirst();
            }

            if (end < front) break;//두 포인터가 지나치게되면 종료

            if (guDeQ.isEmpty() || cubeDeQ.peekFirst() <= guDeQ.peekFirst()) {
                //큐브러버는 자기가 가진 가장 큰 것이 구사과보다 작거나 같이지게 될 경우
                answer[end--] = cubeDeQ.pollLast(); //자기가 넣을 수 있는 것들 중에 가장 작은 문자를 맨 뒤에 넣어줘야함
            } else {
                //그 외의 경우에는 자기가 가지고 있는 가장 큰거 넣어주면됨
                answer[front++] = cubeDeQ.pollFirst();
            }
        }
        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}
