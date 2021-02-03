package jiye.week1;
import java.util.*;
class Main1966 {
    static boolean func(Queue<Integer> q,int a)
    {//뒤에 더 큰게 있나 보는 함수
        for(Integer i : q)
        {
            if(a<i)
                return false;
        }
        return true;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();//테스트케이스 수
        StringBuilder sb = new StringBuilder();

        for(int t=0;t<T;t++)
        {
            int n=sc.nextInt();//개수
            int m = sc.nextInt();//궁금한 인덱스

            Queue<Integer> qIndex = new LinkedList<Integer>();//인덱스
            Queue<Integer> q = new LinkedList<Integer>();//중요도
            
            ArrayList<Integer> answer = new ArrayList<Integer>();//뺀 인덱스 담기

            for(int i=0;i<n;i++)
            {
                int a= sc.nextInt();
                qIndex.offer(i);
                q.offer(a);
            }

//    q    2 4 1 3  -> 4132 -> 132 -> 321 -> 21 -> 1 
// qindex  0 1 2 3  -> 1230 -> 230 -> 302 -> 02 -> 2
// answer                      1             3     0 

            while(q.size()>0)
            {
                int a= q.poll();
                int index = qIndex.poll();
                if(func(q,a)==false)
                {//큰게 있으면
                    qIndex.offer(index);
                    q.offer(a);
                }//다시 넣는다
                else
                {
                    answer.add(index);//뺀거 인덱스 넣음
                }
            }

            sb.append((answer.indexOf(m)+1)+"\n");//번째니까 +1
        }

        System.out.println(sb);
        sc.close();
    }
    
}
