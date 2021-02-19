import java.util.*;
import java.io.*;

class Main1992{//쿼드트리
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0;i<N;i++)
        {
            String str = br.readLine();
            for(int j=0;j<N;j++)
            {
                map[i][j] = str.charAt(j)-'0';
            }
        }

        func(0,0,N);
        System.out.println(sb);
    }

    public static void func(int x, int y,int N)
    {
        if(N==1)
        {
            sb.append(map[x][y]);
            System.out.println(x+" "+y);
            return;
        }
        
        sb.append("(");
        for (int i = x; i < x+N; i += N / 2) 
        {
            for (int j = y; j < y+N; j += N / 2)
            {
                func(i, j, N/2);
            }
        }//4개 구역
        //같은거면 생략한다
        int index = sb.length()-1;
        boolean b = true;
        for(int i=1;i<4;i++)
        {
            if(sb.charAt(index)!=sb.charAt(index-i))
            {
                b=false;
                break;//틀린게 있으면
            }
        }
        if(b==true)
        {//다 같으면
            sb.delete(index-4,index);//같은거하나만 남기고 (랑 같이 지운다
        }
        else
            sb.append(")");        
    }
}