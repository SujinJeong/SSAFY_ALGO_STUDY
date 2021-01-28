package jiye.week1;
import java.util.*;

class Main11866{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k= sc.nextInt();
        int[] answer = new int[n];
     
        Queue<Integer> q = new LinkedList<Integer>();
        
        for(int i=0;i<n;i++)
            q.offer(i+1);
        
        int j=0;
        
           while(q.size()>0)
        {
            int index=k;
            while(index > q.size())
            {
                index = index-q.size();
                //System.out.println(index+ " "+ q.size());
            }
            
            for(int i=0;i<index-1;i++)
            {
                int a=q.poll();
                q.offer(a);//빼고 넣고
            }
           
            answer[j]=q.poll();//k번째꺼는 빼고
            j++;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for(int i=0;i<n-1;i++)
            sb.append(answer[i]+", ");
        sb.append(answer[n-1]+">");
        System.out.println(sb);
        sc.close();
    }
}