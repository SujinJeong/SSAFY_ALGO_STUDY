package jiye.week1;
import java.util.*;
class Main3190 {
//이걸로 해서 하면 편하다
    // static int[] dx = {0,1,0,-1};
    // static int[] dy = {1,0,-1,0};
    static boolean ifSnake(Queue<Integer> q, int a)
    {
        Integer[] arr = q.toArray(new Integer[q.size()]);
        for(int i=0;i<arr.length;i++)
        {
            if((int)arr[i]==a)
                return true;
        }
        return false;
    }

    static void printf(Queue<Integer> q)
    {
        Integer[] arr = q.toArray(new Integer[q.size()]);
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int answer=0;

        int N = sc.nextInt();
        int[] arr = new int[N*N];//1차원 배열로
        int appleNum = sc.nextInt();
        for(int i=0;i<appleNum;i++)
        {
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            arr[a*N+b]=1;
        }

        Queue<Integer> q = new LinkedList<Integer>();//뱀 위치 큐
        q.offer(0);//시작위치

        int T = sc.nextInt();//방향바꾸는 수
        int[] to = new int[T];//방향바꾸는 t저장
        String[] toc = new String[T];
        for(int t=0;t<T;t++)
        {
            to[t]= sc.nextInt();
            toc[t]=sc.next();
        }

        int a=0;//현재위치..
        int i=0;
        int t=0;
        int dir = 1;//오른쪽 아래 왼 위
        while(i<N*N*100)//계속 돌아...
        {
            if(t<T&&to[t]==i)
            {//방향을 바꿀 시간이면...방향을 바꾼다
                if(toc[t].equals("D"))
                {//오른쪽이면
                    dir+=1;
                    dir%=4;
                }
                else
                {//왼쪽이면
                    if(dir==0)
                        dir=3;
                    else
                    dir-=1;
                }
                t++;
            }
            i++;
            
            boolean b = true;//맵밖을 나가는지
            switch(dir)
            {//방향에 따른 다음 뱀머리 위치
                case 1:
                if(a%N==N-1)
                    b=false;
                    a+=1;//오른쪽
                    break;
                case 2:
                if(a/N==N-1)
                b=false;
                    a+=N;//아래
                    break;
                case 3:
                if(a%N==0)
                b=false;
                    a-=1;//왼쪽
                    break;
                case 0:
                if(a/N==0)
                b=false;
                    a-=N;//위
                    break;
                default:
                    break;
            }
            printf(q);
            //추가하기전에
            if(b==false || ifSnake(q,a)==true)
            {//벽이거나 몸에
                answer=i;
                break;
            }
            q.offer(a);//길이 추가

            if(arr[a]==0)
            {//사과가 없는 곳
                q.poll();//꼬리 빼준다
            }
            else{
                arr[a]=0;
            }
          
            System.out.println(i+" "+a+ "  "+dir);
        }
        if(i==N*100*N)
            answer=i;

        System.out.println(answer);
        sc.close();
    }
}
