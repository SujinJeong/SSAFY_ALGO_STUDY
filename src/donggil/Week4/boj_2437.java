package donggil.Week4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
//Logic

//약간의 수학계산이 들어가는 문제이다
//이때까지의 추들의 합보다 다음 추의 합이 더 큰 경우에는 공백이 존재하기에 부분합 + 1이 정답이 된다.

//위의 전제가 해결되기 위해서는 추 무게들이 정렬된 상태여야한다.

public class boj_2437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        int answer = 0;
        Arrays.sort(arr);
        for(int num : arr) {
            if(num <= answer + 1) {
                answer += num;
            } else break;
        }
        sb.append(answer + 1);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
