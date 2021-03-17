package donggil.Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_15686 {
    private static class PosInfo {
        int row, col;
        public PosInfo(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    private static int answer = Integer.MAX_VALUE;
    private static PosInfo[] arr;
    private static ArrayList<PosInfo> houseList = new ArrayList<>();
    private static ArrayList<PosInfo> chickenList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        arr = new PosInfo[M];

        for(int i = 0; i < N; i++) {
            sb.append(br.readLine());
            for(int j = 0, idx = 0; j < N; j++, idx += 2) {
                int num = sb.charAt(idx) - '0';
                if(num == 1) {
                    houseList.add(new PosInfo(i, j));
                } else if(num == 2) {
                    chickenList.add(new PosInfo(i, j));
                }
            }
            sb.setLength(0);
        }
        combChicken(0, 0);
        System.out.println(answer);
        br.close();
    }
    private static void combChicken(int idx, int cnt) {
        if(cnt == arr.length) {
            getDistance();
            return;
        }

        for(int i = idx; i < chickenList.size(); i++) {
            arr[cnt] = chickenList.get(i);
            combChicken(i + 1, cnt + 1);
        }
    }
    private static void getDistance() {
        int sum = 0;

        for(int i = 0; i < houseList.size(); i++) {
            int max = Integer.MAX_VALUE;
            int distance = 0;
            for(int j = 0; j < arr.length; j++) {
                distance = Math.abs(houseList.get(i).row - arr[j].row) + Math.abs(houseList.get(i).col - arr[j].col);

                if(distance < max) max = distance;
            }
            sum += max;
        }
        if(answer > sum) answer = sum;
    }
}
