import java.util.*;
import java.io.*;
class Man{
    int x;//위치
    int t;//시간
    int b;//검이 있는지
    public Man(int x, int t, int b)
    {
        this.x = x;
        this.t = t;
        this.b = b;
    }
}
class Main17836_copy {//공주님을 구해라
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N;
    static int M;
    static int T;
    static int[][] map;
    static int[][] visited;
    static Queue<Man> q;
  
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new int[N*M][2];//검 없을때, 검 있을때
        
        for(int i=0;i<N;i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int min=987654321;
        q = new LinkedList<>();
        q.add(new Man(0,0,0));//시작위치
        
        int t=0;
        int x=0;
        int y=0;
        while(q.size()>0)
        {
            Man m = q.poll();
            x = m.x/M;
            y = m.x%M;
            t = m.t;
            int mb=m.b;

            if(map[x][y]==2)
            {//이 칸이 검이있는 칸이면
                mb=1;//검이 있다
            }
            
            if(x==N-1&&y==M-1)
            {
                min=t;//이거였군
                break;//공주님
            }

            for(int dir=0;dir<4;dir++)
            {
                int nx = x+dx[dir];
                int ny = y+dy[dir];

                if(mb==1)
                {//검이 있으면
                    if(nx>=0 && nx<N && ny>=0 && ny<M && visited[nx*M+ny][mb]==0)
                    {//갈수있으면
                        visited[nx*M+ny][mb]=t+1;
                        q.add(new Man(nx*M+ny,t+1,mb));
                    }
                }
                else
                {
                    if(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny]!=1 && visited[nx*M+ny][mb]==0)
                    {//갈수있으면
                        visited[nx*M+ny][mb]=t+1;//이거랑
                        q.add(new Man(nx*M+ny,t+1,mb));
                    }
                }
            }  
            // for(int i=0;i<N;i++)
            // {
            //     for(int j=0;j<M;j++)
            //     {
            //         System.out.print(visited[i*M+j][mb]+" ");
            //     }
            //     System.out.println();
            // }
             
        }

        if(min<=T && min>0)
            System.out.println(t);
        else
            System.out.println("Fail");
    }
}
