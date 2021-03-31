import java.util.*;
import java.io.*;
class Field{
    int s;
    int f;
    int dis;
    public Field(int s, int f,int dis){
        this.s = s;//s는 필요 없을것같다
        this.f = f;
        this.dis = dis;
    }
}
class Main14938 {//서강그라운드
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(i!=j)
                    map[i][j] = 987654321;
            }
        }
        for(int i=0;i<R;i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());
            map[a][b] = c;
            map[b][a] = c;
        }

        int max=0;
        for(int n=0;n<N;n++)
        {//출발점 바꿔가면서 다익스트라
            PriorityQueue<Field> pq = new PriorityQueue<>(new Comparator<Field>(){

                @Override
                public int compare(Field o1, Field o2) {
                    // TODO Auto-generated method stub
                    return o1.dis-o2.dis;
                }
            });
            int[] dist = new int[N];
            for(int i=0;i<N;i++)
                dist[i] = 987654321;
            dist[n]=0;//출발점

            boolean[] visited = new boolean[N];

            pq.add(new Field(-1,n,0));
            for(int i=0;i<N;i++)
            {
                if(i!=n)
                    pq.add(new Field(-1,i,987654321));//어디에서 왔는지, 도착 i, 거리..무한
            }

            while(pq.size()!=0)
            {
                Field F = pq.poll();
                int s = F.s;
                int f = F.f;
                int dis = F.dis;

                if(visited[f]==true)
                    continue;

                if(dis >= dist[f])
                {//같거나 크면
                    visited[f]=true;
                    dist[f] = dis;
                    
                    //인접한 곳 본다
                    for(int i=0;i<N;i++)
                    {
                        if(map[f][i]!=987654321)
                        {//갈수있는 곳이면
                            if(dist[i] > dis + map[f][i])
                            {//n->f + f->i가 n->i보다 작으면 갱신한다
                                dist[i] = dis+map[f][i];
                                pq.add(new Field(f,i,dist[i]));//큐에도 넣어준다
                            }
                        }
                    }
                }
            }
            
            int count=0;
            for(int i=0;i<N;i++)
            {
                if(dist[i] <= M)
                {//n->i거리 <= M 면 아이템수 더한다
                    count+=arr[i];
                }
            }
            // System.out.println(n+" "+Arrays.toString(dist)+"  "+count);
            
            if(count>max)
                max = count;//최대 아이템 개수
        }
        System.out.println(max);
    }
}
