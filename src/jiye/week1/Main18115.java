package jiye.week1;
import java.util.*;

class Main18115{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr = new int[n];
        
        for(int i=n-1;i>=0;i--)
            arr[i]=sc.nextInt();//거꾸로넣고
        
        Deque<Integer> dq = new ArrayDeque<Integer>();
        /*
        순서대로 쌓인다 -> 카드 N부터 뺀다 N-1, N-2,...,2, 1
        1이 가장 마지막으로 나오는 카드 -> 1부터 dq에 넣기
        
        arr[i]  i   deque
        (1)     0   1
        (2)     1   1 '2'
        (3)     2   1 2 <-3
        (3)    n-2  1 2 3 <-4
        (2)    n-1  1 '5' 2 3 4
        */
        dq.add(1);//마지막은 항상 카드1
        for(int i=1;i<n;i++)
        {//뒤에서부터 
            if(arr[i]==1)
            {//방법1 맨앞에 있는 카드를 빼왔다
                dq.addFirst(i+1);//맨앞에 넣음
            }
            else if(arr[i]==2)
            {//방법2 앞에서 두번째 카드
                int temp=dq.pollFirst();//맨앞에꺼 빼고
                dq.addFirst(i+1);
                dq.addFirst(temp);//다시 넣음
            }
            else
            {//방법3 맨뒤에 있는 카드를 빼왔다
                dq.addLast(i+1);//맨뒤에
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++)
        {
            sb.append(dq.pollFirst()+" ");
        }
        System.out.println(sb);
        
        sc.close();

        // for(int i=0;i<n;i++)
        //     arr[i]=sc.nextInt();//순서대로넣고
        
        // Deque<Integer> dq = new ArrayDeque<Integer>();
        // /*
        // 순서대로 쌓인다 -> 카드 N부터 뺀다 N-1, N-2,...,2, 1
        // 1이 가장 마지막으로 나오는 카드 -> 1부터 dq에 넣기
    
        // arr[i]  i   deque
        // (1)    n-1   1
        // (2)    n-2   1 '2'
        // (3)     2    1 2 <-3
        // (3)     1    1 2 3 <-4
        // (2)     0    1 '5' 2 3 4
        // */
        // dq.add(1);//마지막은 항상 카드1
        // for(int i=n-2;i>=0;i--)
        // {//뒤에서부터 
        //     if(arr[i]==1)
        //     {//방법1 맨앞에 있는 카드를 빼왔다
        //         dq.addFirst(n-i);//맨앞에 넣음
        //     }
        //     else if(arr[i]==2)
        //     {//방법2 앞에서 두번째 카드
        //         int temp=dq.pollFirst();//맨앞에꺼 빼고
        //         dq.addFirst(n-i);
        //         dq.addFirst(temp);//다시 넣음
        //     }
        //     else
        //     {//방법3 맨뒤에 있는 카드를 빼왔다
        //         dq.addLast(n-i);//맨뒤에
        //     }
        // }
    }
}