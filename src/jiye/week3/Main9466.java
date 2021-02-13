import java.util.*;
import java.io.*;
class Main9466 {//텀프로젝트
    static int N;
    static int[] arr;
    static boolean[] visited;
    static boolean[] visited2;
    static ArrayList<Integer> al;
    static int cnt;

    public static void func(int i)
    {
        if(visited[i]==true)
        {//거쳤던 i다
            return;
        }

        // System.out.println(i);
        al.add(i);
        visited[i]=true;//이번에 거치는 것
        
        if(visited[arr[i]]==false)
            func(arr[i]);//가리키는 것으로
        else
        {//arr[i]가 거쳐왔던 노드면
            if(visited2[arr[i]]==false)
            {//이전에 거쳤던게 아니고 이번에 거친거면
                for(int j=al.size()-1;j>=0;j--)
                {
                    if(al.get(j)==arr[i])
                    {//몇전꺼까지 포함하는지 센다
                        cnt++;
                        break;
                    }
                    cnt++;
                }
                // System.out.println("["+cnt);
            }
        }
        
        visited2[i]=true;//돌던거 탈출하고 거쳤다고 저장
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++)
        {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr = new int[N+1];
            visited = new boolean[N+1];
            visited2 = new boolean[N+1];
            cnt=0;
            for(int i=1;i<N+1;i++)
            {
                arr[i]= Integer.parseInt(st.nextToken());
                // if(arr[i]==i)
                    // visited[i]=true;
            }

            for(int i=1;i<N+1;i++)
            {
                al = new ArrayList<Integer>();
                func(i);
            }

            System.out.println(N-cnt);
        }
    }
    
}
