import java.util.*;
import java.io.*;
class Main2098_copy {//외판원순회
    static boolean[] visited;
    static int N;
    static int[][] W;
    static int[][] DP;

    public static void func(int a, int status)
    {
        if(status == (1<<N)-1)
        {
            System.out.println(a+"로 끝 "+status);
            return;
        }

        for(int j=1;j<N;j++)
        {//안갔던 도시로 간다
            if(status < (status ^ (1<<(N-1-j))) && W[a][j]!=0)
            {//a->j길도 있어야 함
                int temp =  DP[status][a] + W[a][j];//현재 거친거 a + a->j

                if(DP[status ^ (1<<(N-1-j))][j]!=987654321)
                    return;
                    
                DP[status ^ (1<<(N-1-j))][j] = Math.min(DP[status ^ (1<<(N-1-j))][j],temp);
                System.out.println(status+" "+j+" "+(status ^ (1<<(N-1-j))));
                // status = (status ^ (1<<(N-1-j)));
                func(j,(status ^ (1<<(N-1-j))));
            }
        }

    }
    
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        W = new int[N][N];
        for(int i=0;i<N;i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++)
                W[i][j] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[N];

        DP = new int[1<<N][N];//어떤 노드를 거쳐서 왔는지/ 지금도착한노드
        for(int i=1;i<(1<<N);i++)
        {
            for(int j=0;j<N;j++)
            {
                if(i!=1<<(N-1-j))
                    DP[i][j]=987654321;
            }
        }
        //시작점 0
        //a에서 출발 1000 a
        //1100 b = 1000 a + a->b

        int status = 1<<(N-1);
        // System.out.println(status);
        // for(int i=0;i<N;i++)
        // {
        //     for(int j=0;j<N;j++)
        //     {
        //         System.out.println(i+","+j+"  "+status+ " -- "+(status ^ (1<<(N-1-j))));
        //         DP[status ^ (1<<(N-1-j))][j] = Math.min(DP[status ^ (1<<(N-1-j))][j], DP[status][i] + W[i][j]);
        //     }
        //     status = status^(1<<N-1-i);
        //     System.out.println();
        // }

        for(int i=0;i<1;i++)
        {
            func(i,status);
        }

        int min = 987654321;
        for(int i=1;i<N;i++)
        {//도착도시
            int temp = W[i][0] + DP[(1<<N)-1][i];
            // System.out.println(temp+" "+ DP[(1<<N)-1][i]);
            if(min > temp)
                min = temp;
        }
        // for(int i=0;i<(1<<N);i++)
        // {
        //     for(int j=0;j<N;j++)
        //     {
        //         System.out.print(DP[i][j]+ " ");
        //     }
        //     System.out.println();
        // }
        System.out.println(min);
    }
}
