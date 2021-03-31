import java.util.*;
import java.io.*;
class Bus{
    int s;
    int f;
    int time;
    public Bus(int s,int f, int time)
    {
        this.s = s;
        this.f = f;
        this.time = time;
    }
}

class Main11657 {//타임머신
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Bus[] bus = new Bus[M];
        for(int i=0;i<M;i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());

            bus[i] = new Bus(a,b,c);
        }

        long[] map = new long[N];
        for(int i=1;i<N;i++)
            map[i] = 987654321;//출발 뺴고

        for(int n=0;n<N;n++)
        {//N-1번 수행 그리고 마지막 한번 --벨만포드
            boolean bool=false;
            for(int m=0;m<M;m++)
            {
                Bus b = bus[m];
                int s = b.s;
                int f = b.f;
                int t = b.time;

                //0->s가 안되는데 갱신되면 음 출발도시에서 못가는곳에서 사이클
                if(map[s]!=987654321 && map[f] > map[s] +t)
                {//0->f  0->s + s->f
                    map[f] = map[s] + t;
                    bool=true;
                }
            }

            if(n==N-1)
            {//음의사이클
                if(bool==true)
                {
                    System.out.println("-1");
                    return;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<N;i++)
        {
            if(map[i]==987654321)
                sb.append("-1\n");//가는 경로가 없다
            else
                sb.append(map[i]+"\n");
        }
        
        System.out.println(sb);
    }    
}
