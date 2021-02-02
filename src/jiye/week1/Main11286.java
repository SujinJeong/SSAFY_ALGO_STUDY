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


        //양수 q1은 1234
        //음수 q2는 -1-2-3-4 그래서 역순
        //맨 앞에꺼가 절대값 가장 작은 수
        //peek으로 하면 좋았을걸
        //++우선순위큐 정렬을 아예 abs(o2)-abs(o1)

        for(int i=0;i<n;i++)
        {
            int num=sc.nextInt();
            if(num==0)
            {//0일때 절대값 가장 작은것 출력한다
                if(q1.size()==0&&q2.size()==0)
                {//없으면 0출력
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
            else{//추가한다
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

