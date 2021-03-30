package donggil.Week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//Logic
//M개의 휴개소를 놓을떄 휴게소 사이의 거리에 대해 이분탐색하여 최소의 거리를 정하는 문제이다
//초기의 left는 1, right는 가장 큰 너비로 설정을 한다
//그리고 계속 이분탐색한 mid값을 이용하여 휴게소 사이의 거리에 대해 나누어 몇개의 휴게소를 놓을 수 있는지 check
//놓을 수 있는 휴계소의 개수가 M을 넘냐 안넘냐에 따라 범위를 또 다르게 설정

public class boj_1477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken()), M = Integer.parseInt(stk.nextToken()), L = Integer.parseInt(stk.nextToken());
        int[] pos = new int[N + 2];
        pos[0] = 0;
        pos[N + 1] = L;

        stk = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            pos[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(pos);
        int left = 1, right = -1, mid = 0;
        for(int i = 1; i <= N + 1; i++) {
            right = Math.max(right, pos[i] - pos[i - 1]);
        }

        while(left <= right) {
            mid = (left + right) / 2;

            int cnt = 0;

            for(int i = 1; i <= N + 1; i++) {
                int width = pos[i] - pos[i - 1];
                boolean isMod = (width % mid == 0) ? true : false;
                cnt += (width / mid);

                if(isMod) cnt--;
            }

            if(cnt > M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(left);
    }
}
