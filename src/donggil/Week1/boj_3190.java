package donggil.Week1;

import java.io.*;
import java.util.StringTokenizer;

public class boj_3190 {
    static int N, K, L;
    static int HeadX = 1, HeadY = 1;
    static int TailX = 1, TailY = 1;
    static int[] dir_x = {-1, 0, 1, 0, -1};
    static int[] dir_y = {-1, 1, 0, -1, 0};
    static int Map[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int Time = 1;
        int dirHead = 1;//머리의 진행방향
        int dirTail = 1;//꼬리의 진행방향

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        Map = new int[N + 1][N + 1];
        Map[1][1] = -1;//뱀이 일부가 존재하는 공간은 -1
        for(int i = 0; i < K; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            Map[x][y] = 10;//사과는 10
        }
        L = Integer.parseInt(br.readLine());
        boolean stop = false;
        for(int i = 0; i < L; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            stop = false;
            int X = Integer.parseInt(stk.nextToken());
            char C = stk.nextToken().charAt(0);
            while(Time <= X) {
                HeadX += dir_x[dirHead];
                HeadY += dir_y[dirHead];
                if(HeadX < 1 || HeadY < 1 || HeadX > N || HeadY > N) {
                    stop = true;
                    break;
                }
                if(Map[HeadX][HeadY] == -1) {
                    stop = true;
                    break;
                }

                if(Map[HeadX][HeadY] == 10) {
                    Map[HeadX][HeadY] = -1;
                }else {
                    Map[HeadX][HeadY] = -1;
                    Map[TailX][TailY] = 0;
                    TailX += dir_x[dirTail];
                    TailY += dir_y[dirTail];
                    if(Map[TailX][TailY] >= 1 && Map[TailX][TailY] <= 4) {
                        dirTail = Map[TailX][TailY];
                        Map[TailX][TailY] = -1;
                    }
                }
                Time++;
            }
            if(stop) break;
            else {
                if(C == 'D') {
                    dirHead += 1;
                    if(dirHead > 4) dirHead = 1;
                    if(HeadX == TailX && HeadY == TailY) dirTail = dirHead;
                    Map[HeadX][HeadY] = dirHead;
                    HeadX += dir_x[dirHead];
                    HeadY += dir_y[dirHead];
                    if(HeadX < 1 || HeadY < 1 || HeadX > N || HeadY > N ) {
                        stop = true;
                        break;
                    }
                    if(Map[HeadX][HeadY] == -1) {
                        stop = true;
                        break;
                    }
                    if(Map[HeadX][HeadY] == 10) {
                        Map[HeadX][HeadY] = -1;
                    }else {
                        Map[HeadX][HeadY] = -1;
                        Map[TailX][TailY] = 0;
                        TailX += dir_x[dirTail];
                        TailY += dir_y[dirTail];
                        if(Map[TailX][TailY] >= 1 && Map[TailX][TailY] <= 4) {
                            dirTail = Map[TailX][TailY];
                            Map[TailX][TailY] = -1;
                        }
                    }
                } else {
                    dirHead -= 1;
                    if(dirHead < 1) dirHead = 4;
                    if(HeadX == TailX && HeadY == TailY) dirTail = dirHead;
                    Map[HeadX][HeadY] = dirHead;
                    HeadX += dir_x[dirHead];
                    HeadY += dir_y[dirHead];
                    if(HeadX < 1 || HeadY < 1 || HeadX > N || HeadY > N) {
                        stop = true;
                        break;
                    }
                    if(Map[HeadX][HeadY] == -1) {
                        stop = true;
                        break;
                    }
                    if(Map[HeadX][HeadY] == 10) {
                        Map[HeadX][HeadY] = -1;
                    }else {
                        Map[HeadX][HeadY] = -1;
                        Map[TailX][TailY] = 0;
                        TailX += dir_x[dirTail];
                        TailY += dir_y[dirTail];
                        if(Map[TailX][TailY] >= 1 && Map[TailX][TailY] <= 4) {
                            dirTail = Map[TailX][TailY];
                            Map[TailX][TailY] = -1;
                        }
                    }
                }
                Time++;
            }
        }
        if(!stop) {
            while(true) {
                HeadX += dir_x[dirHead];
                HeadY += dir_y[dirHead];
                if(HeadX < 1 || HeadY < 1 || HeadX > N || HeadY > N) {
                    break;
                }
                if(Map[HeadX][HeadY] == -1) {
                    break;
                }

                if(Map[HeadX][HeadY] == 10) {
                    Map[HeadX][HeadY] = -1;
                }else {
                    Map[HeadX][HeadY] = -1;
                    Map[TailX][TailY] = 0;
                    TailX += dir_x[dirTail];
                    TailY += dir_y[dirTail];
                    if(Map[TailX][TailY] >= 1 && Map[TailX][TailY] <= 4) {
                        dirTail = Map[TailX][TailY];
                        Map[TailX][TailY] = -1;
                    }
                }
                Time++;
            }
        }

        sb.append(Time).append("\n");
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
        return;
    }
}
