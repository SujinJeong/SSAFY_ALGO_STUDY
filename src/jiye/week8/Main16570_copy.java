import java.util.*;
import java.io.*;
class Main16570_copy{//앞뒤가 맞는 수열
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] arr2 = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
            arr2[N-1-i] = arr[i];//거꾸로 담는다
        }

        int[] pi = new int[N];//뒤에서부터 pi구한다
        int s2 = 0;
        for(int j=1;j<N;j++)
        {
            while(s2>0 && arr2[s2]!=arr2[j])
            {
                s2= pi[s2-1];
            }
            if(arr2[s2]==arr2[j])
            {
                pi[j]=++s2;
            }
        }
        // System.out.println(Arrays.toString(pi));

        //뒤에서부터 pi구한다음에 
        //제일 큰 수 몇개 나오는지 구하면 됨
        // 2 5 3 2 5 2 4 3 2 5
        // 0 1 3 2 1 0 0 0 0 0 뒤에서부터
        // 2 5 2 5 2 5 2 8 2 5 2
        // 3 2 3 2 3 2 1 0 1 0 0 뒤에서부터

        int K=0;
        int count=0;
        int k=K;
        for(int i=0;i<N;i++)
        {
            if(pi[i]>=K)
            {
                K=pi[i];
                if(k!=K)
                {//달라지면 K커진거니까 다시count
                    count=0;
                    k=K;
                }
                    count++;
                
            }
        }

        if(K!=0)
        System.out.println(K+" "+count);
        else
        System.out.println("-1");
    }
}