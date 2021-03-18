package donggil.Week4;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;
//Logic

//1. Map에는 각 방에 벽 정보를 저장하고 있다.
//2. 입력받은 정보를 토대로 Map을 DFS로 탐색하며 visited배열에 방 번호를 배정해주고 HashMap에는 해당 방 정보에 대한 방의 크기를 저장
//3. 벽을 부시는 과정에서는 Map을 탐색하면서 인접한 방과의 번호가 다른경우 HashMap에 저장해놓은 방의 크기를 두개 더해줘서 max값을 찾는다.
public class boj_2234 {
    private static int[] dir_x = {0, -1, 0, 1};
    private static int[] dir_y = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> sizeHash = new HashMap<>();
        int col = Integer.parseInt(stk.nextToken());
        int row = Integer.parseInt(stk.nextToken());
        int[][] Map = new int[row][col];
        int[][] visited = new int[row][col];
        int cnt = 0, max = -987654321, remMax = -987654321;

        for(int i = 0; i < row; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < col; j++) {
                Map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }
        int size = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(visited[i][j] == 0) {
                    cnt++;
                    visited[i][j] = cnt;
                    size = DFS(row, col, i, j, cnt, Map, visited);
                    if(max < size) max = size;
                    sizeHash.put(cnt, size);
                }
            }
        }
        int sizeA, sizeB;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                for(int dir = 0; dir < 4; dir++) {
                    int nx = i + dir_x[dir];
                    int ny = j + dir_y[dir];

                    if(nx < 0 || ny < 0 || nx >= row || ny >= col) continue;

                    if(visited[i][j] != visited[nx][ny]) {
                        sizeA = sizeHash.get(visited[i][j]);
                        sizeB = sizeHash.get(visited[nx][ny]);
                        if(remMax < sizeA + sizeB) remMax = sizeA + sizeB;
                    }
                }
            }
        }
        sb.append(cnt).append("\n").append(max).append("\n").append(remMax);
        bw.write(sb.toString());
        bw.flush();
    }
    private static int DFS(int row, int col, int r, int c, int cnt, int[][] Map, int[][] visited) {
        int size = 1;
        for(int dir = 0; dir < 4; dir++) {
            if((Map[r][c] & (1 << dir)) == 0) {
                int nx = r + dir_x[dir];
                int ny = c + dir_y[dir];

                if(nx < 0 || ny < 0 || nx >= row || ny >= col) continue;

                if(visited[nx][ny] == 0) {
                    visited[nx][ny] = cnt;
                    size += DFS(row, col, nx, ny, cnt, Map, visited);
                }
            }
        }
        return size;
    }
}