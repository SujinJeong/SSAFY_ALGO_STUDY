package donggil.Week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//Logic
//각 나무에서 각 좌표들 '.'들에 대해서 BFS를 돌아서 가장 가까운 나무와의 거리를 구해준다
//BFS를 도는 중에 타겟 노드에 들어있는 거리값이 이미 작은 값이 존재한다면 노드에 넣어주지 않는다.

//BFS를 통해서 구한 2차원 거리 배열을 이용해서 도착지까지 BFS를 돈다 => 여기서 중요한건 우선순위큐로 가장 큰 거리값들부터 하나씩 꺼내와서
//탐색하여 준다 => 그 거리중에 가장 작은 최소값을 도출해낸다

//풀이 시간 : 오래 걸림...
public class boj_2917 {
    private static int[] dir_x = {-1, 0, 1, 0}, dir_y = {0, -1, 0, 1};
    private static void BFS(int N, int M, int[][] Dist, ArrayList<int[]> treeList) {
        Queue<int[]> Q = new LinkedList<>();
        for(int[] tree : treeList) {
            Q.add(new int[]{tree[0], tree[1], 0});
        }
        while(!Q.isEmpty()) {
            int[] node = Q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = node[0] + dir_x[i];
                int ny = node[1] + dir_y[i];
                int nextDist = node[2] + 1;
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if(Dist[nx][ny] > nextDist) {
                    Dist[nx][ny] = nextDist;
                    Q.add(new int[]{nx, ny, nextDist});
                }
            }
        }
    }
    private static void BFS2(int N, int M, int[] start, int[] end, int[][] Dist) {
        PriorityQueue<int[]> Q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[2] - o1[2];
            }
        });
        boolean[][] visited = new boolean[N][M];
        int answer = Math.min(Dist[start[0]][start[1]], Dist[end[0]][end[1]]);

        visited[start[0]][start[1]] = true;
        Q.add(new int[]{start[0], start[1], Dist[start[0]][start[1]]});

        while(!Q.isEmpty()) {
            int[] elem = Q.poll();

            answer = Math.min(answer, Dist[elem[0]][elem[1]]);

            if(elem[0] == end[0] && elem[1] == end[1]) {
                System.out.println(answer);
                return;
            }
            for(int i = 0; i < 4; i++) {
                int nx = elem[0] + dir_x[i];
                int ny = elem[1] + dir_y[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                Q.add(new int[]{nx, ny, Dist[nx][ny]});
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        final int INF = 987654321;
        int[] start = new int[2], end = new int[2];
        int N = Integer.parseInt(stk.nextToken()), M = Integer.parseInt(stk.nextToken());
        int[][] Dist = new int[N][M];
        ArrayList<int[]> treeList = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            Arrays.fill(Dist[i], INF);
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                char ch = line.charAt(j);

                if(ch == 'V') {
                    start[0] = i;
                    start[1] = j;
                } else if(ch == 'J') {
                    end[0] = i;
                    end[1] = j;
                } else if(ch == '+') {
                    Dist[i][j] = 0;
                    treeList.add(new int[]{i, j});
                }

            }
        }

        BFS(N, M, Dist, treeList);
        BFS2(N, M, start, end, Dist);
    }
}
