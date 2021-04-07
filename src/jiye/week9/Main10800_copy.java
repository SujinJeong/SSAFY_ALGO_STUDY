import java.util.*;
import java.io.*;
class Main10800_copy{//컬러볼
    static class Ball{
        int i;
        int color;
        int size;
        public Ball(int i, int color, int size)
        {
            this.i = i;
            this.color = color;
            this.size = size;
        }
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Ball[] ball = new Ball[N];
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken())-1;//색
            int b=Integer.parseInt(st.nextToken());//크기

            ball[i] = new Ball(i,a,b);
        }
        
        Arrays.sort(ball, new Comparator<Ball>(){
            public int compare(Ball b1, Ball b2)
            {
                return b1.size - b2.size;
            }
        });//작은 순 정렬

        int[] answer = new int[N];
        int[] colors = new int[200000];//각 색깔공 크기합
        int sum=0;
        int j=0;//j를 데리고 하는거구나
        for(int i=0;i<N;i++)
        {
            while(ball[j].size < ball[i].size)
            {//같은거는 j안땡김
                colors[ball[j].color] += ball[j].size;//이 색깔공 합.. 아... 
                sum += ball[j].size;//지금까지 총 합
                j++;
            }
            System.out.println(i+" "+j+" "+sum+" "+colors[ball[i].color]);
            answer[ball[i].i] = sum - colors[ball[i].color];
        }

        for(int i=0;i<N;i++)
            sb.append(answer[i]+"\n");

        System.out.println(sb);
    }
 }