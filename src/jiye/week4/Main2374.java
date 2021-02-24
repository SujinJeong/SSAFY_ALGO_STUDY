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
                MAX=map[i];//가장 큰 수
        }


        //큰수 인접배열 기준으로 앞 뒤 나눠서 반복한다

        // i    0 1 2 3 4 5 6
        //map   1 1 3 3 3 1 2
        //가장 큰수 3 범위 0~6  -> func(0,6,3)
        //
        //큰 수 max=3 큰수 maxindex 2
        //인접한 같은 수 k개 k=3 그룹  maxindex ~ maxindex+2
        //인접한 같은 수 그룹 앞 뒤로 나눔
        //앞 start ~ maxindex-1 |  maxindex ~ maxindex+k-1  | 뒤 maxindex+k ~ end
        //
        //func(0,1,3)                   func(5,6,3)
        //max=1 maxindex=0 k=2          max=2 maxindex=6 k=1
        //앞 func(0,-1,1) -> X          앞 func(5,5,2) ->가능    
        //뒤 func(2,1,1)  -> X          뒤 func(7,6,2) -> X
        //
        //모두 같은 수라는 뜻 
        //-> 이전 max까지 키운다
        //11 -> 33   cnt+2


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
            if (map[i] > max)
            {
                max = map[i];
                maxindex = i;//큰수가 여러개여도 맨 앞 인덱스만
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
