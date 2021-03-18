package donggil.Week6;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//Logic
//용액을 3개 선택하면 되는데 맨 앞과 맨 뒤는 고정시키면서 하나씩 이동시키는 투포인터로 하고
//가운데를 이분 탐색 시키면 되는 알고리즘이다.
public class boj_2473 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int[] arr = new int[N], answer = new int[3];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(arr);
        long max = Long.MAX_VALUE;

        for(int left = 0; left < N - 1; left++) {
            int right = N - 1;
            int start = left + 1;
            int end = right - 1;

            while(right > end) {
                end = right - 1;

                while(start <= end) {
                    int mid = (start + end) / 2;

                    long total = (long)arr[left] + (long)arr[mid] + (long)arr[right];

                    if(max > Math.abs(total)) {
                        answer[0] = arr[left];
                        answer[1] = arr[mid];
                        answer[2] = arr[right];
                        max = Math.abs(total);
                    }
                    if(total < 0) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
                right--;
            }
        }

        Arrays.sort(answer);
        sb.append(answer[0]).append(" ").append(answer[1]).append(" ").append(answer[2]);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
