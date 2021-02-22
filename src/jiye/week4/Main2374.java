import java.util.*;
import java.io.*;
class Main2374 {//같은 수로 만들기
    static int N;
    static int[] map;
    static int MAX=0;
    static int cnt=0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N];

        ArrayList<Integer> al = new ArrayList<Integer>();
        for(int i=0;i<N;i++)
        {
            map[i]=Integer.parseInt(br.readLine());
            al.add(i);
            if(MAX<map[i])
                MAX=map[i];//가장 큰 수의 인덱스 같은거 여러개면? 앞에꺼
        }


        func(0,N-1,MAX);

        System.out.println(cnt);
    }

    public static void func(int start, int end, int prev_max)
    {
        int max = 0;
        int maxindex = 0;
        int k=0;//인접 개수
        //제일큰거 찾기
        for (int i = start; i <= end; i++)
        {
            if(map[i]>max)
            {
                max = map[i];
                maxindex = i;
            }
        }

        //인접 부분 찾기
        for (int i = maxindex; i <= end; i++)
        {
            if(map[i]==max)
            {
                k++;
            }
            else
                break;
        }

        //앞뒤로 나누기
        if (start <= maxindex - 1)
            func(start, maxindex - 1, max);// 앞

        if(maxindex+k <= end)
            func(maxindex + k, end, max);// 뒤

        //볼때까지 다 봤으면 이제 키운다
        cnt+=(prev_max - max);
        for(int i=start; i<=end;i++)
        {
            map[i]=prev_max;

        }
    }
}
