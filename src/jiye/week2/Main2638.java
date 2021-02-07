import java.util.*;
import java.io.*;
 class Main2638 {
    static int N;
    static int M;
    static int[][]map;

    public static int check( int x, int y)
    {
        int cnt=0;
        if(map[x-1][y]==0)
            cnt++;
        if(map[x+1][y]==0)
            cnt++;
        if(map[x][y-1]==0)
            cnt++;
        if(map[x][y+1]==0)
            cnt++;
        return cnt;
    }

    public static void inside(int x, int y)
    {
        if(map[x][y]==1)
            return;//치즈면 바꾸지 말고

        int cnt=0;
        for(int i=x+1;i<N;i++)
        {
            if(map[i][y]==1)
            {
                cnt++;
                break;//아래쪽에 치즈
            }
        }
        for(int i=x-1;i>=0;i--)
        {
            if(map[i][y]==1)
            {
                cnt++;
                break;//위쪽에 치즈
            }
        }
        for(int i=y+1;i<M;i++)
        {
            if(map[x][i]==1)
            {
                cnt++;
                break;//오른쪽에 치즈
            }
        }
        for(int i=y-1;i>=0;i--)
        {
            if(map[x][i]==1)
            {
                cnt++;
                break;//왼쪽에 치즈
            }
        }
        if(cnt==4)
            map[x][y]=2;//내부
    }

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        // ArrayList<Integer> cheese = new ArrayList<>();
        Stack<Integer> cheese = new Stack<>();

        int minx=N;
        int miny=M;
        int maxx=0;
        int maxy=0;
        for(int i=0;i<N;i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++)
            {
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]==1)
                {
                    cheese.add(i*M+j);
                    if(minx>=i)
                        minx = i;
                    if(maxx<=i)
                        maxx = i;
                    if(miny>=j)
                        miny = j;
                    if(maxy<=j)
                        maxy = j;
                }
            }
        }

        System.out.println(minx+ " "+miny+ " "+maxx+" "+maxy);

        int t=0;
        while(cheese.size()>0)
        {
            Stack<Integer> fail = new Stack<>();
            Stack<Integer> st1 = new Stack<>();
            for(int i=minx; i<=maxx;i++)
            {
                for(int j=miny;j<=maxy;j++)
                {
                    inside(i,j);
                }//내부는 2로 바꿔준다
            }


            while(cheese.size()>0)
            {
                int c = cheese.pop();
                // System.out.println(c);
                int x = c/M;
                int y = c%M;

                if(check(x,y)>=2)//상한치즈 스택에
                    fail.push(c);
                
                else//멀쩡한 치즈
                    st1.push(c);
            }

            while(fail.size()>0)
            {//상한치즈 map값 바꾸기
                int c = fail.pop();
                // System.out.(c);
                int x = c/M;
                int y = c%M;
                map[x][y]=0;
            }

            cheese=st1;
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<M;j++)
                {
                    System.out.print(map[i][j]+ " ");
                }
                System.out.println();
            }
            for(int i=minx; i<=maxx;i++)
            {
                for(int j=miny;j<=maxy;j++)
                {
                    if(map[i][j]==2)
                        map[i][j]=0;
                }
            }

            System.out.println("---");
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<M;j++)
                {
                    System.out.print(map[i][j]+ " ");
                }
                System.out.println();
            }


            t++;
        }
        System.out.println(t);
        
    }
}


