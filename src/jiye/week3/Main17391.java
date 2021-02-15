import java.io.*;
import java.util.*;
class Kart{
    int x;
    int t;
    public Kart(int x, int t)
    {
        this.x = x;//위치
        this.t = t;//시간
    }
}

class Main17391{//무한부스터
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;//역시 visited가 중요하군
    static Queue<Kart> q;

    public static void func(int x, int y,int t)
    {
        if(visited[x][y]==true)
            return;

        visited[x][y]=true;

        for(int i=map[x][y];i>=1;i--)
        {//최대 부스터만큼 최소 1칸
            if(x+i<N && visited[x+i][y]==false)
            {//아래쪽으로 i칸
                q.add(new Kart((x+i)*M+y,t+1));
            }

            if(y+i<M&& visited[x][y+i]==false)
            {//오른쪽으로 i칸
                q.add(new Kart(x*M+y+i,t+1));
            }
        }
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i=0;i<N;i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }//입력

        q = new LinkedList<>();
        visited = new boolean[N][M];
        q.add(new Kart(0,0));//시작위치
        int min = 0;

        while(q.size()>0)
        {
            Kart k = q.poll();
            int x = k.x/M;
            int y = k.x%M;
            int t = k.t;

            if(x==N-1 && y==M-1)
            {//도착하면 게임 종료
                min = t;//그때의 시간
                break;
            }

            func(x,y,t);
        }

        System.out.println(min);
    }
}