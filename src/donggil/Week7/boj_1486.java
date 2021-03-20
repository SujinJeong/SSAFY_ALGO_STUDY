package donggil.Week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1486 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken()),
                M = Integer.parseInt(stk.nextToken()),
                T = Integer.parseInt(stk.nextToken()),
                D = Integer.parseInt(stk.nextToken());
        char[][] Map = new char[N][M];
        int[][] heightMap = new int[N][M], upAnswer = new int[N][M], downAnswer = new int[N][M];
        final int[] dir_x = {-1, 0, 1, 0};
        final int[] dir_y = {0, -1, 0, 1};
        ArrayList<int[]>[][] upStream = new ArrayList[N][M];
        ArrayList<int[]>[][] downStream = new ArrayList[N][M];

        for(int i = 0; i < N; i++) {
            Map[i] = br.readLine().toCharArray();
            for(int j = 0; j < M; j++) {
                upAnswer[i][j] = 987654321;
                downAnswer[i][j] = 987654321;
            }
        }

        initMap(N, M, Map, heightMap);
        initList(N, M, T, dir_x, dir_y, heightMap, upStream, downStream);
        dijkstra(upStream, upAnswer);
        dijkstra(downStream, downAnswer);

        int answer = heightMap[0][0];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(upAnswer[i][j] + downAnswer[i][j] <= D && answer <= heightMap[i][j]) {
                    answer = heightMap[i][j];
                }
            }
        }
        System.out.println(answer);
    }
    private static void initMap(int N, int M, char[][] Map, int[][] heightMap) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(Map[i][j] >= 'a' && Map[i][j] <= 'z') {
                    heightMap[i][j] = Map[i][j] - 'a' + 26;
                } else {
                    heightMap[i][j] = Map[i][j] - 'A';
                }
            }
        }
    }
    //각 행과 열에서 4방향 탐색해서 갈 수 있는 경로에 대해 등산하기, 하산하기 ArrayList를 생성하여준다
    //해당 ArrayList의 row, col는 출발 노드의 좌표이고 안에 들어있는 값은 해당 위치에서 다른 위치로 갈때 드는 시간이다
    private static void initList(int N, int M, int T, int[] dir_x, int[] dir_y, int[][] heightMap, ArrayList<int[]>[][] upStream, ArrayList<int[]>[][] downStream) {
        for(int x = 0; x < N; x++) {
            for(int y = 0; y < M; y++) {
                upStream[x][y] = new ArrayList<>();
                downStream[x][y] = new ArrayList<>();
                for(int dir = 0; dir < 4; dir++) {
                    int nx = x + dir_x[dir];
                    int ny = y + dir_y[dir];
                    if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                    int fromHeight = heightMap[x][y], toHeight = heightMap[nx][ny];
                    int diff = fromHeight - toHeight;
                    //높이 차이가 T보다 크지 않은 곳으로만 돌아다닐 수 있음
                    if(Math.abs(diff) > T) continue;

                    //등산하는 입장 => start에서 end로 가는 높이가 작거나 같을떄, 너 높을떄의 시간을 문제대로 적용해준다
                    if(fromHeight >= toHeight) {
                        upStream[x][y].add(new int[]{1, nx, ny});
                    } else {
                        upStream[x][y].add(new int[]{diff * diff, nx, ny});
                    }
                    //하산하는 입장 => start와 end가 뒤집어있기에 반대로 걸리는 시간을 적용해준다
                    if(fromHeight <= toHeight) {
                        downStream[x][y].add(new int[]{1, nx, ny});
                    } else {
                        downStream[x][y].add(new int[]{diff * diff, nx, ny});
                    }
                }
            }
        }
    }
    private static void dijkstra(ArrayList<int[]>[][] streamList, int[][] answer) {
        PriorityQueue<int[]> Q = new PriorityQueue<>(new Comparator<int[]>() { //봉우리 넘어가는데 걸리는 시간에 대한 우선순위 큐
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        //비용, x, y 넣어줌
        Q.add(new int[]{0, 0, 0});
        answer[0][0] = 0;

        while(!Q.isEmpty()) {
            int[] info = Q.poll();
            if(answer[info[1]][info[2]] < info[0]) continue;
            for(int[] elem : streamList[info[1]][info[2]]) {
                //가려는 위치에 대한 최적의 값이 이때까지의 걸린 시간 + 해당 봉우리로 등산을 할때의 시간보다 클 경우에는 최적의 값을 갱신시켜줌
                if(answer[elem[1]][elem[2]] > info[0] + elem[0]) {
                    answer[elem[1]][elem[2]] = info[0] + elem[0];
                    Q.add(new int[]{answer[elem[1]][elem[2]], elem[1], elem[2]});
                }
            }
        }
    }
}