import java.io.*;
import java.util.*;

class Main2234 {//성곽
    static int[] dx = {0,-1,0,1};//서 북 동 남
    static int[] dy = {-1,0,1,0};
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;
    static int max2=0;
    static int max3=0;
    static int answer2;
    static int answer3;

    public static void dfs(int x, int y)
    {
        if(visited[x][y]==true)
        return;

        visited[x][y]=true;
        answer2++;
        answer3++;

        String str = Integer.toBinaryString(15 ^ map[x][y]);//벽이 없는 경우
        // System.out.print(" "+str+" ");
        
        for(int s=str.length()-1;s>=0;s--)
        {
            if(str.charAt(s)=='1')
            {
                int dir = str.length()-1-s;
                // System.out.println(" "+dir+" ");
                if(x+dx[dir]>=0 && x+dx[dir]<n && y+dy[dir]>=0 && y+dy[dir]<m)
                {
                    dfs(x+dx[dir],y+dy[dir]);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0;i<n;i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        
        // for (int i=0; i<n; i++) {
        //     for (int j=0; j<m; j++) {
        //         String str = Integer.toBinaryString(15 ^ map[i][j]);
        //         System.out.print(str+" ");
                
        //         for(int s=str.length()-1;s>=0;s--)
        //         {
        //             if(str.charAt(s)=='1')
        //             {
        //                 System.out.print((int)Math.pow(2,str.length()-1-s)+" ");
        //             }
                    
        //         }
        //     }
        //     System.out.println();
        // }

        int answer1=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(visited[i][j]==false)
                {
                    answer2=0;
                    dfs(i,j);
                    answer1++;
                    if(max2<answer2)
                        max2 = answer2;
                }
            }
        }
    
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {//모든칸의 벽을 하나씩 부셔보자 50*50*4
                int x=i;
                int y=j;
                String str = Integer.toBinaryString(map[x][y]);//벽이 있는 경우
                
                for(int s=str.length()-1;s>=0;s--)
                {
                    if(str.charAt(s)=='1')
                    {
                        int dir = str.length()-1-s;
                        if(x+dx[dir]>=0 && x+dx[dir]<n && y+dy[dir]>=0 && y+dy[dir]<m)
                        {
                            answer3=0;
                            visited = new boolean[n][m];

                            dfs(x+dx[dir],y+dy[dir]);//벽뚤린방향과
                            dfs(x,y);//원래방향
                            if(max3<answer3)
                                max3=answer3;
                            // System.out.println(answer3);
                        }
                    }
                }
            }
        }

           System.out.println(answer1);
       System.out.println(max2);
       System.out.println(max3);
    }
}
