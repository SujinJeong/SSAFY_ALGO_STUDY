import java.util.*;
import java.io.*;

class Xt{
    int x;
    int t;
    public Xt(int x, int t)
    {
        this.x=x;
        this.t=t;
    }
}

class Main12851 {//숨바꼭질2
    static int min=Integer.MAX_VALUE;
    static int M;
    static int cnt;
    static boolean[] visited;
    static Queue<Xt> q;

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];

        q = new LinkedList<Xt>();
        int t=0;
        q.add(new Xt(N,t));
        
        while(q.size()>0)
        {
            Xt xt = q.poll();
            int x = xt.x;
            int time = xt.t;
            // System.out.println(x);

            if(x==M)
            {//동생만났으면
                if(min>=time)
                {//바꿔준다
                    min = time;
                }
                else//더 오래걸려서 만났으면 탈출
                    break;
                cnt++;//횟수
            }
            
            visited[x]=true;
            
            if(x-1>=0&& visited[x-1]==false)
            {
                q.add(new Xt(x-1,time+1));
            }
            
            if(x+1<=100000 && visited[x+1]==false)
            {
                q.add(new Xt(x+1,time+1));
            }
            
            if(x*2<=100000 && visited[x*2]==false)
            {
                q.add(new Xt(x*2,time+1));
            }        
        }

        System.out.println(min+"\n"+ cnt);
    }
}
//방문처리 해야하고->중요
//큐에넣고..