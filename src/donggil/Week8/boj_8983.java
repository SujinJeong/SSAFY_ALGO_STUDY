package donggil.Week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//Logic
//각 동물들에 대해서 하나씩 뽑아와 가장 가까운 사로를 탐색해 나간다는 방식으로 이분 탐색을 시행한다
//그렇게 찾아도 도저히 쏠 수 없는 동물이면 그냥 false 맞출 수 있으면 true 리턴하여 처리

public class boj_8983 {
    private static boolean binarySearch(int x, int y, int M, int L, int[] shotArr) {
        int left = 0, right = M - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int val = shotArr[mid] - x;
            boolean canShot = (Math.abs(shotArr[mid] - x) + y <= L);

            if (canShot) {
                return true;
            } else if (val < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(stk.nextToken()), N = Integer.parseInt(stk.nextToken()), L = Integer.parseInt(stk.nextToken());
        int[] shotArr = new int[M];

        stk = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            shotArr[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(shotArr);

        int answer = 0;
        while (N-- > 0) {
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            if (binarySearch(x, y, M, L, shotArr))
                ++answer;
        }

        System.out.print(answer);
    }
}
