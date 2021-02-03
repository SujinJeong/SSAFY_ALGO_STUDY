package jiye.week1;

import java.util.*;

class Main11866 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] answer = new int[n];

        Queue<Integer> q = new LinkedList<Integer>();//원형이라고 생각한다

        for (int i = 0; i < n; i++)
            q.offer(i + 1);

        //1234567 -> 12_4567 -> 12_45_7 -> 1__45_7 이걸 돌린다 빙글빙글
        //K-1번 돌리고    맨앞에꺼가 K번째 수
        //두번 돌려서 3456712 3빼고 456712
        //두번 돌려서 671245  6빼고 71245
        //두번 돌려서 24571   2빼고 4571
        //두번 돌려서 7145    7빼고 145
        //두번 돌려서 514     5빼고 14
        //K보다 q크기가 작아지면 돌리는게 의미x... 엥 똑같네 뭘고민한거지
        //두번 돌려서 41->14  1빼고 4
        //마지막꺼는 for문 안들어감 4

        int j = 0;
        while (q.size() > 0) {
            int index = k;
            while (index > q.size()) {
                index = index - q.size();
                // System.out.println(index+ " "+ q.size());
            }

            for (int i = 0; i < index - 1; i++) {
                int a = q.poll();
                q.offer(a);// 빼고 넣고
            }

            answer[j] = q.poll();// k번째꺼는 빼고
            j++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 0; i < n - 1; i++)
            sb.append(answer[i] + ", ");
        sb.append(answer[n - 1] + ">");
        System.out.println(sb);
        sc.close();
    }
}