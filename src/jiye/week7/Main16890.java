import java.util.*;
import java.io.*;
class Main16890 {//창업
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
        
        // System.out.println(Arrays.toString(c1));
        // System.out.println(Arrays.toString(c2));

        //무조건 작은 순 큰순 하나씩 넣는게 아니고
        //c1의 가장 작은것 vs c2의 가장 큰것 비교   --> c1의 가장 큰거를 뒤에
        //c2의 가장 큰것 vs c1의 가장 작은것 비교   --> c2의 가장 작은거를 앞에
        //기본은 c1은 작은것을 앞에 두고 c2는 큰것을 앞에 두는것
        //else-> 거꾸로
        //아니왜 배열로는 안되냐구요

        //자르고 하는게 좋구나 쓸 문자들 N+1개 뭐이렇게

        char[] answer = new char[N];
        // int s1=0;//앞에서부터
        // int e1=N-1;
        // int s2=0;
        // int e2=N-1;//뒤에서 부터
        // int s=0;
        // int e=N-1;
        // for(int n=0;n<N/2;n++)
        // {
        //     //구사과 차례
        //     if(c1[s1] <= c2[e2])
        //     {//앞에다 둔다
        //         answer[s]=c1[s1];
        //         s++;
        //         s1++;
        //     }
        //     else
        //     {//제일 큰거를뒤에다 둔다
        //         answer[e]=c1[e1];
        //         e--;
        //         e1--;
        //     }

        //     //큐브러버 차례
        //     if(c2[e2] >= c1[s1])
        //     {//앞에다 둔다
        //         answer[s]=c2[e2];
        //         s++;
        //         e2--;
        //     }
        //     else
        //     {//제일 작은거를 뒤에다 둔다
        //         answer[e]=c2[s2];
        //         e--;
        //         s2++;
        //     }
              
        // }

        // // System.out.println(s+" "+e+" "+i1+" "+i2);
        // if(N%2!=0)
        //     answer[s]=c1[s1];

        int s=0;
        int e=N-1;
        for(int i=0;i<N;i++)
        {
            if(i%2==0)//구사과차례
            {
                char c= pq1.poll();
                //가장 작은 문자가 큐브러버의 가장 큰 문자보다 크면
                if(pq2.size()==0)
                {
                    answer[s]=c;
                    break;
                }
                if(c>=pq2.peek())
                {
                    answer[e]=c;
                    e--;//뒤에 놓는다
                }
                else
                {
                    answer[s]=c;
                    s++;//앞에 놓는다
                }
            }
            else//큐브러버 차례
            {
                char c= pq2.poll();
                //가장 큰 문자가 구사과의 가장 작은 문자보다 작으면
                if(c<=pq1.peek())
                {
                    answer[e]=c;
                    e--;//뒤에 놓는다
                }
                else
                {
                    answer[s]=c;
                    s++;//앞에 놓는다
                }
            }
        }

        StringBuilder sb= new StringBuilder();
        for(int n=0;n<N;n++)
            sb.append(answer[n]);
        System.out.println(sb);
    }
    
}
