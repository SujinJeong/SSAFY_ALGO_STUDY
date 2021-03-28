import java.util.*;
import java.io.*;
class Main2098 {//외판원순회
    //시간초과 tsp공부하고 그다음에 비트마슼ㅇ
    static boolean[] visited;
    static int N;
    static int[][] W;
    static int min=987654321;
    static int start;
    static int cnt;
    static int sum;

    public static void func(int a)
    {
        if(sum>min)
            return;

        visited[a]=true;//바로 방문처리
        cnt++;

        for(int i=0;i<N;i++)
        {
            if(W[a][i]!=0)
            {//갈 수 있다면 
                if(visited[i]==false)
                {//안 거친 노드라면
                    sum+=W[a][i];
                    func(i);
                    sum-=W[a][i];
                   
                }
            }
        }
        // System.out.println("+"+Arrays.toString(visited));  
       
        if(cnt==N)
        {
            sum+=W[a][start];
        // System.out.println(a+" " +sum);

            if(min>sum)
                min = sum;
            sum-=W[a][start];
        } 
        cnt--;
        visited[a]=false;
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

        for(int i=0;i<N;i++)
        {
            visited = new boolean[N];

            start = i;
            sum=0;

            func(i);
        }
        System.out.println(min);
    }
}
