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

        int[] DP = new int[N+1];

        if(T[N]==1)//마지막날 일할수있따
            DP[N]=P[N];
        else
            DP[N]=0;

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
