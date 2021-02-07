import java.util.*;
import java.io.*;
class Main2617 {
    static int N;
    static int M;
    // static ArrayList<ArrayList<Integer>> al;
    // static ArrayList<ArrayList<Integer>> al2;
    static StringBuilder al[];
    static StringBuilder al2[];
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

        visited = new boolean[N];
        visited2 = new boolean[N];
al = new StringBuilder[5];
        // al= new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<N;i++)
            al[i] = new StringBuilder(); 
            al2 = new StringBuilder[5];
            // al= new ArrayList<ArrayList<Integer>>();
            for(int i=0;i<N;i++)
                al2[i] = new StringBuilder();
       

        int answer=0;
        for(int i=0;i<N;i++)
        {//구슬i보다 무거운 구슬 찾기
            StringBuilder a = new StringBuilder();
            if(visited[i]==false)
                dfsbig( i,arr);
            StringBuilder b =new StringBuilder();
            if(visited2[i]==false)
                dfssmall( i,arr);
            System.out.println(al2[i].length()+"<"+i+"<"+al[i].length());
            if(al2[i].length()>N/2 ||al[i].length()>N/2)
                answer++;
        }

        // for(int i=0;i<N;i++)
        // {//구슬i보다 무거운 구슬 찾기
        //     if(visited[i]==false)
        //        {
        //             dfsbig( i,arr);
        //         }
        //     if(visited2[i]==false)
        //         dfssmall( i,arr);
        //     System.out.println(al2.get(i).size()+"<"+i+"<"+ al.get(i).size());
        //     if(al2.get(i).size()>N/2 || al.get(i).size()>N/2 )
        //         answer++;
        // }
        System.out.println(answer);
    }

    public static StringBuilder dfsbig(int i, int[][] arr)
    {
       
        for(int j=0;j<M;j++)
        {
            if(arr[j][1]==i)
            {//구슬j가 무거우면
                visited[arr[j][1]]=true;
                if(visited[arr[j][0]]==false)
                {
                    al[i].append(arr[j][0]);
                    al[i].append(dfsbig(arr[j][0],arr));
                }
                else
                al[i].append(al[arr[j][0]]);

            }
        }
        return al[i];
    }

    // public static StringBuilder dfsbig(StringBuilder str, int i, int[][] arr)
    // {
    //     if(str.length()>N/2)
    //         return str;
    //     for(int j=0;j<M;j++)
    //     {
    //         if(arr[j][1]==i)
    //         {//구슬j가 무거우면
    //             visited[arr[j][1]]=true;
    //             if(visited[arr[j][0]]==false)
    //             {
    //                 str.append(arr[j][0]);
    //                 str=dfsbig(str, arr[j][0],arr);
    //             }
                              
    //         }
    //     }
    //     return str;
    // }

    // public static StringBuilder dfssmall(StringBuilder str, int i, int[][] arr)
    // {
    //     if(str.length()>N/2)
    //         return str;
    //     for(int j=0;j<M;j++)
    //     {
    //         if(arr[j][0]==i)
    //         {//구슬j가 가벼우면
    //             visited2[arr[j][1]]=true;
    //             if(visited2[arr[j][0]]==false)
    //             {
    //                 str.append(arr[j][1]);
    //                 str=dfssmall(str, arr[j][1],arr);
    //             }
                              
    //         }
    //     }
    //     return str;
    // }

    public static StringBuilder dfssmall(int i, int[][] arr)
    {
       
        for(int j=0;j<M;j++)
        {
            if (arr[j][0] == i) 
            {// 구슬j가 가벼우면
                visited2[arr[j][1]] = true;
                if (visited2[arr[j][0]] == false) 
                {
                    al2[i].append(arr[j][1]);
                    al2[i].append(dfssmall(arr[j][1], arr));
                } 
                else
                    al2[i].append(al2[arr[j][1]]);
            }
        }
        return al2[i];
    }

}
