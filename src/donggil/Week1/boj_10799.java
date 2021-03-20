package donggil.Week1;

import java.io.*;
//Logic
//여는 괄호인데 다음에 또 여는 괄호 나오는거면 쇠파이프의 갯수 증가
//만약 다음에 나오는게 닫는 괄호이면 이때까지 생성된 쇠파이프 제거
//연달아 닫는 괄호가 나오면은 파이프 하나가 감소되는 것

//이전에 풀었던 문제이기에 빠르게 풀 수 있었음

public class boj_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        char[] input = br.readLine().toCharArray();
        int answer = 0, stick = 0, length = input.length;

        for (int i = 0; i < length; i++) {
            if (input[i] == '(') {
                if (input[i + 1] == ')') {
                    answer += stick;
                    i++;
                } else {
                    stick++;
                    answer++;
                }
            } else {
                stick--;
            }
        }
        sb.append(answer).append("\n");

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
