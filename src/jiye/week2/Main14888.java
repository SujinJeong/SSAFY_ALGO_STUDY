import java.util.*;
import java.io.*;

class Main14888 {//연산자 끼워넣기
    static int N;
    static int[] arr;
    static int min=1000000000;
    static int max=-1000000000;

public static void func(int[] parr)
{
    int j=0;
    int c=arr[0];
    for(int i=0;i<parr.length;i++)
    {
        int a = c;
        int b = arr[j+1];
        switch(parr[i])
        {
            case 0:
                c=a+b;
            break;
            case 1:
                c=a-b;
            break;
            case 2:
                c=a*b;
            break;
            case 3:
                if(a<=0)
                {
                    a*=-1;
                    a/=b;
                    a*=-1;
                    c=a;
                }
                else
                    c=a/b;
            break;
        }
        j++;
        System.out.println(c);
    }
    if(c>max)
        max = c;
    if(c<min)
        min=c;
        System.out.println(max+" "+min);
}

public static void per(int i, int[] parr, int[] oper, boolean[] visited)
{
    if(i==N-1)
    {
        func(parr);
        System.out.println(Arrays.toString(parr));
        return;
    }
    for(int j=0;j<N-1;j++)
    {
        if (visited[j] == false) 
        {
            visited[j] = true;
            parr[i] = oper[j];
            per(i + 1, parr,oper, visited);
            visited[j] = false;
        }
    }

}

    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        int[] oper = new int[N-1];//연산자
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            arr[i]=Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int k=0;
        for(int i=0;i<4;i++)
        {
            int a=Integer.parseInt(st.nextToken());
            for(int j=0;j<a;j++)
            {
                oper[k]=i;//연산자 넣어줌
                k++;
            }
        }

        //연산자 순열 구해서 순열마다 계산한다
        //3 + 4 * 5
        //3 * 4 + 5
        //재귀로 훨씬 간단하게 할수있다
        //전역ㄱ변수로.. 배열을 인자로 두는건 좋지않다

        per(0,new int[N-1],oper,new boolean[N-1]);//연산자 순열
        System.out.println(max+"\n"+min);
    }
}
