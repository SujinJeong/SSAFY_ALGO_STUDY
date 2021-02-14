import java.util.*;
import java.io.*;
class Man{
    int x;//위치
    int t;//시간
    boolean b;
    public Man(int x, int t, boolean b)
    {
        this.x = x;
        this.t = t;
        this.b = b;
    }
}
class Main17836 {//공주님을 구해라
    //메모리초과
    static int N;
    static int M;
    static int T;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Man> q;

    public static void func(int x, int y, int t, boolean b)
    {
        if(t>T)
            return;//시간안에 못구하면 Fail
        
        // if(visited[x][y]==true)
        //     return;
        
        if(map[x][y]==2)
        b=true;//검을 가졌다
        
        // System.out.println(x+","+y+" "+t+"   "+b);
        visited[x][y]=true;
        
        if(x+1<N && visited[x+1][y]==false)
        {//아래
            if(map[x+1][y]!=1)//벽이아니면
                q.add(new Man((x+1)*M+y,t+1,b));
            else//벽이면
            {
                if(b==true)
                {
                    q.add(new Man((x+1)*M+y,t+1,b));//벽부수고 간다
                }
            }
        }
        if(x-1>=0 && visited[x-1][y]==false)
        {//위
            if(map[x-1][y]!=1)//벽이아니면
            q.add(new Man((x-1)*M+y,t+1,b));
            else//벽이면
            {
                if(b==true)
                {
                    q.add(new Man((x-1)*M+y,t+1,b));//벽부수고 간다
                }
            }
        }
        if(y+1<M && visited[x][y+1]==false)
        {//오른쪽
            if(map[x][y+1]!=1)//벽이아니면
            q.add(new Man(x*M+y+1,t+1,b));
            else//벽이면
            {
                if(b==true)
                {
                    q.add(new Man(x*M+y+1,t+1,b));//벽부수고 간다
                }
            }
        }
        if(y-1>=0 && visited[x][y-1]==false)
        {//왼쪽
            if(map[x][y-1]!=1)//벽이아니면
            q.add(new Man(x*M+y-1,t+1,b));
            else//벽이면
            {
                if(b==true)
                {
                    q.add(new Man(x*M+y-1,t+1,b));//벽부수고 간다
                }
            }
        }
    }
        
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        
        for(int i=0;i<N;i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        q = new LinkedList<>();
        q.add(new Man(0,0,false));
        
        int t=0;
        int x=0;
        int y=0;
        while(q.size()>0)
        {
            Man m = q.poll();
            x = m.x/M;
            y = m.x%M;
            t = m.t;

            if(x==N-1&&y==M-1)
                break;//공주님
                
            func(x,y,t,m.b);
        }
        if(x==N-1&&y==M-1)
        {
            System.out.println(t);
        }
        else
        System.out.println("Fail");
    }
}
