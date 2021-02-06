import java.util.*;
import java.io.*;

class Main15686 {
    static int M;
    static int MIN=1000000000;//min 잘잡자
    static ArrayList<int[]> arrh;
    static ArrayList<int[]> arrc;

    public static void count(int[] combi)
    {
        int sum=0;
        for(int i=0;i<arrh.size();i++)
        {//모든 집들
            int min = 100;
            for(int j=0;j<combi.length;j++)
            {
                int a = Math.abs(arrh.get(i)[0] - arrc.get(combi[j])[0]) + Math.abs(arrh.get(i)[1] - arrc.get(combi[j])[1]);
                if(a<min)
                    min =a;//치킨거리
            }
            // System.out.println(min);
            sum+=min;
        }
        if(sum<MIN)
            MIN=sum;
        // System.out.println(sum);
    }

    public static void func(int a,int n,int c,int[] combi)
    {
        if(n==M)
        {
            System.out.println(Arrays.toString(combi));
            count(combi);
            //그 조합 치킨집들 치킨거리
           
            return;
        }
        for(int i=a;i<c;i++)
        {
            combi[n]=i;
            func(i+1,n+1,c,combi);
        }
    }
	
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arrc = new ArrayList<int[]>();//치킨집
        arrh = new ArrayList<int[]>();//집

        for(int i=0;i<N;i++)
        {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++)
            {
                int m=Integer.parseInt(st1.nextToken());
                if(m==2)
                {
                    int[] a = {i,j};
                    arrc.add(a);
                }
                if(m==1)
                {
                    int[] a = {i,j};
                    arrh.add(a); 
                }
            }
        }

        // for(int i=0;i<arrc.size();i++)//총 치킨집 수
        // {
        //     int[] combi= new int[M];//M개조합
        //     combi[0]=i;
        //     func(i,1,arrc.size(),combi);
        // }
     

        func(0,0,arrc.size(),new int[M]);
            System.out.println(MIN);
    }
}
