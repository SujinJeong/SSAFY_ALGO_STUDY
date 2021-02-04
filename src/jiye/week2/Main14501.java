import java.util.*;
import java.io.*;

class Main14501 {
    static int N;
    static ArrayList<Integer> arrrr=new ArrayList<>();
    static int[] tarr;
    static int[] parr;
    static int sum=0;
    static int max=0;
    public static void func(int a)
    {
        for(int i=a;i<N;i++)
        {
            if(i+tarr[i]<=N)
            {
                sum+=parr[i];
                func(i+tarr[i]);
                sum-=parr[i];
            }
            else
            {
                if (max < sum)
                    max = sum;
            }
        }
        if(max<sum)
            max=sum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        N = Integer.parseInt(br.readLine());
        tarr = new int[N];//걸리는 기간
        parr = new int[N];//금액
        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            tarr[n] = Integer.parseInt(st.nextToken());
            parr[n] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N;i++)
        {
            func(i);
        }
     
        answer=max;
        System.out.println(answer);
    }
}