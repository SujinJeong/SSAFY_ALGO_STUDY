import java.util.*;
import java.io.*;

class Main13164{//행복 유치원

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] map = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
        {
            map[i] = Integer.parseInt(st.nextToken());
        }


        // 1   3   5   6   10    5조 답 0
        //   2   2   1   4    -> 1
        // 1   3    5 6    10    4조 답 1
        //   2   2       4    -> 1 + 2
        //   1 3    5 6    10    3조 답 3
        //       2       4    -> 1 + 2 + 2
        //    1 3 5 6      10    2조 답 4
        //               4    -> 1 + 2 + 2 + 4
        //      1 3 5 6 10       1조 답 9


        int answer =0;//조가 N개면 0
        if(N!=1 && K==1)
        {//조가 하나
            answer = map[N-1] - map[0];
        }
        else if(N!=K)
        {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i=0;i+1<map.length;i++)
            {
                pq.add(map[i+1]-map[i]);
            }
            for(int i=0;i<N-K;i++)
            {
                answer+=pq.poll();//작은것부터 더해준다
            }
        }   
        
        System.out.println(answer);
    }
}