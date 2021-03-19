package donggil.Week3;

import java.io.*;
import java.util.StringTokenizer;

public class boj_14503 {
    static int ans = 1;
    static int N, M;
    static boolean[][] Cleaned;
    static int RobotX, RobotY, RobotWay;
    static int[][] Area;
    static int[] DirX = {-1, 0, 1, 0};
    static int[] DirY = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        Area = new int[N][M];
        Cleaned = new boolean[N][M];

        stk = new StringTokenizer(br.readLine());
        RobotX = Integer.parseInt(stk.nextToken());
        RobotY = Integer.parseInt(stk.nextToken());
        RobotWay = Integer.parseInt(stk.nextToken());

        for(int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                Area[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        Cleaned[RobotX][RobotY] = true;
        StartClean();

        sb.append(ans).append("\n");
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
        return;
    }
    private static void StartClean() {
        int ImPossible = 0;
        while(true) {
            if(ImPossible == 4) {
                int x = RobotX - DirX[RobotWay];
                int y = RobotY - DirY[RobotWay];

                if(Area[x][y] == 1) return;
                else {
                    ImPossible = 0;
                    if(Cleaned[x][y]) {
                        RobotX = x;
                        RobotY = y;
                    } else {
                        ans++;
                        Cleaned[RobotX][RobotY] = true;
                    }
                    continue;
                }
            }

            RobotWay--;

            if(RobotWay < 0) RobotWay = 3;
            int nx = RobotX + DirX[RobotWay];
            int ny = RobotY + DirY[RobotWay];


            if(Area[nx][ny] == 1 || Cleaned[nx][ny]) {
                ImPossible++;
                continue;
            } else {
                ImPossible = 0;
                RobotX = nx;
                RobotY = ny;
                Cleaned[RobotX][RobotY] = true;
                ans++;
            }
        }
    }
}
//로봇 작동방법
//방향 idx에 -1 (즉 왼쪽을 바라봄)
    //벽일 경우
        //다시 왼쪽으로 돔
    //벽이 아닐 경우
        //청소 된곳
        //청소 안된 곳


