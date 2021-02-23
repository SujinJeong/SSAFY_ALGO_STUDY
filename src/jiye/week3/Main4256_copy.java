import java.util.*;
import java.io.*;

class Main4256_copy {//트리
    static int[] pre;
    static int[] in;
    static int[] post;
    static int N;
    static int pre_index;
    static StringBuilder sb;

    public static void func(int start, int end)
    {
        if(pre_index>=N)
        return;
        
        int index=0;
        int pre_i = pre_index;
        for(int i=start;i<=end;i++)
        {
            if(in[i]==pre[pre_index])
            index=i;//루트 자른다
        }
        
        pre_index++;
        if (start <= index - 1)
            func(start,index-1);//앞

        if (index+1 <= end)
            func(index+1,end);//뒤

        sb.append(pre[pre_i]+" ");
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for(int t=0;t<T;t++)
        {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st;
            pre = new int[N];
            in = new int[N];
            post = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++)
            {
                pre[i]= Integer.parseInt(st.nextToken());//전위
            }
            
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++)
            {
                in[i] = Integer.parseInt(st.nextToken());//중위
            }
     
            pre_index=0;
            func(0,N-1);
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
