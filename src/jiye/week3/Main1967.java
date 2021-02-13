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
    static Child[] al;
    static boolean[] visited;
    static int[] child;
    static Child[] weight;
    static int sum;
    static int max;

    public static void combi(int index, int a, int[] arr)
    {
        if(index==2)
        {
            System.out.println(Arrays.toString(arr));
            visited = new boolean[N+1];
            weight = new Child[N];
            weight[0] = new Child(arr[0],0);
            sum=0;
            find(arr[0],1);
            // System.out.println(Arrays.toString(weight));
            cal(arr[1]);
            return;
        }
        for(int j=a;j<child.length;j++)
        {
            arr[index]=child[j];
            combi(index+1,j+1,arr);
        }
    }

    public static void find(int target,int i)
    {
        if(target==1)
            return;//더이상 부모가 없다

        Child c = al[target];
        visited[c.p]=true;//방문한 부모 true로 바꿈
        weight[i] = new Child(c.p,weight[i-1].w+c.w);//그전꺼 다 더한거
        find(c.p,i+1);        
    }

    public static void cal(int target)
    {
        if(target==1)
            return;
        
        Child c = al[target];
        sum+=c.w;//이쪽줄
        if(visited[c.p]==true)//공통조상
        {
            for(int i=0;i<weight.length;i++)
            {
                Child cc = weight[i];
                if(cc.p==c.p)
                {
                    sum+=cc.w;//저쪽줄
                    break;
                }
            }

            System.out.println(sum);
            if(sum>max)
                max = sum;
            return;
        }
        
        cal(c.p);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        al = new Child[N+1];

        boolean[] parent = new boolean[N+1];//부모들
        int count = 0;//부모개수
        parent[0]=true;
        
        for(int i=0;i<N-1;i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());//부모
            int b = Integer.parseInt(st.nextToken());//자식
            int c = Integer.parseInt(st.nextToken());//가중치
            al[b] = (new Child(a,c));//자식에 부모,가중치 넣는다 부모는 1개
            if(parent[a]==false)
            {
                parent[a]=true;
                count++;
            }
        }

        child = new int[N-count];
        int j=0;
        for(int i=1;i<N+1;i++)
        {
            if(parent[i]==false)//부모에 없는게 마지막노드
            {
                child[j]=i;
                j++;
            }
        }

        combi(0,0,new int[2]);

        System.out.println(max);
    }
}
