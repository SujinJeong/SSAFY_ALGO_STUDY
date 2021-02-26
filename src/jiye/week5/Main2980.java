import java.util.*;
import java.io.*;

class Main2980 {//도로와 신호등
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());//도로길이

        int[][] arr = new int[N][3];
        for(int i=0;i<N;i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++)
            {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //R 2 G 2  주기 4
        //12 34  56 78  910 1112
        //time 5 -> 나머지 1 1<=2 빨간불  2-1초 대기
        //time 7 -> 나머지 3 3>2 초록불

        int truck=0;
        int time=0;

        for(int n=0;n<N;n++)
        {
            int R = arr[n][1];
            int G = arr[n][2];

            time += arr[n][0] - truck;//이전 위치 - 다음 신호등 위치
            truck = arr[n][0];//신호등이 있는 위치까지 간다

            int a = time % (R+G);
            if(a <= R)
                time += R-a;//대기시간

          /*  int t=0;
            while(true)
            {
                if( t*(R+G) < time && time <= (t+1)*(R+G) )
                {
                    int a = time - t*(R+G);
                    if( a > R )
                    {//갈수있다
                        break;
                    }
                    else
                    {
                        time += R - a;//R초까지 대기
                        break;
                    }
                }
                t++;
            }//왜 이건 안돼...
            */
        }

        //마지막 신호등 이후에는 쭉간다
        time += L - truck;

        System.out.println(time);
    }
}
