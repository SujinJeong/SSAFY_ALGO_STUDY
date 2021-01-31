package jiye.week1;
import java.util.*;

class Main1655 {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        // PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        // for(int i=0;i<N;i++)
        // {
        //     int num=sc.nextInt();

        //     pq.offer(num);//일단 넣고

        //     if(pq.size()==1)
        //     {
        //         sb.append(num+"\n");
        //     }
        //     else if(pq.size()==2)
        //     {
        //         sb.append(pq.peek()+"\n");
        //     }
        //     else
        //     {
        //         int n = pq.size()/2;
        //         if(pq.size()%2==0)
        //             n-=1;//짝수
        //         // ArrayList<Integer> arr = new ArrayList<Integer>();
        //         // for(int j=0;j<n;j++)
        //         // {
        //         //     arr.add(pq.poll());//앞에꺼 뺀다..
        //         // }
        //         // sb.append(pq.peek()+"\n");

        //         // for(int j=0;j<arr.size();j++)
        //         //     pq.offer(arr.get(j));//다시 넣어준다
             
        //     }
        // }

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
                {//2 1같은 경우
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
                        pq2.offer(num);
                        pq1.offer(pq2.poll());
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
