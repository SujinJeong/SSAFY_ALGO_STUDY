package jiye.week1;
import java.util.*;
import java.io.*;
class Top{
    int value;
    int i;
    public Top(int value,int i)
    {
        this.value=value;
        this.i=i;
    }
}
class Main2493 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer strT = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        int[] arr = new int[N];
        for(int i=0;i<N;i++)
            arr[i]=Integer.parseInt(strT.nextToken());

        Stack<Top> st = new Stack<Top>();

        Top t = new Top(arr[0],1);
        st.push(t);
        boolean bool=false;
        sb.append("0 ");
        for(int i=1;i<N;i++)
        {
            int answer=0;
            while(st.size()!=0)
            {
                if(st.peek().value <arr[i])
                {//arr[i]가 쏜게 안맞는다
                    st.pop();
                }
                else//맞았다
                {
                    answer=st.peek().i;
                    bool=true;  
                    break;
                }
            }

            if(bool==false)
                sb.append("0 ");
            else
                sb.append(answer+" ");//맞았을때

            Top t1= new Top(arr[i],i+1);
            st.push(t1);
        }

        System.out.println(sb);
    }
}
