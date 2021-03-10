import java.util.*;
import java.io.*;
class Main7453 {//합이 0인 네 정수

    public static void main(String[] argse) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        int[] C = new int[N];
        int[] D = new int[N];
        
        for(int i=0;i<N;i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i]=Integer.parseInt(st.nextToken());
            B[i]=Integer.parseInt(st.nextToken());
            C[i]=Integer.parseInt(st.nextToken());
            D[i]=Integer.parseInt(st.nextToken());
        }

        int[] AB = new int[N*N];
        int[] CD = new int[N*N];

        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                AB[i*N+j] = A[i]+B[j];
                CD[i*N+j] = C[i]+D[j];
            }
        }
        Arrays.sort(AB);
        Arrays.sort(CD);

        int s=0;
        int e=N*N-1;
        long sum=0;
        long count=0;

        while(s<N*N && e>=0)
        {
            sum=AB[s]+CD[e];
            
            if(sum>0)
            {
                sum-=CD[e];
                e--;
            }   
            else if(sum<0)
            {
                sum-=AB[s];
                s++;
            }
            else
            {//sum==0
                //같은 값이 있을 수도 있으니깐
                // System.out.println(s+" "+e+" "+AB[s]+" "+CD[e]);
                int i=0;//AB에서 같은값
                while(s+i<N*N && AB[s+i]==AB[s])
                {
                    i++;
                }
                int j=0;//CD에서 같은 값
                while(e-j>=0 && CD[e-j]==CD[e])
                {
                    j++;
                }
                s=s+i;
                e=e-j;
                count += (long)i*j;// ㅅㅂ
            }
        }

        System.out.println(count);
    }
    
}
