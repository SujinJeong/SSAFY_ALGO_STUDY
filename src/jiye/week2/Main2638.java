import java.util.*;
import java.io.*;
 class Main2638 {//치즈
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
//쭉돌면서 외부공기 체크-dfs 대신 매번 체크해야한다
    public static int check( int x, int y)
    {
        int cnt=0;
        if(map[x-1][y]==2)
            cnt++;
        if(map[x+1][y]==2)
            cnt++;
        if(map[x][y-1]==2)
            cnt++;
        if(map[x][y+1]==2)
            cnt++;
        return cnt;
    }

    public static void inside(int x, int y)
    {//외부공기는 다 2로 바꾼다
        if(map[x][y]==1|| visited[x][y]==true)
        return;//치즈면 바꾸지 말고
        
        map[x][y]=2;
        visited[x][y]=true;
        
        if(x+1<N && map[x+1][y]!=1)
        {//오른쪽
            inside(x+1,y);
        }
        if(y+1<M && map[x][y+1]!=1)
        {//아래
            inside(x,y+1);
        }
        if(y-1>=0 && map[x][y-1]!=1)
        {//위
            inside(x,y-1);
        }
        if(x-1>=0 && map[x-1][y]!=1)
        {
            inside(x-1,y);
        }
    }

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        
        Queue<Integer> cheese = new LinkedList<>();
        
        for(int i=0;i<N;i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++)
            {
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]==1)
                {
                    cheese.add(i*M+j);
                }
            }
        }
        
        
        
        int t=0;
        while(true)
        {
            visited = new boolean[N][M];
            inside(0,0);//외부공기 바꾸고...
            Queue<Integer> q = new LinkedList<>();
            while(cheese.size()>0)
            {
                int c = cheese.poll();
                int x = c/M;
                int y = c%M;
                
                if(check(x,y)>=2)
                {
                    map[x][y]=0;
                }
                else
                q.add(x*M+y);
                
            }
            
            // for(int i=0;i<N;i++)
            // {
            //     for(int j=0;j<M;j++)
            //     {
            //         System.out.print(map[i][j]+" ");
            //     }
            //     System.out.println();
            // }
            // System.out.println();
            
            t++;
            if(q.size()==0)
                break;
            cheese=q;
        }
        System.out.println(t);
        
    }
}


