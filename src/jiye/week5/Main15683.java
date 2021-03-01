import java.util.*;
import java.io.*;
class CCTV{
    int x;
    int y;
    int type;
    public CCTV(int x, int y, int type)
    {
        this.x = x;
        this.y = y;
        this.type = type;
    }
}

class Main15683 {//감시
    static int[] dx = {0,-1,0,1};//오른쪽 아래 왼쪽 위
    static int[] dy = {1,0,-1,0};
    static int N;
    static int M;
    static int[][] Map;//주어진 사무실 정보
    static int[][] map;
    static int max=0;
    static ArrayList<CCTV> cctv;

    public static void combi(int index, int[] arr)
    {
        if(index==cctv.size())
        {
            // System.out.println(Arrays.toString(arr));
            map = new int[N][M];
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<M;j++)
                    map[i][j]=Map[i][j];
            }//초기화
            func(arr);//볼수 있는칸 -1로 변경

            int cnt=count();
            if(cnt>max)
                max = cnt;//최대로 볼 수 있는 칸

            return;
        }

        if(cctv.get(index).type==2)
        {//2번 cctv는 두가지 경우밖에 없다
            for(int i=0;i<2;i++)
            {
                arr[index]=i;
                combi(index+1,arr);
            }
        }
        else if(cctv.get(index).type==5)
        {//5번 cctv는 한가지 경우밖에 없다
            for(int i=0;i<1;i++)
            {
                arr[index]=i;
                combi(index+1,arr);
            }
        }
        else
        {//나머지는 4가지 경우
            for(int i=0;i<4;i++)
            {
                arr[index]=i;
                combi(index+1,arr);
            }
        }
       
    }

    public static void func(int[] arr)
    {
        int[][] c2 = {{0,2},{1,3}};
        int[][] c3 = {{0,3},{0,1},{1,2},{2,3}};
        int[][] c4 = {{0,1,2},{1,2,3},{0,2,3},{0,1,3}};

        for(int n=0;n<arr.length;n++)
        {//arr은 방향 조합
            if(cctv.get(n).type==1)
            {
                int dir = arr[n];//한 쪽 방향만 감시
                see(n,dir);
            }
            else if(cctv.get(n).type==2)
            {//c2에 저장된 대로 0,2 / 1,3 본다
                for(int i=0;i<2;i++)
                {//두 방향 감시
                    int dir = c2[arr[n]][i];
                    see(n,dir);
                }
            }
            else if(cctv.get(n).type==3)
            {
                for(int i=0;i<2;i++)
                {//두 방향 감시
                    int dir = c3[arr[n]][i];
                    see(n,dir);
                }
            }
            else if(cctv.get(n).type==4)
            {
                for(int i=0;i<3;i++)
                {//세 방향 감시
                    int dir = c4[arr[n]][i];
                    see(n,dir);
                }
            }
            else
            {//5번 CCTV
                for(int i=0;i<4;i++)
                {//네 방향 감시
                    see(n,i);
                }
            }
        }
    }

    public static void see(int n,int dir)
    {
        int x=cctv.get(n).x;
        int y=cctv.get(n).y; //cctv의 현재 위치

        int nx = x+dx[dir];
        int ny = y+dy[dir];//dir방향으로 쭉 본다
        while(nx>=0 && nx<N && ny>=0 && ny<M)
        {//갈 수 있고
            if(map[nx][ny]==0)
            {//비어있는 곳이면 
                map[nx][ny]=-1;//볼 수 있는 칸
            }
            else if(map[nx][ny]==6)
            {//벽이면 그만간다
                break;
            }
            nx+=dx[dir];
            ny+=dy[dir];//그다음 칸
        }
    }

    public static int count()
    {//볼 수 있는 칸 세기
        int result = 0;
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if(map[i][j]==-1)
                    result++;
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Map = new int[N][M];
        cctv = new ArrayList<>();
        int W=0;

        for(int i=0;i<N;i++)
        {
            st  = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++)
            {
                Map[i][j] = Integer.parseInt(st.nextToken());
                if(Map[i][j]==0)
                {//벽, CCTV는 빼고
                    W++;
                }
                else if(Map[i][j]!=6)
                {//CCTV는 배열에 넣어준다
                    cctv.add(new CCTV(i,j,Map[i][j]));
                }
            }
        }

        //전체 사무실 영역에서 벽 CCTV 제외  W
        //모든 cctv 모든방향 경우의수 구한다...

        combi(0,new int[cctv.size()]);

        System.out.println(W - max);
    }
}
