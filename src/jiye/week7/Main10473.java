import java.util.*;
import java.io.*;
class Main10473 {//인간 대포
    static int N;
    static boolean[] visited;
    static double[][] map;

    public static int find()
    {
        int index=0;
        double min=987654321;

        for(int i=1;i<N+2;i++)
        {
            if(visited[i]==false)
            {
                if(min>map[0][i])
                {
                    min = map[0][i];
                    index = i;
                }
            }
        }

        return index;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double start_x = Double.parseDouble(st.nextToken());
        double start_y = Double.parseDouble(st.nextToken());

        st = new StringTokenizer(br.readLine());
        double finish_x = Double.parseDouble(st.nextToken());
        double finish_y = Double.parseDouble(st.nextToken());

        N = Integer.parseInt(br.readLine());
        double[][] arr = new double[N+2][2];
        for(int i=1;i<=N;i++)
        {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Double.parseDouble(st.nextToken());
            arr[i][1] = Double.parseDouble(st.nextToken());
        }
        arr[0][0] = start_x;
        arr[0][1] = start_y;
        arr[N+1][0] = finish_x;
        arr[N+1][1] = finish_y;

        map = new double[N+2][N+2];//걸린 시간 저장
        for(int i=0;i<N+2;i++)
        {//대포들
            double x2 = (arr[0][0]-arr[i][0])*(arr[0][0]-arr[i][0]);
            double y2 = (arr[0][1]-arr[i][1])*(arr[0][1]-arr[i][1]);
            map[0][i] = Math.sqrt(x2+y2)/5.0;//시작점에서 대포까지의 거리 / 속도
            map[i][0] = map[0][i];

            // x2 = (arr[N+1][0]-arr[i][0])*(arr[N+1][0]-arr[i][0]);
            // y2 = (arr[N+1][1]-arr[i][1])*(arr[N+1][1]-arr[i][1]);
            // map[N+1][i] = Math.sqrt(x2+y2)/5.0;//시작점에서 대포까지의 거리
            // map[i][N+1] = map[N+1][i];
        }

        for(int i=1;i<N+2;i++)
        {
            for(int j=1;j<N+2;j++)
            {
                double x2 = (arr[j][0]-arr[i][0])*(arr[j][0]-arr[i][0]);
                double y2 = (arr[j][1]-arr[i][1])*(arr[j][1]-arr[i][1]);
                double dist = Math.sqrt(x2+y2);//대포와 대포 사이 거리\
                // System.out.println(i+" "+j+" "+arr[i][0]+" "+arr[j][0]+" "+x2+" "+y2+"   "+dist);
                double d = 0;
                if(dist<50)
                {
                    d = Math.min(dist/5.0, 2+(50-dist)/5.0);//걸어간 시간 vs 대포타고 날아갔다가 되돌아 걸어
                }
                else
                    d=(dist-50)/5.0 + 2;//대포타고 날아갔다가 남은거리 걸어감
                map[j][i] = d;//시작점에서 대포까지의 거리 / 속도
            }
        }

        // for(int i=0;i<=N+1;i++)
        // {
        //     for(int j=0;j<=N+1;j++)
        //     {
        //         System.out.print(map[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        visited = new boolean[N+2];
        double[] answer = new double[N+2];
        for(int i=0;i<N+2;i++)
        {
            answer[i] = map[0][i];//시작점부터 걸린 시간
        }

        for(int n=0;n<=N;n++)
        {//N+1번 수행
            int next = find();
            visited[next]=true;

            for(int i=1;i<N+2;i++)
            {
                double temp = answer[next] + map[next][i];//next거쳐서 도착한것
                if(answer[i] > temp)
                    answer[i] = temp;
            }
            // System.out.println(next+" "+Arrays.toString(answer));
        }

        System.out.println(answer[N+1]);
    }
}
