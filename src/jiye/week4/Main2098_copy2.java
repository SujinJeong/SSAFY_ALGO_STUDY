import java.util.*;
import java.io.*;
class Main2098_copy2 {//외판원순회
    static int N;
    static int[][] W;
    static int[][] DP;

    public static int func(int a, int status)
    {
        // System.out.println(a +" "+(status));
        if(status == (1<<N)-1)
        {//다 봤으면 1111
            if(W[a][0]!=0)
                return W[a][0];//끝났으면 a->0을 반환
            return 987654321;//못가면 큰거 반환해서
        }

        if(DP[status][a]!=987654321)
            return DP[status][a];

        for(int j=0;j<N;j++)
        {//노드 중에
            if(W[a][j]!=0 && (status ^ (1<<(N-1-j))) > status)
            {//j로 갈수있고 안가본곳
                int temp = func(j,(status ^ (1<<(N-1-j)))) + W[a][j];//~j + a->j
                DP[status][a] = Math.min(DP[status][a],temp);
            }
        }

        //1000 A에 A로 시작해서 가장 작은 비용 담기고
        //^--- 1100 B에 여기서 또 가장 작은 비용 담기고    <-1110 C  <-- 1111 D
        //                                               <-1101 D  <-- 1111 C  
        //                                       A->B       (B->D       (D->C   (C->A))) 
        //                temp =                W[a][b]    W[b][d]     W[d][c]  return W[][0]
        //^--- 1010 C에 여기서 또 가장 작은 비용 담기고    <-1110 B  <-- 1111 D 
        //^--- 1001 D에 여기서 또 가장 작은 비용 담기고    <-1101 B  <-- 1111 C...emdemd 

        return DP[status][a];//a로 끝나는 status 
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

        DP = new int[1<<N][N];//어떤 노드를 거쳐서 왔는지/ 지금도착한노드
        for(int i=0;i<(1<<N);i++)
        {
            for(int j=0;j<N;j++)
            {
                // if(i!=1<<(N-1-j))
                    DP[i][j]=987654321;//다 이걸로 해야 Math.min으로 바뀜
            }
        }
        //시작점 0
        //a에서 출발 1000 a
        //1100 b = 1000 a + a->b
        //1110 c = 1100 b + b->c
        //1101 d = 1100 b + b->d

        int status = 1<<(N-1);//A 1000
        int aaa = func(0,status);

        // for(int i=0;i<(1<<N);i++)
        // {
        //     for(int j=0;j<N;j++)
        //     {
        //         System.out.print(DP[i][j]+ " ");
        //     }
        //     System.out.println();
        // }
        System.out.println(aaa);
    }
}
