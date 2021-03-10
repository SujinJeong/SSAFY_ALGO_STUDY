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
        }//i번 객차부터 K개 객차에 타고있는 손님 수 합


        // i  0  1  2  3  4  5  6     N=7 K=2
        //arr 35 40 50 10 30 45 60
        //sum 75 90 60 40 75 105   -> N-K+1개

        //DP[i개 골랐다][n번 부터] 최대 손님수
        //1. DP[i][n+1] n+1번부터 i개 골랐을때 최대손님수
        //2. n번기차 고르고 그 뒤에 고를 수 있는 (n+K)번 부터 i-1개 골랐을 때
        //둘중 최대

        //5번부터 1개 -> sum[5] = 105
        //4번부터 1개 -> sum[4] vs sum[5] = 105
        //4번부터 2개 불가능 = 0
        //3번부터 1개 -> sum[3] vs sum[4] = 105
        //3번부터 2개 -> sum[3]+5번부터 1개 vs 4번부터 2개
        //...
        

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
