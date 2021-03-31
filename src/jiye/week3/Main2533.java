import java.util.*;
import java.io.*;

class Main2533{//트리
    static int N;
    static int[][] DP;
    static ArrayList<Integer>[] al;
    static boolean[] visited;

    public static void func(int a, int parent)
    {
        DP[a][0]=0;
        DP[a][1]=1;//기본이 자신 1개
        
        visited[a]=true;
        
        for(int i=0;i<al[a].size();i++)
        {
            if(visited[al[a].get(i)]==false)
            {//방문안한 자식
                func(al[a].get(i),a);

                DP[a][0] += DP[al[a].get(i)][1];//자식은 1이어야 한다
                DP[a][1] += Math.min(DP[al[a].get(i)][1], DP[al[a].get(i)][0]);//뭐던 상관없다
                // System.out.println(al[a].get(i)+" .. "+a+" - "+DP[a][0]+" "+DP[a][1]);
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        al = new ArrayList[N+1];
        for(int i=0;i<N+1;i++)
            al[i] = new ArrayList<Integer>();

        for(int i=0;i<N-1;i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            al[a].add(b);
            al[b].add(a);
        }

        //부모가 얼리어답터 -> 자식은 상관없
        //부모가 얼리어답터x -> 자식 무조건 얼리어답터
        
        visited = new boolean[N+1];

        DP = new int[N+1][2];

        visited = new boolean[N+1];
        func(1,0);

        // for(int i=1;i<=N;i++)
        //     System.out.println(Arrays.toString(DP[i]));
        
        //1이 얼리어답터아닐때 vs 1이 얼리어답터일때
        System.out.println(Math.min(DP[1][0],DP[1][1]));
    }
}