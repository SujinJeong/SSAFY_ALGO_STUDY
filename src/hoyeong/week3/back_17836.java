package week3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
class input2{
   int r;
   int c;
   int cnt;
   public input2(int r, int c, int cnt) {
      super();
      this.r = r;
      this.c = c;
      this.cnt = cnt;
   }
}
public class back_17836 {
      static int N, M, T, r=0, c=0, result = 987654321, result_s = 987654321;
      static int [][] map;
      static int [][] visited;
      static Queue <input2> q = new LinkedList<>();
      static List<Integer> list = new ArrayList<>();
      
      final static int [] dr = {1,0,-1,0};
      final static int [] dc = {0,1,0,-1};
      public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st = new StringTokenizer(br.readLine());
         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
         T = Integer.parseInt(st.nextToken());
         map = new int[N][M];
         visited = new int [N][M];
         for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
               map[i][j] =  Integer.parseInt(st.nextToken());
            }
         }
         q.add(new input2(0,0,0));
         visited[0][0] = 1;
         bfs();
         
         result = Math.min(result, result_s);

         if(result >= 1 && result<=T) System.out.println(result); // 공주를 찾았을 경우 시간 비교
           else System.out.println("Fail"); // 공주를 찾았는데 시간이 넘은 경우
      }
      
      private static void bfs() {
         
         while(!q.isEmpty()) {
            input2 node = q.poll();
            r = node.r;
            c = node.c;
            
            if(r==N-1 && c==M-1) { // 검 없이 갔을 때의 최단거리
               result = node.cnt;
               break;
            }
            
            for(int dir=0; dir<4; dir++) {
               int nr = r + dr[dir];
               int nc = c + dc[dir];
               
               if(nc<0 || nr<0 || nc>=M || nr>=N) continue;
               
               if(visited[nr][nc] == 0 && map[nr][nc]!=1) {
                  visited[nr][nc] = visited[r][c] + 1;
                  q.add(new input2(nr,nc,node.cnt+1));
                  if(map[nr][nc]==2) {   // 검을 찾았을 때 최단거리 예측
                     result_s = (node.cnt+1 + (N-1-nr)+ (M-1-nc));
                  }
               }
            }
         }
      }
}