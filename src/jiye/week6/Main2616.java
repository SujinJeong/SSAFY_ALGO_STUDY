import java.util.*;
import java.io.*;
class Main2616 {//소형기관차
    public static void main(String[] argse) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
        {
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int K =Integer.parseInt(br.readLine());//최대 객차 수

        int[] sum = new int[N-K+1];
        for(int k=0;k<K;k++)
            sum[0]+=arr[k];
        for(int i=1;i<N-K+1;i++)
        {
            sum[i]=sum[i-1]-arr[i-1]+arr[i+K-1];
        }

        int[][] DP = new int[4][N-K+1];
        DP[1][N-K]=sum[N-K];//맨 마지막값

        for(int n=N-K-1;n>=0;n--)
        {//n으로 시작
            DP[1][n] = Math.max(DP[1][n+1],sum[n]);//큰값으로 갱신
            for(int i=2;i<4;i++)
            {
                if(n+(i-1)*K < N-K+1)
                {//뒤에 더 볼 수 있으면
                    int temp=DP[i-1][n+K]+sum[n];//n포함 그전꺼 i-1개
                    DP[i][n]=Math.max(temp, DP[i][n+1]);// 끝~n 까지의 최대값
                }
                else
                {//뒤에 더 넣을 수 없으면
                    break;                    
                }
            }
        }

        // for(int j=0;j<4;j++)
        // {
        //     for(int i=N-K;i>=0;i--)
        //     {
        //         System.out.print(DP[j][i]+" ");
        //     }
        //     System.out.println();
        // }

        System.out.println(DP[3][0]);
    }
    
}
