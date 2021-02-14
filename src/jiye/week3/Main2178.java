import java.util.*;
import java.io.*;

class My{
    int x;
    int count;
    public My(int x, int count)
    {
        this.x = x;
        this.count = count;
    }
}

class Main2178 {
    static int N;
    static int M;
    static int answer;
    static int[][] map;
    static Queue<My> q;
    static boolean[][] visited;

    public static void func(int x, int y,int cnt)
    {
        // visited[x][y]=true;

        if(x==N-1 && y==M-1)
        {
            answer = cnt;
            return;
        }

                
        if(x-1>=0 && map[x-1][y]==1 && visited[x-1][y]==false)
        {
            visited[x-1][y]=true;//흐음 여기에 visited를..
            q.add(new My((x-1)*M+y,cnt+1));
        }
        if(x+1<N && map[x+1][y]==1 && visited[x+1][y]==false)
        {
            visited[x+1][y]=true;
            q.add(new My((x+1)*M+y,cnt+1));
        }
        if(y-1>=0 && map[x][y-1]==1 && visited[x][y-1]==false)
        {
            visited[x][y-1]=true;
            q.add(new My(x*M+y-1,cnt+1));
        }
        if(y+1<M && map[x][y+1]==1 && visited[x][y+1]==false)
        {
            visited[x][y+1]=true;
            q.add(new My(x*M+y+1,cnt+1));
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++)
        {
            String str = br.readLine();
            for(int j=0;j<M;j++)
            {
                map[i][j] = str.charAt(j)-'0';
            }
        }

        q = new LinkedList<>();
        q.add(new My(0,1));

        while(q.size()>0)
        {
            My m = q.poll();
            int x = m.x/M;
            int y = m.x%M;
            int count = m.count;

            func(x,y,count);
        }

        System.out.println(answer);
    }
}
