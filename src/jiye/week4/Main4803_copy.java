import java.util.*;
import java.io.*;
class Main4803_copy {//트리
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

            ArrayList<Integer>[] al = new ArrayList[n+1];
            for(int i=0;i<n+1;i++)
                al[i] = new ArrayList<Integer>();

            for(int i=0;i<m;i++)
            {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                al[a].add(b);
                al[b].add(a);//양쪽 다 넣어준다
            }

            if (m == n - 1)
            {//무조건 트리라고 한다..
                sb.append("Case "+T+": There is one tree.\n");
                T++;
                continue;//트리다
            }

            int count=0;
            boolean[] visited = new boolean[n+1];

            for(int start =1;start<n+1;start++)
            {//안본 노드들 시작으로 bfs.. 샹각보다 간단..
                if(visited[start]==true)
                    continue;

                boolean isCycle = false;

                // System.out.println("start --- "+start);
                Queue<Integer> q = new LinkedList<>();
                q.add(start);

                while(q.size()!=0)
                {
                    int node = q.poll();
                    // System.out.println(node);

                    if(visited[node]==true)
                    {//봤던 노드를 뺐다-> 연결 또했다..
                        //cycle에 속해있다는 뜻이다  start ~~ 다음 start까지 -> boolean으로 count할지 말지 결정
                        // System.out.println("cycle");
                        isCycle=true;
                        continue;
                    }
                    visited[node]=true;//빼면서 visited처리

                    for(int i=0;i<al[node].size();i++)
                    {
                        if(visited[al[node].get(i)]==false)
                            q.add(al[node].get(i));// 안본 자식들을 넣어준다
                    }
                }

                if(isCycle==false)
                    count++;
            }
            
            if(count==1)
                sb.append("Case "+T+": There is one tree.\n");
            else if(count==0)
                sb.append("Case "+T+": No trees.\n");
            else
                sb.append("Case "+T+": A forest of "+count+" trees.\n");
            T++;
        }

        System.out.print(sb);

    }
    
}
