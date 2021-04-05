import java.util.*;
import java.io.*;
class Main10800{//컬러볼
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
        PriorityQueue<Ball> pq = new PriorityQueue<Ball>(new Comparator<Ball>(){
            public int compare(Ball b1, Ball b2)
            {
                if(b1.size == b2.size)
                    return b1.color - b2.color;//크기 같으면 색깔 순
                return b1.size - b2.size;
            }
        });//크기 작은 순
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken())-1;//색
            int b=Integer.parseInt(st.nextToken());//크기

            pq.add(new Ball(i,a,b));//색에 맞춰서
        }
        
        int[] answer = new int[N];
        int[] colors = new int[200000];//각 색깔공 크기합
        int sum=0;//총 크기합
        int prev=0;//이전 크기
        while(pq.size()!=0)
        {
            Ball ball = pq.poll();
            int color = ball.color;
            int index = ball.i;
            int size = ball.size;

            colors[color]+=size;
            sum+=size;
            answer[index] = sum-colors[color];
            
            // System.out.println(color+" "+size+" "+index+" -- "+ sum+" "+ colors[color]+" = "+answer[index]);
            prev = size;
        }

        for(int i=0;i<N;i++)
            sb.append(answer[i]+"\n");

        System.out.println(sb);
    }
 }