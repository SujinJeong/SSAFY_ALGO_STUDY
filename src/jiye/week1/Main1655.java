package jiye.week1;
import java.util.*;

class Main1655 {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();

//순서대로 넣고 짝수는 n/2-1번째꺼 홀수는 n/2번째꺼
//그 전꺼까지 빼서 arraylist arr에 넣었다가
//중간값 빼고 arr 다시 넣으려 했다...

        /* PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i=0;i<N;i++)
        {
            int num=sc.nextInt();

            pq.offer(num);//일단 넣고

            if(pq.size()==1)
            {
                sb.append(num+"\n");
            }
            else if(pq.size()==2)
            {
                sb.append(pq.peek()+"\n");
            }
            else
            {
                int n = pq.size()/2;
                if(pq.size()%2==0)
                    n-=1;//짝수
                // ArrayList<Integer> arr = new ArrayList<Integer>();
                // for(int j=0;j<n;j++)
                // {
                //     arr.add(pq.poll());//앞에꺼 뺀다..
                // }
                // sb.append(pq.peek()+"\n");

                // for(int j=0;j<arr.size();j++)
                //     pq.offer(arr.get(j));//다시 넣어준다
             
            }
        } */

        //중간값 기준으로 작은것 pq1, 큰것 pq2로 하기로했다
        //둘다 맨 앞에꺼가 중간값이 될 수 있게 작은 것은 역순
        //1 5 2 10 -99 7 5
        //i  pq1(역순)           pq2          m     num   ->  m
        //0  1                                1               1
        //1  1                   5            1  <  5         1
        //   ^
        //2  1                   2 5          1  <  2         2
        //                       ^
        //3  1                   2 5 10       2  <  10             
        //3  2 1                 5 10         2  <  10        2    
        //   ^
        //4  2 1 -99             5 10         2  >  -99           
        //4  1 -99               2 5 10       2  >  -99       2    
        //                       ^
        //5  1 -99               2 5 7 10     2  <  7           
        //5  2 1 -99             5 7 10       2  <  7         2  
        //   ^
        //6  2 1 -99             5 5 7 10     2  <  5         5  
        //                       ^
        //++캬 그냥 두개에 번갈아가면서 넣고 앞부분 비교하고 ...

        PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>(Collections.reverseOrder());//작은것 a>b>c
        PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>();//큰것 d<e<f
        int m=0;//중간값
        for(int i=0;i<N;i++)
        {
            int num=sc.nextInt();

            if(i==0)
            {
                pq1.offer(num);//일단 넣고
                m=num;
            }
            else if(i==1)
            {
                if(m>num)
                {//2 1같은 경우 반례ㅖㅖㅖㅖ
                    pq2.offer(pq1.poll());
                    pq1.offer(num);
                }
                else
                    pq2.offer(num);//두번째 들어온게 더 크다
                m=pq1.peek();
            }
            else
            {
                if(i%2==0)
                {//pq들에 있는 수가 짝수
                    if(m<num)
                    {
                        pq2.offer(num);
                    }
                    else
                    {
                        pq1.offer(num);//위에 넣고
                        pq2.offer(pq1.poll());//맨앞에꺼 아래에 넣음
                    }
                    m=pq2.peek();//큰것들 중에 가장 작은값이 중간값이 된다
                }
                else
                {//pq들에 있는 수가 홀수
                    if(m<num)
                    {
                        pq2.offer(num);//아래에 넣고
                        pq1.offer(pq2.poll());//맨앞에꺼 위로
                    }
                    else
                    {
                        pq1.offer(num);//위에 넣고
                    }
                    m=pq1.peek();//작은것들 중에 가장 큰값이 중간값이 된다
                }
               
            }
            
            sb.append(m+"\n");
        }


        System.out.println(sb);
        sc.close();
    }
}
