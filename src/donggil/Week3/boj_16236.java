package donggil.Week3;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_16236 {
    private static class PosInfo {
        int time;
        int nx, ny;

        public PosInfo(int t, int x, int y) {
            this.time = t;
            this.nx = x;
            this.ny = y;
        }
    }
    static int N;
    static int[] pos_x = {-1, 0, 1, 0};
    static int[] pos_y = {0, -1, 0, 1};
    static int[][] FishMap, TimeMap;
    static int SharkWeight = 2, SharkPosX, SharkPosY, SharkEaten = 0;
    static int MinTime, MinX, MinY;
    static int ans = 0;
    static Queue<PosInfo> Q = new LinkedList<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        FishMap = new int[N][N];
        TimeMap = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            Arrays.fill(TimeMap[i], -1);
            for(int j = 0; j < N; j++) {
                FishMap[i][j] = Integer.parseInt(stk.nextToken());
                if(FishMap[i][j] == 9) {
                    SharkPosX = i;
                    SharkPosY = j;
                }
            }
        }
        Play();
        sb.append(ans).append("\n");

        bw.write(String.valueOf(sb));

        bw.flush();
        bw.close();
        br.close();
        return;
    }
    private static void Play() {
        while(true) {
            Q.offer(new PosInfo(0, SharkPosX, SharkPosY));
            Init();
            BFS();
            if(MinTime != Integer.MAX_VALUE) {
                FishMap[SharkPosX][SharkPosY] = 0;
                FishMap[MinX][MinY] = 9;
                SharkPosX = MinX;
                SharkPosY = MinY;
                ans += MinTime;
                SharkEaten++;
                if(SharkWeight == SharkEaten) {
                    SharkEaten = 0;
                    SharkWeight++;
                }
            } else {
                break;
            }
        }
        return;
    }
    private static void BFS() {
        while(!Q.isEmpty()) {
            PosInfo q = Q.poll();
            TimeMap[q.nx][q.ny] = q.time;
            for(int i = 0; i < 4; i++) {
                int nx = q.nx + pos_x[i];
                int ny = q.ny + pos_y[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(TimeMap[nx][ny] != -1) continue;

                if(FishMap[nx][ny] == 0 || FishMap[nx][ny] == SharkWeight) {
                    TimeMap[nx][ny] = q.time + 1;
                    Q.offer(new PosInfo(q.time + 1, nx, ny));
                } else if(FishMap[nx][ny] != 0 && FishMap[nx][ny] < SharkWeight) {
                    if(MinTime > q.time + 1) {
                        MinTime = q.time + 1;
                        MinX = nx;
                        MinY = ny;
                        TimeMap[MinX][MinY] = MinTime;
                    } else if(MinTime == q.time + 1) {
                        if(MinX > nx) {
                            MinX = nx;
                            MinY = ny;
                            TimeMap[MinX][MinY] = MinTime;
                        } else if(MinX == nx) {
                            if(MinY > ny) {
                                MinX = nx;
                                MinY = ny;
                                TimeMap[MinX][MinY] = MinTime;
                            }
                        }
                    }
//                    Q.offer(new PosInfo(q.time + 1, nx, ny));
                }
            }
        }
        return;
    }
    //1. bfs로 경로 탐색
        //1-1. 이미 탐색한 위치일 경우 생략 -> TimeMap을 통해 검증
        //1-2. 배열의 인덱스를 넘어갈 경우 생략
        //1-3. 자신보다 크기가 큰 물고기가 있을 경우 탐색 x
        //1-4. 그 외의 경우에는 0일시 탐색, 물고기를 찾았을 경우에는 MinTime과 현재까지의 Time을 비교
            //1-4-1. 비교했을때 같은 경우 가장 왼쪽 위에있는 좌표로 갱신
            //1-4-2. 비교했을때 기존 값보다 작은 경우 갱신
            //1-4-3. 그렇지 않을 경우 무시
        //1-5. 모든 bfs가 종료되면 먹는 함수 호출
    //2. 먹는 함수
        //2-1. MinTime이 변경 X ? -> 그렇다면 먹을 수 있는 물고기가 없다는 소리이므로 그냥 종료
        //2-2. 먹을 수 있는게 있으면 상어 먹고 상어 관련 변수 변경해주고 다시 bfs호출

    private static void Init() {
        MinTime  = Integer.MAX_VALUE;
        MinX = Integer.MAX_VALUE;
        MinY = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            Arrays.fill(TimeMap[i], -1);
        }
        return;
    }
}
