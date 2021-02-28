import java.util.*;
import java.io.*;
class Main2578 {//빙고
    static int[][] map;
    static boolean[][] visited;
    static int Bingo;

    public static int[] find(int a)
    {
        int[] result = new int[2];
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                if(map[i][j] == a)
                {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    public static void isBingo(int[] arr)
    {
        int[][] cross1 = {{0,0},{1,1},{2,2},{3,3},{4,4}};
        int[][] cross2 = {{4,0},{3,1},{2,2},{1,3},{0,4}};

        boolean b=true;
        for(int i=0;i<5;i++)
        {//세로확인
            if(visited[i][arr[1]]==false)
            {//하나라도 false면
                b=false;
                break;
            }
        }
        if(b==true)
            Bingo++;

        b=true;
        for(int j=0;j<5;j++)
        {//가로확인
            if(visited[arr[0]][j]==false)
            {//하나라도 false면
                b=false;
                break;
            }
        }
        if(b==true)
            Bingo++;

        b=false; 
        if(arr[0]==arr[1])
        {//대각선1
            b=true;
            for(int i=0;i<5;i++)
            {
                if(visited[cross1[i][0]][cross1[i][1]]==false)
                {
                    b=false;
                    break;
                }
            }
        }
        if(b==true)
            Bingo++;

        b=false;
        if(arr[0]+arr[1]==4)
        {//대각선2
            b=true;
            for(int i=0;i<5;i++)
            {
                if(visited[cross2[i][0]][cross2[i][1]]==false)
                {
                    b=false;
                    break;
                }
            }
        }
        if(b==true)
            Bingo++;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[5][5];
        for(int i=0;i<5;i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] arr = new int[25];
        for(int i=0;i<5;i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++)
            {
                arr[i*5+j] = Integer.parseInt(st.nextToken());
            }
        }


        visited = new boolean[5][5];
        Bingo = 0;
        for(int n=0;n<25;n++)
        {
            int[] xy = find(arr[n]);
            visited[xy[0]][xy[1]]=true;

            if(n>=4)
            {
                isBingo(xy);//그 위치 기준 가로 세로 대각선 빙고인지 확인

                if(Bingo>=3)
                {
                    System.out.println(n+1);
                    break;
                }
            }
        }
    }
    
}
