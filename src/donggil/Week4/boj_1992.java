package donggil.Week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1992 {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][N];
        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < N; j++) {
                arr[i][j] = input.charAt(j);
            }
        }
        recur(arr, sb, N, 0, 0);
        System.out.println(sb);
    }
    private static void recur(char[][] arr, StringBuilder sb, int width, int row, int col) {
        char value = arr[row][col];
        boolean flag = true;
        loop:for(int i = row; i < row + width; i++) {
            for(int j = col; j < col + width; j++) {
                if(arr[i][j] != value) {
                    flag = false;
                    break loop;
                }
            }
        }
        if(!flag) {
            sb.append("(");
            int div = width / 2;
            recur(arr, sb, div, row, col);
            recur(arr, sb, div, row, col + div);
            recur(arr, sb, div, row + div, col);
            recur(arr, sb, div, row + div, col + div);
            sb.append(")");
        } else {
            sb.append(value);
        }
    }
}
