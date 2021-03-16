import java.util.*;
import java.io.*;
class Road{
    int s;
    int e;
    int tt;
    public Road(int s, int e, int tt)
    {
        this.s=s;
        this.e=e;
        this.tt=tt;
    }
}

class Main1865{//웜홀

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N=Integer.parseInt(st.nextToken());//지점 개수
            int M=Integer.parseInt(st.nextToken());//도로 개수
            int W=Integer.parseInt(st.nextToken());//웜홀 개수

            Road[] road = new Road[M*2+W];//도로와 웜홀

            int index=0;
            for(int i=0;i<M;i++)
            {
                st = new StringTokenizer(br.readLine());
                int s=Integer.parseInt(st.nextToken())-1;
                int e=Integer.parseInt(st.nextToken())-1;
                int tt=Integer.parseInt(st.nextToken());
                road[index]=new Road(s,e,tt);
                index+=1;
                road[index]=new Road(e,s,tt);
                index+=1;
            }

            for(int i=0;i<W;i++)
            {
                st = new StringTokenizer(br.readLine());
                int s=Integer.parseInt(st.nextToken())-1;
                int e=Integer.parseInt(st.nextToken())-1;
                int tt=Integer.parseInt(st.nextToken());
                road[index]=new Road(s,e,tt*-1);//웜홀은 한 방향
                index+=1;
            }

            int[]map = new int[N];
            for(int i=1;i<N;i++)
                map[i] = 987654321;//시작점 뺴고 모두 무한대ㅠㅠ Integer.MAX_VALUE라 하면 틀리뮤ㅠㅠ

            for(int n=0;n<N-1;n++)
            {//N-1번 수행
                for(int i=0;i<road.length;i++)
                {
                    int s=road[i].s;
                    int e=road[i].e;
                    int tt=road[i].tt;

                    if(map[e] > map[s]+tt)
                    {//!=MAX_VALUE를 하면 음 단절된거 뒤에 사이클은 못본다
                        map[e] = map[s]+tt;//작은 값으로 갱신
                    }
                }

                // System.out.println(Arrays.toString(map));
            }

            boolean b=false;
            for(int i=0;i<road.length;i++)
            {
                int s=road[i].s;
                int e=road[i].e;
                int tt=road[i].tt;

                if(map[e]>map[s]+tt)
                {
                    b=true;//음의 사이클
                    break;
                }
            }
            if(b==false)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }
}