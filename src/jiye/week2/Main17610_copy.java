import java.util.*;
import java.io.*;

class Main17610_copy {//양팔저울
    static Integer[] arr;
    static boolean[] barr;

    public static void func(int a, int weight)
    {
        if(a==arr.length)
        {
            if(weight>=0)
            {
                barr[weight]=true;
            // System.out.println(weight);
            }
            return;
        }
        //그릇 없는 쪽
        func(a+1, weight+ arr[a]);
        //그릇 있는 쪽
        func(a+1,weight-arr[a]);
        //안올려놓는다
        func(a+1,weight);
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

        barr = new boolean[sum+1];//잴 수 있는 추
        
        for(int i=0;i<N;i++)
        {
            func(i,0);
        }

        int cnt=0;
        for(int i=1;i<barr.length;i++)
        {
            if(barr[i]==false)
                cnt++;        
        }

        System.out.print(cnt);
    }
}
