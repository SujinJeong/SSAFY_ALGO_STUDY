import java.util.*;
import java.io.*;
class Main9663_copy {//N-Queen
    static int N;
    static int cnt;
    static int[] map;

    public static void func(int x)
    {//x번째 줄
        if(x>=N)
        {
            cnt++;
            return;
        }

        for(int i=0;i<N;i++)
        {
            if(map[i]==-1 && queen(x,i)==true)
            {//놓을 수 있으면
                map[i]=x;//놓고 x행i열
                func(x+1);//다음줄 본다
                map[i]=-1;
            }
        }
    }

    public static boolean queen(int x, int y)
    {//대각선 확인
        for(int i=0;i<N;i++)
        {
            if(map[i]!=-1)
            {//퀸이 있는 자리 중
                if(Math.abs(x-map[i])==Math.abs(i-y))
                    return false;
            }
        }

        return true;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N];//초기화

        for(int i=0;i<N;i++)
            map[i]=-1;
            
        func(0);
    
        
        System.out.println(cnt);
    }
}
