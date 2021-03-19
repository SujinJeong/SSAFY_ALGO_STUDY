import java.util.*;
import java.io.*;
class ominsik{
    int s;
    int f;
    long p;
    public ominsik(int s, int f, long p)
    {
        this.s=s;//s에서 왔다
        this.f=f;//f로
        this.p=p;//비용
    }
}
class Main1219_copy2 {
    static int N;
    static int start;
    static long[] map;
    static boolean[] visited;
    //9223372036854775807

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());//시작도시
        int finish = Integer.parseInt(st.nextToken());//도착도시
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][N];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
                arr[i][j]=-987654321;//갈수없으면 무한
        }
        ominsik[] road = new ominsik[M];
        for(int i=0;i<M;i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());//가는데 드는 비용
            arr[a][b] = Math.max(c*-1,arr[a][b]);//드는 돈이니까 음수 비용 적게 드는 걸로
            road[i] = new ominsik(a,b,c*-1);//간선
        }

        int[] price = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            price[i] = Integer.parseInt(st.nextToken());//버는 돈

        visited = new boolean[N];
        map = new long[N];
        for(int j=0;j<N;j++)
            map[j]=-987654321;//무한으로 초기화
        
        map[start]=price[start];

        boolean[] cycle = new boolean[N];
        for(int n=0;n<N+1;n++)
        {//N번 수행
            for(int i=0;i<M;i++)
            {//모든 길
                ominsik o = road[i];
                int s=o.s;
                int f =o.f;
                long p = o.p;

                if(map[s]!=-987654321 && map[f] < map[s]+p+price[f])
                {//map[s]!=-987654321 후.....
                    map[f] = map[s]+p+price[f];//갱신
                    if(n==N)
                    {
                        cycle[f]=true;
                        cycle[s]=true;//cylce애들
                    }
                }
                // System.out.println(Arrays.toString(map));
            }
            // System.out.println(n+"----------------");
        }//벨만포드

        StringBuilder sb = new StringBuilder();
        if(map[finish]==-987654321)//값이 안바뀌었으면 도착도시로 못가는것
            sb.append("gg");
        else
        {
            sb.append(map[finish]);

            for(int i=0;i<N;i++)
            {
                if(cycle[i]==true)
                {//사이클에 포함되는 애들이면
                    //그 도시에서 도착도시로 갈 수 있나 보기
                    Queue<Integer> q = new LinkedList<>();
                    visited = new boolean[N];
                    q.add(i);//
                    visited[i]=true;
                    while(q.size()!=0)
                    {
                        int d = q.poll();

                        if(d==finish)
                        {
                            System.out.println("Gee");
                            return;
                        }

                        // visited[d]=true;
                        for(int j=0;j<M;j++)
                        {
                            ominsik o = road[j];
                            if(o.s==d && visited[o.f]==false)
                            {//i에서 출발
                                visited[o.f]=true;
                                q.add(o.f);//다음도시
                            }
                        }
                    }
                }
            }
        }
        System.out.println(sb);
    }
    
}
