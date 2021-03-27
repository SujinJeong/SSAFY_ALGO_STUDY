import java.util.*;
import java.io.*;
class Main16570{//앞뒤가 맞는 수열
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] arr2 = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
            arr2[N-1-i] = arr[i];
        }

        int[] pi2 = new int[N];
        int s2 = 0;
        for(int j=1;j<N;j++)
        {
            while(s2>0 && arr2[s2]!=arr2[j])
            {
                s2= pi2[s2-1];
            }
            if(arr2[s2]==arr2[j])
            {
                pi2[j]=++s2;
            }
        }
        Arrays.sort(pi2);

        int K=pi2[N-1];
        int count=0;
        int start=0;
        while(start<N)
        {
            // for(int i=start;i<N;i++)
            //     System.out.print(arr[i]+" ");
            
            // System.out.println();

            int[] pi = new int[N-start];
            int s = start;
            for(int j=s+1;j<N;j++)
            {
                while(s>start && arr[s]!=arr[j])
                {
                    s = pi[s-start-1]+start;
                }
                if(arr[s]==arr[j])
                {
                    pi[j-start]=s-start+1;
                    s++;//한칸 앞으로 가는건 맞고
                }
            }

        //     System.out.println(Arrays.toString(pi));
        // System.out.println(K+" "+count);

            // System.out.println(pi[N-start-1]);//이거가 K
            int k = pi[N-start-1];
            if(k ==K)
                count++;
            
            // System.out.println(K+", "+count);

            // boolean b= false;
            // for(int i=0;i<N-start;i++)
            // {
            //     if(pi[i]!=0)
            //     {
            //         start += i;
            //         b=true;
            //         break;
            //     }
            // }
            // if(b==false)
                start++;
        }

        if(K!=0)
        System.out.println(K+" "+count);
        else
        System.out.println("-1");
    }
}