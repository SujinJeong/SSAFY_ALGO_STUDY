import java.util.*;
import java.io.*;

class Main5904 {//moo게임
    static int N;
    static String answer;
    static int[] map;

    public static int S(int k)
    {
        if(k==0)
        return 3;    
        
        int a= 2*S(k-1) + k+3;//길이
        map[k]=a;
        // System.out.println(a);
        return a;//s(k-1) + m과 k+2 + s(k-1)
    }
    
    public static void func2(int k,int n)
    {//n은 인덱스
        if(k==0)
        {
            if(n==0)
            {//맨 앞만 m이다
                answer="m";
            }
            return;
        }

        if(n<map[k-1])
        {//s(k-1)
            func2(k-1,n);
        }
        else if(n>=map[k-1] && n<map[k-1]+k+3)
        {//moooo구간 m과 k+2
            if(n==map[k-1])
            {//맨앞만 m이다
                answer="m";
                return;
            }
            else
                return;
        }
        else
        {//s(k-1)
            func2(k-1,n-(map[k-1]+k+3));
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine())-1;//N-1번째 글자

        answer ="o";
        if(N==0)
        {
            System.out.println("m");
            return;
        }

        map = new int[28];
        map[0]=3;
        S(27);//S(27)까지 map에 저장한다

        //s(k) = 2*s(k-1) + k+3
        //   s(1)   m과 k+2  s(1)
        //moomooomoo moooo moomooomoo
        //인덱스가
        //0 ~ s(k-1)-1   s(k-1)구간
        //s(k-1) ~ s(k-1)+k+2이 m과 k+2 구간
        //s(k-1)+k+3 ~  s(k-1)구간
        //s(0)이 될때까지 재귀 -> 인덱스 위치로 m o 구분

        for(int k=0;k<28;k++)
        {
            // System.out.println(k+" "+map[k]);
            if(N==map[k])
            {
                answer="m";
                break;
            }
            if(N<map[k])
            {
                func2(k,N);
                // System.out.println(map[k]);
                break;
            }
            
        }
        System.out.println(answer);
    }

}
