import java.util.*;
import java.io.*;
class Man{
    int x;//위치
    int t;//시간
    boolean b;//검이 있는지
    public Man(int x, int t, boolean b)
    {
        this.x = x;
        this.t = t;
        this.b = b;
    }
}
class Main17836 {//공주님을 구해라
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N;
    static int M;
    static int T;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Man> q;
  
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        
        int sword=0;
        for(int i=0;i<N;i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2)
                    sword = i*M+j;//검의 위치
            }
        }
        
        int min=987654321;
        q = new LinkedList<>();
        q.add(new Man(0,0,false));//시작위치
        
        int t=0;
        int x=0;
        int y=0;
        while(q.size()>0)
        {
            Man m = q.poll();
            x = m.x/M;
            y = m.x%M;
            t = m.t;
            
            visited[x][y]=true;

            if(x==N-1&&y==M-1)
                break;//공주님

            for(int dir=0;dir<4;dir++)
            {
                int nx = x+dx[dir];
                int ny = y+dy[dir];

                if(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny]!=1 && visited[nx][ny]==false)
                {//갈수있으면
                    q.add(new Man(nx*M+ny,t+1,false));
                }
            }  
             
        }//검을 갖지 않고 그냥 갔을 때의 t

        if(visited[N-1][M-1]==true && min>t)
            min=t;//공주님까지 간게 맞으면
        // System.out.println(t);


        visited = new boolean[N][M];
        q = new LinkedList<>();
        q.add(new Man(0,0,false));//초기화

        t=0;
        x=0;
        y=0;
        while(q.size()>0)
        {
            Man m = q.poll();
            x = m.x/M;
            y = m.x%M;
            t = m.t;
            // boolean b= m.b;

            visited[x][y]=true;

            if (x == sword / M && y == sword % M)
                break;//검까지 최단시간으로 간다

            for(int dir=0;dir<4;dir++)
            {
                int nx = x+dx[dir];
                int ny = y+dy[dir];

                if(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny]!=1 && visited[nx][ny]==false)
                {//갈수있으면
                    q.add(new Man(nx*M+ny,t+1,false));
                }
            }  
        }//검을 가진 후

        if(t>T || visited[sword/M][sword%M]==false)
        {//검을 시간안에 가지러 갈 수 없는 경우 ||  검을 가지러가지 못한 경우
            if(min < T)
            {//아까 검 없이 갔던 시간 < 제한시간
                System.out.println(min);
            }
            else
                System.out.println("Fail");
        }
        else
        {//시간안에 검을 가지러 갈 수 있는 경우
            //벽이랑 상관 없으니깐 그냥 최단 거리..
            t += Math.abs(N-1 - x)+ Math.abs(M-1 - y);
            // System.out.println(t);

            //그래서 검 없을때 vs 검 가지고 갔을때
            if(min>t)
                min = t;

            System.out.println(min);
        }

        // if(x==N-1&&y==M-1)
        // {
        //     System.out.println(t);
        // }
        // else
        // System.out.println("Fail");
    }
}
