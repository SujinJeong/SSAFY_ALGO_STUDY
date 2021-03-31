import java.util.*;
import java.io.*;
class Main1939{//중량제한
    static class Bridge{
        int s;
        int f;
        int w;
        public Bridge(int s, int f, int w)
        {
            this.s = s;
            this.f = f;
            this.w = w;
        }
    }
    static int[] parent;
    static int[] rank;
    static int start;
    static int finish;

    public static int getparent(int a)
    {
        if(a != parent[a])
            parent[a] = getparent(parent[a]);

        return parent[a];
    }

    public static void union(int a, int b,int w)
    {
        int pa = getparent(a);
        int pb = getparent(b);//부모

        if(pa==pb)
        {
            return;//이미 연결되어있음
        }
        
        //랭크(딸린 자식 수)큰거 의 부모와 같게
        //a가 작은거가 부모가 되게

        if(rank[pa] > rank[pb])
        {//rank큰거가 부모가 되게
            parent[pb] = pa;
            rank[pa]++;
        }
        else if(rank[pa] < rank[pb])
        {
            parent[pa] = pb;
            rank[pb]++;
        }
        else
        {//rank가 같으면
            if(pa<pb)
            {//작은번호가 부모가 되게
                parent[pb] = pa;
                rank[pa]++;
            }
            else
            {
                parent[pa] = pb;
                rank[pb]++;
            }
        }

//         System.out.println(a+" "+b+" "+w);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Bridge> pq = new PriorityQueue<>(new Comparator<Bridge>()
        {
            public int compare(Bridge b1, Bridge b2)
            {
                return (int)(b2.w - b1.w);
            }
        });//무게 큰 순서대로

        for(int i=0;i<M;i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());

            pq.add(new Bridge(a,b,c));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken())-1;//시작공장
        finish = Integer.parseInt(st.nextToken())-1;//끝공장

        parent = new int[N];
        for(int i=0;i<N;i++)
            parent[i] = i;//부모 자기자신으로 초기화

        rank = new int[N];//딸린 자식 개수

        while(pq.size()!=0)
        {//큰것부터 뽑는다
            Bridge bridge = pq.poll();
            int s = bridge.s;
            int f = bridge.f;
            int w = bridge.w;

            union(s, f, w);

            // System.out.println("parent "+Arrays.toString(parent));
            // System.out.println("rank "+Arrays.toString(rank));
            parent[start] = getparent(parent[start]);
            parent[finish] = getparent(parent[finish]);// 한번더올라가서 찐 부모를 찾아준다
            // System.out.println(parent[start]+" "+parent[finish]+" "+w+"  "+bool);
            
            if (parent[start] == parent[finish])
            {
                System.out.println(w);//연결되었을때의 값
                return;
            }
        }

        
        //크루스칼로 가장 큰 무게로 갈수있는 길 만드는데
        //여기서 공장 섬 연결되면 -> 그때의 값 = 중량제한 중에 최대값
    }
}
/*
7 11
1 2 2
1 3 3
1 4 10
2 3 3
2 7 7
3 5 6
3 6 3
3 7 4
4 5 1
5 6 23
6 7 9
2 5
*/