import java.util.*;
import java.io.*;

class Main1303{
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static int W;
    static int B;
    static int count;

    public static void func(int x, int y, int a)
    {
        visited[x][y]=true;
        count++;

        if(x+1<N && map[x+1][y]==a && visited[x+1][y]==false)
        {//아래
            func(x+1,y,a);
        }
        if(x-1>=0 && map[x-1][y]==a && visited[x-1][y]==false)
        {//위
            func(x-1,y,a);
        }
        if(y+1<M && map[x][y+1]==a && visited[x][y+1]==false)
        {//오른쪽
            func(x,y+1,a);
        }
        if(y-1>=0 && map[x][y-1]==a && visited[x][y-1]==false)
        {//왼쪽
            func(x,y-1,a);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++)
        {
            String str = br.readLine();
            for(int j=0;j<M;j++)
            {
                if(str.charAt(j)=='W')
                map[i][j] = 1;
                else
                map[i][j] = 2;
            }
        }

        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if(visited[i][j]==false)
                {
                    func(i,j,map[i][j]);
                    if(map[i][j]==1)
                        W+=count*count;
                    else
                        B+=count*count;
                    count=0;
                }
            }
        }  

        System.out.println(W+" "+B);     
    }
}