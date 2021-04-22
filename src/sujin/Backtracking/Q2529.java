package sujin.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2529 {
    static int tc;
    static char[] c;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

    private static void solve(int num, int cnt, String s) {
        visited[num] = true;

        if (cnt == tc) { // 부등호 다 채웠을때
            int tmp = Integer.parseInt(s);
            min = Math.min(min, tmp);
            max = Math.max(max, tmp);
            return;
        }
        for (int i = 1; i < 10; i++) {
            if (!visited[i]) {
                if (c[cnt] == '<') {
                    if (num < i)
                        solve(i, cnt + 1, s + i);
                } else if (c[cnt] == '>') {
                    if (num > i)
                        solve(i, cnt + 1, s + i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        tc = Integer.parseInt(br.readLine());
        c = new char[tc];
        visited = new boolean[10];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < tc; i++) {
            c[i] = st.nextToken().charAt(0);
        }

        // 첫번째숫자
        for (int i = 0; i < 10; i++) {
            visited[i] = true;
            solve(i, 0, i+"");
        }

        System.out.println(min);
        System.out.println(max);

    }


}
