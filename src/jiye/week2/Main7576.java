import java.util.*;
import java.io.*;
class Tomato{
    int x;
    int t;
    public Tomato (int x, int t)
    {
        this.x = x;
        this.t = t;
    }
}
class Main7576 {//토마토
    static int N;
    static int M;
    static int[][] map;
    static Queue<Tomato> q;

    public static void func(int x, int y, int a)
    {
        if(x-1>=0)
        {//상
            if(map[x-1][y]==0)
            {
                map[x-1][y]=a;
                q.add(new Tomato((x-1)*M+y,a));
            }
        }
        if(x+1<N)
        {//하
            if(map[x+1][y]==0)
            {    
                map[x+1][y]=a;
                q.add(new Tomato((x+1)*M+y,a));
            }
        }
        if(y-1>=0)
        {//좌
            if(map[x][y-1]==0)
            {    
                map[x][y-1]=a;
                q.add(new Tomato(x*M+y-1,a));
            }
        }
        if(y+1<M)
        {//우
            if(map[x][y+1]==0)
            {    
                map[x][y+1]=a;
                q.add(new Tomato(x*M+y+1,a));
            }
        }
    }

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        q = new LinkedList<Tomato>();

        for(int i=0;i<N;i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++)
            {
                map[i][j]= Integer.parseInt(st.nextToken());
                if(map[i][j]==1)
                    q.add(new Tomato(i*M+j,0));
            }
        }

        int t=0;
        while(q.size()>0)
        {
            Tomato a = q.poll();
            int x = a.x/M;
            int y = a.x%M;
            t = a.t;
            
            func(x,y,t+1);
        }

        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if(map[i][j]==0)
                {
                    t=-1;
                    break;
                }
            }
        }

        System.out.println(t);
    }
}
