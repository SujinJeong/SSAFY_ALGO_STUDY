import java.util.*;
import java.io.*;
class Main10800{
    //08:19
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
        PriorityQueue<Ball>[] pq = new PriorityQueue[N];
        for(int i=0;i<N;i++)
         pq[i] = new PriorityQueue<Ball>(new Comparator<Ball>(){
            public int compare(Ball b1, Ball b2)
            {
                return b2.size - b1.size;
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken())-1;//색
            int b=Integer.parseInt(st.nextToken());//크기

            pq[a].add(new Ball(i,a,b));//색에 맞춰서
        }

        for(int i=0;i<N;i++)
        {
            if(pq[i].size()==0)
                continue;

            for(int )
        }

        int[] answer = new int[N];
        System.out.println(sb);
    }
 }