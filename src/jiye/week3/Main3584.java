import java.io.*;
import java.util.*;
 class Main3584 {//가장 가까운 공통 조상
    static int answer;
    static ArrayList<ArrayList<Integer>> al;
    static boolean[] visited;

    public static void find(int target)
    {
        if(al.get(target).size()==0)//더이상 부모가 없다 - 루트
            return;

        int a = al.get(target).get(0);//target의 부모
        visited[a] = true;//방문했던 노드들

        find(a);//target의 부모의 부모를 찾는다
    }

    public static void check(int target)
    {
        if(al.get(target).size()==0)
            return;

        int a = al.get(target).get(0);//target의 부모

        if(visited[a]==true)
        {//가장 먼저 겹치는 노드
            answer=a;
            return;
        }
        check(a);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++)
        {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st;
            al = new ArrayList<ArrayList<Integer>>();
            for(int i=0;i<=N;i++)
                al.add(new ArrayList<Integer>());

            for(int i=0;i<N-1;i++)
            {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());//부모
                int b = Integer.parseInt(st.nextToken());//자식
                al.get(b).add(a);//자식 arraylist에 부모 넣는다 부모는 1개
            }
            
            st = new StringTokenizer(br.readLine());
            int target1 = Integer.parseInt(st.nextToken());
            int target2 = Integer.parseInt(st.nextToken());

//al 자식  부모
//    1     3
//    2        --루트
//    3     2
//    4     3
//    5     1                              1 2 3 4 5
// target1 : 3   target2 : 5  |   visited  f f t f t        
// 3->2->x                    |   visited  f t t f t 
// 5->3               visited[3] true라서 탈출 


            visited = new boolean[N+1];
            visited[target1]=true;
            visited[target2]=true;//자기자신부터 true 

            find(target1);//target1의 조상을 끝까지 찾고

            check(target2);//가장 먼저 겹치는게 가장 가까운 공통조상

            System.out.println(answer);
        }
    }
    
}
