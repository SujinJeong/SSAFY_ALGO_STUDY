import java.util.*;
import java.io.*;
class Main16890_copy {//창업
    //이게 뭐야
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1=br.readLine();
        int N = str1.length();
        PriorityQueue<Character> pq1 = new PriorityQueue<Character>();
        for(int i=0;i<N;i++)
            pq1.add(str1.charAt(i));//작은것부터
        String str2=br.readLine();
        PriorityQueue<Character> pq2 = new PriorityQueue<Character>(Collections.reverseOrder());
        for(int i=0;i<N;i++)
            pq2.add(str2.charAt(i));//큰것부터

        //무조건 작은 순 큰순 하나씩 넣는게 아니고
        //c1의 가장 작은것 vs c2의 가장 큰것 비교
        //c2의 가장 큰것 vs c1의 가장 작은것 비교  
        //기본은 c1은 작은것을 앞에 두고 c2는 큰것을 앞에 두는것
        //else-> 거꾸로

        //자르고 하는게 좋구나 쓸 문자들 N+1개 뭐이렇게

        // char[] c1 = new char[];
        Deque<Character> c1 = new ArrayDeque<>();
        for(int i=0;i<(N+1)/2;i++)
        {
            c1.add(pq1.poll());
        }
        Deque<Character> c2 = new ArrayDeque<>();
        for(int i=0;i<N/2;i++)
        {
            c2.add(pq2.poll());
        }
        //쓸 문자들만 넣는다

        ArrayList<Character> front = new ArrayList<>();
        ArrayList<Character> back = new ArrayList<>();
        for(int n=0;n<N;n++)
        {
            if(n%2==0)
            {
                //구사과 차례 아니 대체 <랑 <=랑 시발
                if(c2.size()==0|| c1.peekFirst() <= c2.peekFirst())
                {//구사과 가장 작은것이 큐브러버 가장 큰거보다 작으면
                    front.add(c1.pollFirst());
                }
                else
                {//구사과의 제일 큰거를 뒤에다 둔다
                    back.add(c1.pollLast());
                }
            }
            else
            {
                //큐브러버 차례
                if(c1.size()==0|| c1.peekFirst() <= c2.peekFirst())
                {//구사과 가장 작은것이 큐브러버 가장 큰거보다 작으면
                    front.add(c2.pollFirst());
                }
                else
                {//큐브러버의의 제일 작은거를 뒤에다 둔다
                    back.add(c2.pollLast());
                }
            }
        }

        
        StringBuilder sb= new StringBuilder();
        for(int n=0;n<front.size();n++)
        {
            if(front.get(n)!=' ')
                sb.append(front.get(n));
        }

        for(int n=back.size()-1;n>=0;n--)
        {
            if(back.get(n)!=' ')
                sb.append(back.get(n));
        }        
        System.out.println(sb);
    }
    
}
