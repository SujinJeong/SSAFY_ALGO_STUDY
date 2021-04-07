import java.util.*;
import java.io.*;
class Main18808_copy{//스티커 붙이기
    //괜히고쳤나
    static int N;
    static int M;
    static int[][] map;
    static int[][] arr;
    static int[][] new_arr;
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
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            arr = new int[R][C];
            new_arr = new int[C][R];

            for(int r=0;r<R;r++)
            {
                st = new StringTokenizer(br.readLine());
                for(int c=0;c<C;c++)
                {
                    arr[r][c]=Integer.parseInt(st.nextToken());
                }
            }//R*C스티커 arr
            
            for (int dir = 0; dir < 4; dir++)
            {//4번 회전
                //회전-------------------------------------------------------------
                if(dir==1 || dir==3)
                {//90도 270도 회전하면 C*R스티커 new_arr
                    turn(R,C);
                }
                if(dir==2)
                {//180도 회전
                    int[][] temp = new int[R][C];
                    for(int ti=R-1, i=0;ti>=0;ti--, i++)
                    {
                        for(int tj=C-1, j=0;tj>=0;tj--, j++)
                        {
                            temp[ti][tj] = arr[i][j];
                        }
                    }

                    for(int i=0;i<R;i++)
                    {
                        for(int j=0;j<C;j++)
                            arr[i][j] = temp[i][j];
                    }
                }

                //스티커 붙일수있는지 확인------------------------------------------
                boolean b= false;
                for(int i=0;i<N;i++)
                {
                    for(int j=0;j<M;j++)
                    {                            
                        if(dir==0 || dir==2)
                        {//0도 180도
                            if(check(arr,i,j,R,C)==true)
                            {
                                //스티커 붙이기------------------------------------------
                                change(arr,i,j,R,C);
                                b=true;
                                break;
                            }
                        }
                        else
                        {//90도 270도
                            if(check(new_arr,i,j,C,R)==true)
                            {
                                //스티커 붙이기------------------------------------------
                                change(new_arr,i,j,C,R);
                                b=true;
                                break;
                            }
                        }
                    }
                    if(b==true)
                        break;//스티커 붙임
                }
                if(b==true)
                    break;//이제 다음 스티커
            }
            
            // System.out.println(k+"-----------------------------------");
            // for(int i=0;i<N;i++)
            //     System.out.println(Arrays.toString(map[i]));
        }//모든 스티커 본다

        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if(map[i][j]==1)
                    cnt++;//스티커 붙어있는 칸 수
            }
        }
        System.out.println(cnt);
    }

    public static void turn(int R, int C)
    {//90도 270도 회전
        for(int i=0;i<R;i++)
        {
            for(int j=0;j<C;j++)
            {
                new_arr[j][R-1-i] = arr[i][j];
            }
        }
    }

    public static void change(int[][] arr, int si, int sj, int R, int C)
    {//스티커 붙이기
        for(int i=0;i<R;i++)
        {
            for(int j=0;j<C;j++)
            {
                if(arr[i][j]==1)
                    map[i+si][j+sj]=1;
            }
        }
    }

    public static boolean check(int[][] arr,int si, int sj, int R, int C)
    {//붙일 수 있는지 없는지 확인
        for(int i=0;i<R;i++)
        {
            for(int j=0;j<C;j++)
            {
                if(i+si>=N || j+sj>=M)
                    return false;//전체 칸을 넘어가면
                if(arr[i][j]==1)
                {//스티커 있는 칸
                    if(map[i+si][j+sj] != 0)
                        return false;//스티커 붙일 칸에 이미 붙어있으면
                }
            }
        }
        return true;
    }
 }