import java.util.*;
import java.io.*;
class Main2437 {//저울
    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);//정렬

        if(arr[0]>1)
        {//절대 1 못만든다
            System.out.println(1);
            return;
        }
        
        //1 2 4 9
        //1 3 7   sum
        int sum=0;
        for(int i=0;i+1<N;i++)
        {
            sum+=arr[i];
            if(sum+1<arr[i+1])
            {//sum7 그다음꺼 9면 답 8 크캬
                System.out.println(sum+1);
                return;
            }
        }

        sum+=arr[N-1];//최대로 만들수있는 수까지 다 만들수있음
        System.out.println(sum+1);
    }
}
