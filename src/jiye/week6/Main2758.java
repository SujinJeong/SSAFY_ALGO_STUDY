import java.util.*;
import java.io.*;
class Main2758 {//로또
    public static void main(String[] argse) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++)
        {        
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N=Integer.parseInt(st.nextToken());//N개
            int M=Integer.parseInt(st.nextToken());//M까지

            long[][] DP = new long[N+1][M+1];//숫자가 크다

            for(int m=1;m<=M;m++)
            {//m부터
                DP[1][m]=m;//m개 경우
                for(int n=2;n<=N;n++)
                {//n개 뽑는다
                    DP[n][m] = DP[n - 1][m / 2] + DP[n][m - 1];//그 전칸 + 옆칸
                }
            }

            // for(int n=1;n<=N;n++)
            // {
            // for(int m=0;m<=M;m++)
            // {//m부터
            //         System.out.print(DP[n][m]+" ");
            //     }
            //     System.out.println();
            // }
          

            System.out.println(DP[N][M]);
        }
    }
}
