package donggil.Week6;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_7453 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][4];
        int[] left = new int[N * N];
        int[] right = new int[N * N];

        //배열 입력
        for(int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++) {
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        //두개씩 묶어서 배열 생성
        for(int i = 0, idx = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                left[idx++] = arr[i][0] + arr[j][1];
            }
        }
        for(int i = 0, idx = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                right[idx++] = arr[i][2] + arr[j][3];
            }
        }
        //각 왼쪽 오른쪽 배열을 오름차순으로 정렬해줌
        Arrays.sort(left);
        Arrays.sort(right);
        int left_idx = 0, right_idx = (N*N) - 1;
        long answer = 0;

        //왼쪽은 위부터, 오른쪽은 아래부터 투 포인터 세팅
        while(left_idx < N*N && right_idx >= 0) {
            int sum = left[left_idx] + right[right_idx];
            //두개의 합이 0인 경우
            if(sum == 0) {
                int left_cnt = 0, left_num = left[left_idx];
                int right_cnt = 0, right_num = right[right_idx];

                //왼쪽 오른쪽의 값이 동일한 구간까지 개수를 다 센다
                while(left_idx < N * N && left[left_idx] == left_num) {
                    left_idx++;
                    left_cnt++;
                }

                while(right_idx >= 0 && right[right_idx] == right_num) {
                    right_idx--;
                    right_cnt++;
                }

                //여기서 곱해주는 이유는 경우의 수이기 때문 left_cnt는 즉 left에서 해당 숫자를 만들 수 있는 경우의 수이므로 곱해주어야한다
                //왼쪽을 예를들어 10 + 5 , 2 + 13 , 3 + 12 => 3가지와 오른쪽 -10 + -5 , -2 + -13 , -3 + -12 => 3가지 총 9가지의 0이되는 방법이 생김
                answer += (long)left_cnt * (long)right_cnt;
            } else if(sum > 0) { //합이 0보다 크면 값을 줄여주기 위해 오른쪽 포인터를 올려준다
                right_idx--;
            } else { //합이 0보다 작으면 값을 늘려주기 위해 왼쪽 idx를 내려준다
                left_idx++;
            }
        }

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}
