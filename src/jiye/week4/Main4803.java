import java.util.*;
import java.io.*;
class Main4803 {//트리
    static ArrayList<ArrayList<Integer>> al;
    static boolean[] visited;
    static boolean[] visitednow;
    static boolean[] isCycle;
    static ArrayList<Integer> cycle;
    static Queue<Integer> q;//자식들 넣을 q
    static boolean cycletrue;
    static int tree;

    public static void Cycle(int a)
    {
        boolean b= true;
        if(visitednow[a]==true)
        {//이번 사이클에서 봤다
            // System.out.println("Cycle"+cycle.toString());
            // for(int i=0;i<cycle.size();i++)
            // {
            //     isCycle[cycle.get(i)]=true;//얘네들 사이클이다
            //     visited[cycle.get(i)]=true;
            // }
            cycletrue=true;
            return;
        }

        visitednow[a]=true;
        cycle.add(a);

        for(int i=0;i<al.get(a).size();i++)
        {//연결된 것으로 간다
            if(visitednow[al.get(a).get(i)]==false)
            {
                b=false;
                q.add(al.get(a).get(i));//자식들 다 넣어
            }
        }

        if(b==true && q.size()==0)
        {//리프노드
            tree++;
        }
    }

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=1;
        StringBuilder sb = new StringBuilder();

        while(true)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(n==0&&m==0)
                break;//입력 끝

            visited = new boolean[n+1];
            visitednow = new boolean[n+1];
            isCycle = new boolean[n+1];

            al = new ArrayList<ArrayList<Integer>>();
            for(int i=0;i<=n;i++)
                al.add(new ArrayList<Integer>());

            for(int i=0;i<m;i++)
            {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(a!=b)
                {
                    al.get(a).add(b);
                    al.get(b).add(a);
                }
                else
                {
                    isCycle[a]=true;
                    visited[a]=true;
                }
            }

            //시작노드를 모르니까 1부터 n까지 쭉 bfs
            //방문하지 않은 노드면 큐에 넣는다
            //만약 이번에 방문한 노드라면 (visitednow[i]) 사이클 -> cycletrue = true
            //자식노드까지 왔고 큐에 든게 없으면 시작한 트리 끝-> tree+!
            //끝났을때 cycletrue보고 다 사이클로 변환
            //아 저기서 잘못됐나 tree+1
            //사이클이 아니면 트리+1로?


            int island=0;
            tree=0;

            q = new LinkedList<>();
            for(int i=1;i<=n;i++)
            {
                cycle = new ArrayList<Integer>();//사이클을 담을 배열
                cycletrue=false;
                visitednow = new boolean[n+1];//이번에 방문했는지 확인

                if(visited[i]==false)//새로 봐야할 노드
                {
                    if(al.get(i).size()==0)
                    {//연결된 노드가 없다->섬
                        // System.out.println("섬"+i);
                        island++;
                        continue;
                    }
                    q.add(i);//한번도 본적 없으면 넣고
                }
              
                while(q.size()!=0)
                {
                    int a= q.poll();

                    if(visited[a]==false)
                    {//한번도 본적 없는 노드
                        System.out.print(a+" -> ");
                        Cycle(a);
                    }
                    else
                    {//확인했던 노드
                        if(isCycle[a]==true)
                        {//그 확인했던 노드가 사이클
                            for(int c=0;c<cycle.size();c++)
                            {
                                isCycle[cycle.get(c)]=true;//얘네들 사이클이다
                                visited[cycle.get(c)]=true;
                            }
                        }
                        break;
                    }
                }//i 연결된거다 돌고나면 visitednow만 방문처리 됨

                if(cycletrue==true)
                {//사이클이 있었으면
                    for(int c=0;c<cycle.size();c++)
                    {
                        isCycle[cycle.get(c)]=true;
                        visited[cycle.get(c)]=true;
                    }
                }

                for(int j=0;j<visitednow.length;j++)
                {
                    if(visitednow[j]==true)
                        visited[j]=true;//얘도 true로 바꿔줌
                }
            }

            
            int cnt=0;
            for(int i=1;i<isCycle.length;i++)
            {
                if(isCycle[i]==true)
                    cnt++;
            }
            if(cnt==n || island+tree==0)
                sb.append("Case "+T+": No trees.\n");
            else
            {
                if(island+tree==1)
                    sb.append("Case "+T+": There is one tree.\n");
                else
                    sb.append("Case "+T+": A forest of "+(tree+island)+" trees.\n");
            }
            T++;
        }

        System.out.print(sb);

    }
    
}
