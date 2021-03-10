import java.util.*;
import java.io.*;
class Main1806 {//부분합
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
        {
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int min=Integer.MAX_VALUE;
        int num=0;
        int s=0; 
        int e=0;
        int sum=0;
        while(true)
        {//끝포인터가 끝까지 갔을때
            
            if(sum>=S)
            {//최소길이니까 넘으면 바로 끝낸다
                sum-=arr[s];
                s++;//s를 땡긴다
            }
            else if(e==N)
                break;//끝까지 봤다
            else
            {//합이 S가 안됐으면
                sum+=arr[e];//끝부분 원소를 더한다
                e++;//뒤에 더 본다
            }

            if(sum>=S)
            {
                num=e-s;//길이
                if(min>num)
                    min=num;
            }

        }

        if(min==Integer.MAX_VALUE)
            System.out.println(0);//합을 만드는 것이 불가능한 경우
        else
            System.out.println(min);
    }
}
