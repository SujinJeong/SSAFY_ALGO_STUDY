import java.util.*;
import java.io.*;
class Main2917 {//늑대 사냥꾼
    static class Wolf{
        int x;
        int y;
        int dist;
        public Wolf(int x, int y, int dist)
        {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};//상하좌우
    static int N;
    static int M;
    static int[][] map;
    static int[][] arr;
    static boolean[][] visited;
    static Queue<Wolf> q;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];//입력 받는대로 -> 가는길의 최소값 중에 최대값 저장
        ArrayList<Integer> tree = new ArrayList<Integer>();
        map = new int[N][M];//tree에서 얼마나 떨어져있는지
        int start_x=0;
        int start_y=0;//나
        int finish_x=0; 
        int finish_y=0;//오두막
        for(int i=0;i<N;i++)
        {
            String str = br.readLine();
            for(int j=0;j<M;j++)
            {
                int a=0;
                if(str.charAt(j)=='+')
                {
                    tree.add(i*M+j);
                    a=1;
                }
                if(str.charAt(j)=='V')
                {//나
                    start_x = i;
                    start_y = j;
                }
                if(str.charAt(j)=='J')
                {//오두막
                    finish_x=i;
                    finish_y=j;
                }
                
                arr[i][j] = a;
            }
        }

        q = new LinkedList<Wolf>();
        visited = new boolean[N][M];

        for(int t = 0;t<tree.size();t++)
        {
            q.add(new Wolf(tree.get(t)/M,tree.get(t)%M,0));//나무를 다 넣어준다
        }

        while(q.size()!=0)
        {
            Wolf w = q.poll();
            int x = w.x;
            int y = w.y;
            int d = w.dist;

            if(visited[x][y]==true)
                continue;

            visited[x][y]=true;
            map[x][y] = d;
            for(int dir = 0; dir<4;dir++)
            {
                int nx = x+dx[dir];
                int ny = y+dy[dir];

                if(nx<0 || nx>=N || ny<0 || ny>=M)
                    continue;
                
                q.add(new Wolf(nx,ny,d+1));
            }
        }// bfs로 나무와 떨어진 최소 거리 map을 채운다

        /*
        6 5 4 5 6         .....
        5 4 3 4 5         .....
        4 3 2 3 4         .....
        3 2 1 2 3         .....
        2 1 0 1 2         V.+.J
        */

        //다익스트라로 나무와 떨어진 거리가 최대가 되도록
        //arr에 이동한 경로의 나무와 떨어진 거리 중에 최소값  의 최대값을 채운다
        PriorityQueue<Wolf> pq = new PriorityQueue<>(new Comparator<Wolf>(){
            public int compare(Wolf w1, Wolf w2)
            {
                return w2.dist - w1.dist;
            }
        });//큰값부터 나오게 한다

        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if(i==start_x && j ==start_y)
                    continue;//시작점 빼고
                arr[i][j]=-987654321;
                pq.add(new Wolf(i,j,-987654321));
            }
        }
        arr[start_x][start_y] = map[start_x][start_y];//시작점
        pq.add(new Wolf(start_x,start_y,map[start_x][start_y]));

        visited = new boolean[N][M];

        while(pq.size()!=0)
        {
            Wolf w = pq.poll();
            int x = w.x;
            int y = w.y;
            int d = w.dist;

            if(visited[x][y]==true)
                continue;

            visited[x][y]=true;

            if(d < arr[x][y])
                continue;//제일 큰값 고르는 거니까 안봐도 됨

            for(int dir = 0; dir<4;dir++)
            {//상하좌우로 갈 수 있다
                int nx = x+dx[dir];
                int ny = y+dy[dir];

                if(nx<0 || nx>=N || ny<0 || ny>=M)
                    continue;
                //갈수있는 점에서
                
                //start->(x,y) vs  x,y->nx,ny
                int temp = Math.min(d, map[nx][ny]);//가는길의 최소값

                // System.out.println(x+","+y+" -> "+nx+","+ny+" : "+map[nx][ny]+" vs "+d+" = "+temp +" --- "+arr[nx][ny]);
                if(arr[nx][ny] < temp)
                {//start->nx,ny vs 가는길의 최소값  중에 최대값 -> 크면 갱신
                    arr[nx][ny]=temp;
                    pq.add(new Wolf(nx,ny,arr[nx][ny]));
                }
            }
            // System.out.println();
            // for(int i=0;i<N;i++)
            // {
            //     for(int j=0;j<M;j++)
            //         System.out.print(arr[i][j]+" ");
            //     System.out.println();
            // }
        }

        System.out.println(arr[finish_x][finish_y]);
    }
}
/*
5 5
.....
.....
.....
.....
V.+.J
2
*/