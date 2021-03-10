import java.util.*;
import java.io.*;
class Main15486 {//퇴사 2
    public static void main(String[] argse) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N+1];
        int[] P = new int[N+1];
        for(int i=1;i<N+1;i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i]=Integer.parseInt(st.nextToken());
            P[i]=Integer.parseInt(st.nextToken());
        }

        int[] DP = new int[N+1];//금액 합 저장

        if(T[N]==1)//마지막날 일할수있따
            DP[N]=P[N];
        else
            DP[N]=0;

        //       1  2  3  4  5  6  7  8  9  10  
        // T[i]  5  4  3  2  1  1  2  3  4  5
        // P[i]  50 40 30 20 10 10 20 30 40 50
        //
        //10일->1일로 가면서 i일에 시작했을때 가능한 최대 금액 구함
        //
        //일단 마지막날 10일에 일할수 없다 DP[10]=0
        //9일에도 일할수 없다  -> 10일부터 일한것과 같음
        //8일 8+3=11 일할수있다 -> 끝낸 다음날 11일에는 일x 
        //-> 8일에 일한것 vs 8일에 안하고 9일부터 일한것 중 최대
        //7일 7+2=9 일할수있다 -> 끝낸 다음날 9일에는 일x
        //...
        //6일 6+1=7 일할수있다 -> 끝낸 다음날 7일에도 일할수있다
        //-> 6일에 일한것 + 7일부터 일한것 vs 6일에 안하고 7일부터 일한것

        for(int i=N-1;i>0;i--)
        {
            if(i+T[i]<=N+1)
            {//i일에 일할 수 있다
                int date = i+T[i];//i일의 일을 끝낸 날
                int temp=0;
                if(date<=N)//date에 일을 시작할 수 있따
                    temp=DP[date]+P[i];//i일에 일하고 date에 일한것중에 최대
                else
                    temp=P[i];//i일에 일한것만
                DP[i] = Math.max(DP[i+1], temp);//i일 일x, i일에 일한거 중 최대
            }
            else
            {//일할 수 없다면
                DP[i] = 0 + DP[i+1];// 다음 날 기준 최대값 가져옴
            }
        }

        System.out.println(DP[1]);
    }
}
