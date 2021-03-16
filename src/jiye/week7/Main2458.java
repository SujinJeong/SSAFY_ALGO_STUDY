import java.util.*;
import java.io.*;
class Main2458 {//키순서
    //bfs도 가능하다
    //boolean[][] 으로도 할수있다...
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                map[i][j]=987654321;
            }
        }

        for(int i=0;i<M;i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            map[a][b]=1;//a<b  a->b
        }

        // for(int i=0;i<N;i++)
        // {//시작 노드
        //     for(int j=0;j<N;j++)
        //     {//끝 노드
        //         System.out.print(map[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        for(int k=0;k<N;k++)
        {//거쳐가는 노드
            for(int i=0;i<N;i++)
            {//시작 노드
                for(int j=0;j<N;j++)
                {//끝 노드
                    if(map[i][j] > map[i][k] + map[k][j])
                    {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                    //i->j로 갈때 몇번을 거쳐서 갈수있는지 저장됨
                    //값이 안바뀌는건 i->j로 못간다는 뜻
                }
            }
        }

        
        // for(int i=0;i<N;i++)
        // {//시작 노드
        //     for(int j=0;j<N;j++)
        //     {//끝 노드
        //         System.out.print(map[i][j]+"   ");
        //     }
        //     System.out.println();
        // }
        
        int answer=0;
        for(int i=0;i<N;i++)
        {
            boolean b= true;
            for(int j=0;j<N;j++)
            {
                if(i!=j && map[i][j]==987654321 && map[j][i]==987654321)
                {//i와 j를 비교할 수 없다는 뜻 자기자신 말고
                    b=false;
                    break;
                }
            }
            if(b==true)//모든 노드와 비교할 수 있다
                answer++;
        }
        System.out.println(answer);

    }
    
}
