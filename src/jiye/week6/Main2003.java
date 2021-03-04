import java.util.*;
import java.io.*;
class Main2003{//수들의합2
    public static void main(String[] argse) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int num=0;
        int s=0; 
        int e=0;
        int sum=0;
        while(true)
        {//끝포인터가 끝까지 갔을때
            
            if(sum>=M)
            {
                sum-=arr[s];
                s++;//s를 땡긴다
            }
            else if(e==N)
                break;//끝까지 봤다
            else
            {//합이 M이 안됐으면
                sum+=arr[e];//끝부분 원소를 더한다
                e++;//뒤에 더 본다
            }

            if(sum==M)
                num++;
        }

        System.out.println(num);
    }
}