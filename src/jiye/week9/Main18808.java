import java.util.*;
import java.io.*;
class Main18808{
    //08:19
    static int[] dx={-1,1};
    static int N;
    static int M;
    static int R;
    static int C;
    static int[][] map;
    static int[][] arr;
    static int[][] narr;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        int cnt=0;
        for(int k=0;k<K;k++)
        {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            arr = new int[R][C];

            for(int r=0;r<R;r++)
            {
                st = new StringTokenizer(br.readLine());
                for(int c=0;c<C;c++)
                {
                    arr[r][c]=Integer.parseInt(st.nextToken());
                }
            }
            
            boolean b= false;
            for(int i=0;i<=N-R;i++)
            {
                for(int j=0;j<=M-C;j++)
                {
                    if(check(i,j)==true)
                    {
                        change(i,j);
                        b=true;
                        break;
                    }
                }
                if(b==true)
                    break;//스티커 붙임
            }

            if(b==false)
            {//회전해서 다시
                narr=new int[C][R];
                turn();

                for(int i=0;i<=N-C;i++)
                {
                    for(int j=0;j<=M-R;j++)
                    {
                        if(check2(i,j)==true)
                        {
                            change2(i,j);
                            b=true;
                            break;
                        }
                    }
                    if(b==true)
                        break;//스티커 붙임
                }
            }

            if(b==false)
            {//회전해서 다시
                turn2();

                for(int i=0;i<=N-R;i++)
                {
                    for(int j=0;j<=M-C;j++)
                    {
                        if(check(i,j)==true)
                        {
                            change(i,j);
                            b=true;
                            break;
                        }
                    }
                    if(b==true)
                        break;//스티커 붙임
                }
            }

            if(b==false)
            {//회전해서 다시
                narr=new int[C][R];
                turn();

                for(int i=0;i<=N-C;i++)
                {
                    for(int j=0;j<=M-R;j++)
                    {
                        if(check2(i,j)==true)
                        {
                            change2(i,j);
                            b=true;
                            break;
                        }
                    }
                    if(b==true)
                        break;//스티커 붙임
                }
            }
        }


        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if(map[i][j]==1)
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static void turn()
    {
        for(int i=0;i<R;i++)
        {
            for(int j=0;j<C;j++)
            {
                narr[j][R-1-i] = arr[i][j];
            }
        }

        // for(int i=0;i<C;i++)
        // System.out.println(Arrays.toString(narr[i]));
    }

    public static void turn2()
    {
        for(int i=0;i<C;i++)
        {
            for(int j=0;j<R;j++)
            {
                arr[j][C-1-i] = narr[i][j];
            }
        }

        // for(int i=0;i<R;i++)
        // System.out.println(Arrays.toString(arr[i]));
    }


    public static void change(int si, int sj)
    {
        for(int i=0;i<R;i++)
        {
            for(int j=0;j<C;j++)
            {
                if(arr[i][j]==1)
                    map[i+si][j+sj]=1;
            }
        }
    }

    public static void change2(int si, int sj)
    {
        for(int i=0;i<C;i++)
        {
            for(int j=0;j<R;j++)
            {
                if(narr[i][j]==1)
                    map[i+si][j+sj]=1;
            }
        }
    }

    public static boolean check(int si, int sj)
    {
        for(int i=0;i<R;i++)
        {
            for(int j=0;j<C;j++)
            {
                if(i+si>N || j+sj>M)
                    return false;
                if(arr[i][j]==1)
                {//스티커 있는 칸
                    if(map[i+si][j+sj]==0)
                    {//스티커 있는 칸이 비었으면
                        // map[i+si][j+sj]=1;
                    }
                    else
                        return false;
                }
            }
        }
        return true;
    }

    public static boolean check2(int si, int sj)
    {
        for(int i=0;i<C;i++)
        {
            for(int j=0;j<R;j++)
            {
                if(i+si>N || j+sj>M)
                    return false;
                if(narr[i][j]==1)
                {//스티커 있는 칸
                    if(map[i+si][j+sj]==0)
                    {//스티커 있는 칸이 비었으면
                        // map[i+si][j+sj]=1;
                    }
                    else
                        return false;
                }
            }
        }
        return true;
    }
 }