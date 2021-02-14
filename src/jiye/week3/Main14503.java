import java.util.*;
import java.io.*;
 class Main14503 {//로봇청소기
    static int[] dx={-1,0,1,0};//북동남서
    static int[] dy={0,1,0,-1};
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static int count;

    public static void clean(int x, int y, int d)
    {
        if(count==4)
        {//네방향 모두 청소
            count=0;
            int xxx = x-dx[d];
            int yyy = y-dy[d];
            if(map[xxx][yyy]==1)
                return;
            // if(map[xxx][yyy]!=1)
            else
            {//후진가능
                clean(xxx,yyy,d);
                return;
            }
        }
        
        map[x][y]=2;//현재위치를 청소한다
        // System.out.println();

        // for(int i=0;i<N;i++)
        // {
        //     for(int j=0;j<M;j++)
        //     System.out.print(map[i][j]+" ");
        //     System.out.println();
        // }

        int dd=0;
        if(d==0)
            dd=3;
        else
            dd=d-1;
        //방향을 바꾼다

        int xx=x+dx[dd];
        int yy=y+dy[dd];//왼쪽방향 탐색
        if(map[xx][yy]==0)
        {//갈수있으면 //청소할공간이 있다
            count=0;
            clean(xx,yy,dd);
            return;
        }
        else
        {//청소할공간 없다
            count++;
            clean(x,y,dd);
            return;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        int[] robot = new int[3];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<3;i++)
            robot[i]= Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(robot[0],robot[1],robot[2]);

        int answer=0;
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if(map[i][j]==2)
                    answer++;
            }
        }
        System.out.println(answer);
    }
    
}
