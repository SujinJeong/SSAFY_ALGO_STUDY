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



        //N/2로 계속 쪼개
        //쪼갤때마다 ( 열고 시작
        //N = 1 가장 작은 단위 -> 값 쓴다
        //4개 다 보고나서 값이 다 같은지 아닌지 확인 boolean b 이용
        //같은경우  (1111  -> 괄호까지 지우고 1하나만 남김
        //다른경우  (1011  -> 닫는 괄호 (1011)
        
        // 0,0       0,4
        //
        // 4,0       4,4
        //
        // 0,0  0,2  0,4  0,6
        // 2,0  2,2  2,4  2,6
        // 4,0  4,2  4,4  4,6
        // 6,0  6,2  6,4  6,6
        //
        //0,0 0,1   0,2 0,3 ...
        //1,0 1,1   1,2 1,3 ...

        func(0,0,N);
        System.out.println(sb);
    }

    public static void func(int x, int y,int N)
    {
        if(N==1)
        {
            sb.append(map[x][y]);
            // System.out.println(x+" "+y);
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
        int index = sb.length()-1;//가장 마지막으로 입력한
        boolean b = true;

        int i=1;
        while(sb.charAt(index-i)!='(')
        // for(int i=1;i<4;i++)
        {
            if(sb.charAt(index)!=sb.charAt(index-i))
            {
                b=false;
                break;//틀린게 있으면
            }
            i++;
        }
        if(b==true)
        {//다 같으면
            sb.delete(index-i,index);//같은거하나만 남기고 (랑 같이 지운다
        }
        else
            sb.append(")");        
    }
}