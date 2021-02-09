import java.util.*;
import java.io.*;

class Main14501 {//퇴사
    static int N;
    static ArrayList<Integer> arrrr=new ArrayList<>();
    static int[] tarr;
    static int[] parr;
    static int sum=0;
    static int max=0;

    public static void func(int a)
    {//a일
        for(int i=a;i<N;i++)
        {
            if(i+tarr[i]<=N)
            {//i일에 시작한 상담 끝난날이 N번째날인건 상담가능
                sum+=parr[i];
                func(i+tarr[i]);//상담이 끝난날로 이동
                sum-=parr[i];
            }
            else
            {//N번째 날보다 늦게 끝나면 그전 sum까지만
                if (max < sum)
                    max = sum;
            }
        }
        //a일이 이미 N번째날 초과인경우
        if(max<sum)
            max=sum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        N = Integer.parseInt(br.readLine());
        tarr = new int[N];//걸리는 기간
        parr = new int[N];//금액
        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            tarr[n] = Integer.parseInt(st.nextToken());
            parr[n] = Integer.parseInt(st.nextToken());
        }

        //i일 부터 상담 시작    끝나는 날 기준으로 계산   
        //i    0   1   2   3    4    5   6       N=7
        //Ti   3           1    2        2
        //     0   0   0 | 3  | 4    4 | 6    6
        //    0->3       3->4  4->6     6->8 N넘어감
        //sum  10         30    45/여기까지
        // 0 3 4 6x
        // 0 3 5x
        // 0 3 6x
        // 0 4 6x
        //...

        for(int i=0;i<N;i++)
        {
            func(i);//i일 부터 상담시작
        }
     
        answer=max;
        System.out.println(answer);
    }
}