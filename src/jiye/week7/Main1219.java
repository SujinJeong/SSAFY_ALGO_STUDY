import java.util.*;
import java.io.*;

class Main1219 {//오민식의 고민
    static int N;
    static int start;
    static long[] map;
    static boolean[] visited;
    //9223372036854775807

    public static int find()
    {//map에서 가장 작은 값 찾는다
        long max=Long.MIN_VALUE;
        int index=0;
        for(int i=0;i<N;i++)
        {
            if(map[i]>-987654321 && max < map[i] && visited[i]==false)
            {//최소값 찾음 방문하지 않은 도시
                max=map[i];
                index = i;
            }
        }
        visited[index]=true;
        return index;//가장 작은 값이 있는 인덱스 반환
    }
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
        for(int i=0;i<M;i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());//가는데 드는 비용
            arr[a][b] = Math.max(c*-1,arr[a][b]);//드는 돈이니까 음수 비용 적게 드는 걸로
            c = arr[a][b];
        }

        int[] price = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            price[i] = Integer.parseInt(st.nextToken());//버는 돈

        visited = new boolean[N];
        map = new long[N];
        for(int j=0;j<N;j++)
            map[j]=-987654321;//갈수없으면 무한
        for(int i=0;i<N;i++)
        {
            if(arr[start][i] > -987654321)
                map[i] = arr[start][i]+price[i];//시작에서 -비용 + 버는 돈
        }
        map[start]=price[start];
        // visited[start]=true;
        
        System.out.println(Arrays.toString(map));
        int last=0;
        for(int n=0;n<=N-1;n++)
        {//n-1번 수행
            int next = find();//안본 도시중에 가장 작은 값

            for(int i=0;i<N;i++)
            {
                if(arr[next][i]<=-987654321)
                    continue;//못가는 길
                long temp = map[next] + ( arr[next][i] + price[i] );//next를 거쳐서 간것
                if(map[i] < temp)//더 큰 비용
                {
                    map[i] = temp;
                    last=i;
                }
            }
            System.out.println(next+" "+Arrays.toString(map));
        }

        StringBuilder sb = new StringBuilder();
        if(map[finish]==-987654321)
            sb.append("gg");
        else
        {
            sb.append(map[finish]);

            int next=last;//아무 도시
            for(int i=0;i<N;i++)
            {
                if(arr[next][i]<=-987654321)
                    continue;
                long temp = map[next] + arr[next][i] + price[i];//next를 거쳐서 간것
                if(map[i] < temp)
                {
                    map[i] = temp;
                    System.out.println("Gee");
        // System.out.println(Arrays.toString(map));

                    return;
                }
            }
        }
        System.out.println(sb);
    }
    
}
