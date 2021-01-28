package jiye.week1;
import java.util.*;

class Main18115{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        
        Deque<Integer> dq = new ArrayDeque<Integer>();
        dq.add(1);
        for(int i=n-2;i>=0;i--)
        {
            if(arr[i]==1)
            {
                dq.addFirst(n-i);
            }
            else if(arr[i]==2)
            {
                int temp=dq.pollFirst();//맨앞에꺼 빼고
                dq.addFirst(n-i);
                dq.addFirst(temp);//다시 넣음
            }
            else
            {
                dq.addLast(n-i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++)
        {
            sb.append(dq.pollFirst()+" ");
        }
        System.out.println(sb);
        
        sc.close();
    }
}