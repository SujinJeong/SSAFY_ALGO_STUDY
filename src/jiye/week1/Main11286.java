package jiye.week1;
import java.util.*;

class Main11286{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        PriorityQueue<Integer> q1 = new PriorityQueue<Integer>();//양수
        PriorityQueue<Integer> q2 = new PriorityQueue<Integer>(Collections.reverseOrder());//음수
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++)
        {
            int num=sc.nextInt();
            if(num==0)
            {
                if(q1.size()==0&&q2.size()==0)
                {//없으면 0cnffur
                    sb.append("0\n");
                }
                else
                {//뺀다
                    if(q1.size()==0&&q2.size()!=0)
                    {//q1이 비었으면
                        sb.append(q2.poll()+"\n");
                    }
                    else if(q2.size()==0&&q1.size()!=0)
                    {//q2가 비었으면
                        sb.append(q1.poll()+"\n");
                    }
                    else
                    {//둘다 차있음
                        int a = q1.poll();
                        int b = q2.poll();
                        if(Math.abs(a)>=Math.abs(b))
                        {//같은 경우 더 작은 것만 뺀다(음수)
                            //2 -1이런 경우도 음수만 뺀다
                            q1.offer(a);//다시 넣고
                            sb.append(b+"\n");
                        }
                        else{
                            q2.offer(b);//다시 넣고
                            sb.append(a+"\n");                            
                        }
                    }
                }
            }
            else{
                if(num>0)
                    q1.offer(num);
                else
                    q2.offer(num);
            }
        }
        
        System.out.print(sb);
        
        sc.close();
    }
}

