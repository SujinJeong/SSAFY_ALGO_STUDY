package donggil.Week1;

import java.io.*;
import java.util.StringTokenizer;

public class boj_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] towerHeight = new int[N + 1];
        int[] ansArr = new int[N + 1];
        //나보다 큰 애면은 걔 idx를 넣어주면되고
        //나보다 작은애면은 현재 탐색하는 타워 위치를 스택처럼 선형보다는 빠르게 탐색하게끔

        StringTokenizer stk = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++) {
            towerHeight[i] = Integer.parseInt(stk.nextToken());
        }

        for(int i = 1; i <= N; i++) {
            int idx =  i - 1;
            int height = towerHeight[i];

            while(idx >= 1) {
                if(towerHeight[idx] >= height) {
                    ansArr[i] = idx;
                    break;
                } else {
                    //얘보다 작은애가 찾은 높은 타워에 대해서 탐색하게끔 idx조정
                    idx = ansArr[idx];
                }
            }
        }

        for(int i = 1; i <= N; i++) {
            sb.append(ansArr[i] + " ");
        }

        bw.write(String.valueOf(sb));
        bw.close();
        br.close();
    }
}
