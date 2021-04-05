import java.util.*;
import java.io.*;
class Main6087 {//레이저 통신
    static class Mir{
        int x;
        int y;
        int cnt;
        int d;
        public Mir(int x, int y, int cnt,int d)
        {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.d = d;
        }
    }

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][] map = new int[H][W];

        int cx=0;
        int cy=0;
        for(int i=0;i<H;i++)
        {
            String str = br.readLine();
            for(int j=0;j<W;j++)
            {
                char c = str.charAt(j);
                if(c=='.')
                    map[i][j]=0;
                else if(c=='*')
                    map[i][j] = 1;
                else
                {
                    map[i][j]=2;
                    cx = i;
                    cy=j;
                }
            }
        }

        int[][] DP = new int[H][W];
        for(int i=0;i<H;i++)
        {
            for(int j=0;j<W;j++)
                DP[i][j]=987654321;
        }
        boolean[][] visited = new boolean[H][W];
        Queue<Mir> q = new LinkedList<>();
        q.add(new Mir(cx,cy,-1,-1));//시작점

        int answer=0;
        int ax=0;
        int ay=0;
        while(q.size()!=0)
        {
            Mir m = q.poll();
            int x = m.x;
            int y = m.y;
            int cnt = m.cnt;
            int d = m.d;
            // System.out.println(x+","+y+"  "+cnt+" "+d);

            if(DP[x][y] > cnt)
                DP[x][y] = cnt;

            if((x!=cx || y!=cy) && map[x][y]==2)
            {
                // System.out.println(x+" "+y);
                ax=x;
                ay=y;
                answer=cnt;
                break;
            }
            if(visited[x][y]==true)
                continue;
            visited[x][y]=true;

            for(int dir=0;dir<4;dir++)
            {
                int xx = x;
                int yy = y;
                while(true)
                {//dir방향으로
                    int nx = xx + dx[dir];
                    int ny = yy + dy[dir];
                    // System.out.println(nx+" "+ny);

                    if(nx<0 || nx>=H || ny<0 || ny>=W)
                        break;//못가거나

                    if(map[nx][ny]==1)
                        break;//벽이면

                    if(d==dir)
                    {//방향이 같으면
                        q.add(new Mir(nx,ny,cnt,d));//거울개수 그대로
                    }
                    else
                    {
                        q.add(new Mir(nx,ny,cnt+1,dir));
                    }
                    xx=nx;
                    yy=ny;
                }
            }
        }
        // for(int i=0;i<H;i++)
        //     System.out.println(Arrays.toString(DP[i]));

        // System.out.println(ax+" "+ay+" "+cx+" "+cy);
        System.out.println(DP[ax][ay]);
    }
}
