import java.util.*;
import java.io.*;
class Child{
    int p;
    int w;
    public Child(int p, int w){
        this.p=p;
        this.w=w;
    }
}

class Main1967 {//트리의 지름 메모리 초과
    static int N;
    static ArrayList<ArrayList<Child>> al;
    static boolean[] visited;
    static int node1;
    static int sum;
    static int max;

    public static void find(int node,int weight)
    {
        if(visited[node]==true)
            return;

        boolean b= false;
        visited[node] = true;
        for(int i=0;i<al.get(node).size();i++)
        {
            if (visited[al.get(node).get(i).p] == false)
            {
                b=true;
                find(al.get(node).get(i).p,weight+al.get(node).get(i).w);//연결된노드로 내려감
            }
        }
        
        //갈게 더이상 없다-> 리프노드
        if(b==false)
        {
            if(max<weight)
            {
                max = weight;
                node1 = node;//끝난노드
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        visited = new boolean[N+1];
        al = new ArrayList<ArrayList<Child>>();
        for(int i=0;i<N+1;i++)
            al.add(new ArrayList<Child>());
        
        for(int i=0;i<N-1;i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());//부모
            int b = Integer.parseInt(st.nextToken());//자식
            int c = Integer.parseInt(st.nextToken());//가중치
            al.get(a).add(new Child(b,c));//자식에 부모,가중치 넣는다 부모는 1개
            al.get(b).add(new Child(a,c));
        }

//가장 먼것들이 원위에 있는 노드인게 핵심이라구..

        find(1,0);//아무노드에서 가장 먼거 찾는다

        max = 0;
        visited = new boolean[N+1];//초기화

        find(node1,0);//그 노드에서 가장 먼거 찾는다

        System.out.println(max);
    }
}
