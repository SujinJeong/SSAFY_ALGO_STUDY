import java.util.*;
import java.io.*;

class Main17610 {//양팔저울
    //시간초과...
    static Integer[] arr;
    static boolean[] barr;
    public static void func(int[] per, int[] cal, int N)
    {
            int sum = per[0];
            for(int i=1, j=0;i<per.length && j<cal.length;i++,j++)
            {
                int c = sum;
                int b=per[i];

                if(cal[j]==1)
                    sum=c+b;
                else
                    sum=c-b;
            }
            if(sum>0)
                barr[sum]=true;
            System.out.println(sum);
    }

    public static void permi(int[] per, int index, int N, boolean[] visited)
    {//N개 순열
        if(index==N)
        {
            System.out.println(Arrays.toString(per)+" ");
            cal(per,N-1,0,new int[N-1]);
            return;
        }
        for(int i=0;i<arr.length;i++)
        {
            if(visited[i]==false)
            {
                visited[i]=true;
                per[index]=arr[i];
                permi(per,index+1,N,visited);
                visited[i]=false;
            }
            
        }
    }

    // public static void combi(int[] com, int index, int a,int N)
    // {//N개 조합
    //     if(index==N)
    //     {
    //         System.out.println(Arrays.toString(com)+" ");
    //         cal(com,N-1,0,new int[N-1]);
    //         return;
    //     }
    //     for(int i=a;i<arr.length;i++)
    //     {
    //         com[index]=arr[i];
    //         combi(com,index+1,i+1,N);
    //     }
    // }

    public static void cal(int[] per, int N,int i,int[] arr)
    {//N개 연산 조합
        if(i==arr.length)
        {
            System.out.print(Arrays.toString(arr)+ ", ");
            func(per,arr,N);//연산
            return;
        }
        for(int j=0;j<2;j++)
        {
            arr[i]=j;
            cal(per,N,i+1,arr);
        }
    }
    
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr =new Integer[N];
        int sum=0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
            sum+=arr[i];
        }

        barr = new boolean[sum+1];
        barr[0]=true;
        for(int i=0;i<N;i++)
            barr[arr[i]]=true;
        
        for(int i=2;i<=N;i++)
        {//i개의 추를 이용 
            permi(new int[i],0,i, new boolean[N]);
        }

        int cnt=0;
        for(int i=0;i<barr.length;i++)
        {
            if(barr[i]==false)
                cnt++;        
        }

        System.out.print(cnt);
    }
}
