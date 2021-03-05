import java.util.*;
import java.io.*;
class Main9663 {//N-Queen
    static int N;
    static int cnt;
    static int[][] map;

    public static void func(int x)
    {//x번째 줄
        if(x>=N)
        {
            cnt++;
            return;
        }

        // System.out.println();
        // for(int i=0;i<N;i++)
        // {
        //     for(int j=0;j<N;j++)
        //         System.out.print(map[i][j]+" ");
        //     System.out.println();
        // }
        
        boolean b=false;
        for(int j=0;j<N;j++)
        {
            if(queen(x,j)==true)
            {//map[x][j]에 놨을 때 가능하면 
                b=true;
                map[x][j]=1;
                func(x+1);//그다음줄로 넘어감
                map[x][j]=0;
                b=false;
            }
            //안되면 
        }
        //만약에 x행 어디에 둬도 안되면
        if(b==false)
        {
            return;//이전줄 다시
        }
    }

    public static boolean queen(int x, int y)
    {
        for(int i=0;i<N;i++)
        {//세로
            if(map[i][y]==1)
                return false;
        }

        for(int i=0;i<N;i++)
        {//이쪽 대각선
            if(x-i>=0 && y-i>=0 && map[x-i][y-i]==1)
                return false;
            if(x+i<N && y+i<N && map[x+i][y+i]==1)
                return false;
        }

        for(int i=0;i<N;i++)
        {//저쪽 대각선
            if(x-i>=0 && y+i<N && map[x-i][y+i]==1)
                return false;
            if(x+i<N && y-i>=0 && map[x+i][y-i]==1)
                return false;
        }

        return true;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        // map = new int[N][N];

        for(int n=0;n<N;n++)
        {
            map = new int[N][N];//초기화
            int x=0;
            map[x][n]=1;//퀸을 둔다

            func(x+1);
        }//아예이포문을 돌릴필요가 없다고? 함수 안에서만?
        //아 맵을 그릴 필요가 없었따
        
        System.out.println(cnt);
    }
}
