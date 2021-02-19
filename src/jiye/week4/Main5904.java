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
    {
        if(k==0)
        {
            if(n==0)
            {
                answer="m";
            }
            return;
        }

        if(n<map[k-1])
        {
            func2(k-1,n);
        }
        else if(n>=map[k-1] && n<map[k-1]+k+3)
        {//moooo구간
            if(n==map[k-1])
            {
                answer="m";
                return;
            }
            else
                return;
        }
        else
        {
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
        S(27);

        for(int k=0;k<28;k++)
        {//S(27)까지
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
