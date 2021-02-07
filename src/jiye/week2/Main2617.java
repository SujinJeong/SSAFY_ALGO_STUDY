import java.util.*;
import java.io.*;
class Main2617 {
    static int N;
    static int M;
    static boolean[] visited;
    static boolean[] visited2;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[M][2];
        
        for(int i = 0;i< M;i++)
        {
            st = new StringTokenizer(br.readLine());
            arr[i][0]=Integer.parseInt(st.nextToken())-1;
            arr[i][1]=Integer.parseInt(st.nextToken())-1;
        }

        
        
        int answer=0;
        for(int i=0;i<N;i++)
        {//구슬i보다 무거운 구슬 찾기
            
            visited = new boolean[N];
            visited2 = new boolean[N];
            ArrayList<Integer> al = new ArrayList<Integer>();
            dfsbig(al, i,arr);
            ArrayList<Integer> al2 = new ArrayList<Integer>();

            dfssmall(al2, i,arr);

            System.out.println(al2.size()+"<"+i+"<"+al.size());

            if(al2.size()>N/2 ||al.size()>N/2)
                answer++;
        }

        System.out.println(answer);
    }

    public static void dfsbig(ArrayList<Integer> al, int i, int[][] arr)
    {
       visited[i]=true;
        for(int j=0;j<M;j++)
        {
            if (arr[j][1] == i && visited[arr[j][0]] == false)            
            {//구슬arr[j][0]가 무거우면
                al.add(arr[j][0]);
                dfsbig(al,arr[j][0],arr);
            }
        }
    }
    public static void dfssmall(ArrayList<Integer> al, int i, int[][] arr)
    {
       visited2[i]=true;
        for(int j=0;j<M;j++)
        {
            if (arr[j][0] == i && visited2[arr[j][1]] == false)            
            {//구슬arr[j][0]가 무거우면
                al.add(arr[j][1]);
                dfssmall(al,arr[j][1],arr);
            }
        }
    }

}
