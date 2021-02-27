import java.util.*;
import java.io.*;
class Shark{
    int x;
    int y;
    int size;
    public Shark(int x, int y, int size)
    {
        this.x=x;
        this.y=y;
        this.size=size;//상어 크기로도 쓰고 거리로도 쓰고
    }
}

class Main16236 {//아기상어
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static Shark shark;
    static Queue<Shark> q;
    static int cnt;

    public static int cal(Shark s, Shark f)
    {//기준상어 s 비교할 물고기 f
        int result=987654321;
        visited = new boolean[N][N];

        q = new LinkedList<>();
        q.add(new Shark(s.x,s.y,0));//거리시작0

        while(q.size()!=0)
        {
            Shark temp = q.poll();
            if (temp.x == f.x && temp.y == f.y)
            {//그 물고기에 도착
                result = temp.size;//도착할때 몇칸 움직였는지
                break;
            }

            func(s,temp);
        }

        f.size = result;//크기가 아닌 몇칸움직였는지를 바꿔준다
        return result;//그때 움직인 칸수
    }

    public static void func(Shark s,Shark temp)
    {
        int x=temp.x;
        int y = temp.y;
        if(visited[x][y]==true)
            return;
        
        visited[x][y]=true;//방문
        for(int dir=0;dir<4;dir++)
        {
            int nx = x+dx[dir];
            int ny = y+dy[dir];//새로운 위치

            if (nx >= 0 && nx < N && ny >= 0 && ny < N)
            {
                if(map[nx][ny] <= s.size)
                {//갈수 있으면
                    q.add(new Shark(nx,ny,temp.size+1));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        ArrayList<Shark> fish = new ArrayList<>();
        
        for(int i=0;i<N;i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++)
            {
                map[i][j]= Integer.parseInt(st.nextToken());
                if(map[i][j]==9)
                {//아기상어
                    shark = new Shark(i,j,2);
                    map[i][j]=0;
                }
                else if(map[i][j]!=0)
                {//물고기
                    fish.add(new Shark(i,j,map[i][j]));
                }
            }
        }
        
        if(fish.size()==0)
        {
            System.out.println(0);
            return;
        }
        else if(fish.size()==1)
        {
            if (fish.get(0).size < shark.size)//먹을 수 있다
                System.out.println(cal(fish.get(0),shark));
            else
                System.out.println(0);
            return;
        }
        else
        {
            int answer=0;
            
            while(true)
            {//먹을 수 있는게 없을 때까지
                PriorityQueue<Shark> al = new PriorityQueue<>(new Comparator<Shark>(){

                    @Override
                    public int compare(Shark o1, Shark o2) {
                        // TODO Auto-generated method stub
                        int a = cal(shark,o1);
                        int b = cal(shark,o2);
        
                        if(a!=b)
                            return a - b;//거리가 가까운것
                        else
                        {//거리가 같으면
                            if(o1.x != o2.x)
                                return o1.x - o2.x;//위에있는 물고기
                            else
                                return o1.y - o2.y;//왼쪽에 있는 물고기
                        }
                    }
        
                });

                for(int i=0;i<fish.size();i++)
                {
                    if(map[fish.get(i).x][fish.get(i).y] < shark.size)
                    {//먹을수있는것만 배열에 담는다
                        al.add(fish.get(i));
                    }
                }

                if(al.size()==0)
                    break;//먹을게 없다

                // if(al.size()==1)//하나면 정렬이 안됨.. 거리 계산
                Shark eat = al.poll();//먹을수 있는 것들 중 가장가까운거 먹는다
                cal(shark,eat);

                if(eat.size<=N*N)
                {
                    map[eat.x][eat.y] = 0;//0으로 바꿔주고
                    shark.x = eat.x;
                    shark.y = eat.y;//상어 옮김
                    
                    fish.remove(eat);//배열에서 없앤다
                    cnt++;
                    if(cnt==shark.size)
                    {
                        shark.size+=1;//크기 키워주고
                        cnt=0;//초기화
                    }
                    answer+=eat.size;//dlrjdksi
                }
                else//먹을 수 있는 크기 물고기들 중에 못가는 것도 있는데...
                    break;
            }
            System.out.println(answer);
        }

    }
}
