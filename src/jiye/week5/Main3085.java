import java.util.*;
import java.io.*;

class Main3085 {//사탕게임
    static int N;
    static int cnt;
    static char[][] map;
    static int max;
    
    public static void countW(int x, int y,char a)
    {//가로 최대 개수
        cnt++;
        if(y+1 < N && map[x][y+1]==a)
            countW(x,y+1,a);//같으면 그 다음걸 계속 본다
        else
        {
            if(max<cnt)
                max=cnt;//그 줄의 최대값
            cnt=0;//초기화
            if(y+1 < N)
                countW(x,y+1,map[x][y+1]);//다르면 그 다음칸 시작
        }
    }

    public static void countH(int x, int y,char a)
    {//세로 최대 개수
        cnt++;
        if(x+1 < N && map[x+1][y]==a)
            countH(x+1,y,a);//같으면 그 다음걸 계속 본다
        else
        {
            if(max<cnt)
                max=cnt;//그 줄의 최대값
            cnt=0;//초기화
            if(x+1 < N)
                countH(x+1,y,map[x+1][y]);//다르면 그 다음칸 시작
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        for(int i=0;i<N;i++)
        {
            String str = br.readLine();
            for(int j=0;j<N;j++)
            {
                map[i][j] = str.charAt(j);
            }
        }

        max=0;
        cnt=0;
        for(int i=0;i<N;i++)
        {
            cnt=0;
            countW(i,0,map[i][0]);//가로를 쭉 본다
            cnt=0;
            countH(0,i,map[0][i]);//세로를 쭉 본다
        }

        //사탕의 색이 다른 인접한 두칸
        //가로 두칸 | 세로 두칸
        for(int i=0;i<N;i++)
        {
            cnt=0;
            for(int j=0;j<N;j++)
            {
                cnt=0;
                if (j + 1 < N && map[i][j] != map[i][j + 1])
                {//옆칸이랑 다르다
                    char temp = map[i][j];
                    map[i][j]=map[i][j+1];
                    map[i][j+1]=temp;//바꾸고

                    countW(i,0,map[i][0]);
                    cnt=0;
                    countH(0,j,map[0][j]);
                    cnt=0;
                    countH(0,j+1,map[0][j+1]);
                    cnt=0;

                    temp = map[i][j];
                    map[i][j]=map[i][j+1];
                    map[i][j+1]=temp;//다시 바꾸고
                }

                cnt=0;
                if (i + 1 < N && map[i][j] != map[i + 1][j])
                {//아래칸이랑 다르다
                    char temp = map[i][j];
                    map[i][j]=map[i+1][j];
                    map[i+1][j]=temp;//바꾸고

                    countW(i,0,map[i][0]);
                    cnt=0;
                    countW(i+1,0,map[i+1][0]);
                    cnt=0;
                    countH(0,j,map[0][j]);
                    cnt=0;

                    temp = map[i][j];
                    map[i][j]=map[i+1][j];
                    map[i+1][j]=temp;//다시 바꾸고
                }
            }
        }

        System.out.println(max);
    }
}
