package donggil.Week5;

import java.io.*;

public class boj_9663 {
    static int N;
    static int[] pos_arr;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        pos_arr = new int[15];
        for(int i = 1; i <= N; i++) {
            pos_arr[1] = i;
            N_Queen(1);
        }
        if(N == 2 || N == 3) ans = 0;
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
        return;
    }
    private static void N_Queen(int row) {
        if(row == N) ans++;
        else {
            for(int i = 1; i <= N; i++) {
                pos_arr[row + 1] = i;
                if(isPossible(row + 1)) N_Queen(row + 1);
            }
        }
    }
    private static boolean isPossible(int idx) {
        for(int i = 1; i < idx; i++) {
            if(pos_arr[i] == pos_arr[idx]) return false;
            if(Math.abs(i - idx) == Math.abs(pos_arr[i] - pos_arr[idx])) return false;
        }
        return true;
    }
}