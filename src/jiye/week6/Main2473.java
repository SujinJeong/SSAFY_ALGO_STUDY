import java.util.*;
import java.io.*;
class Main2473 {//세용액
    static int N;
    static int[] map;
    static int[] answer;
    static long answerSum = Long.MAX_VALUE;

    public static void func(int index)
    {
        int s = index+1;
        int e = N-1;//map[i]뒤부터
        long sum=0;

        while(true)
        {
            if(e<=s)
            {
                break;
            }
            sum = map[s]+map[e];

            if(Math.abs(answerSum) > Math.abs(sum+map[index]))
            {//합이 더 작은것으로 갱신
                answer[0] = map[index];
                answer[1] = map[s];
                answer[2] = map[e];
                answerSum=sum+map[index];
            }

            if(map[index]+sum > 0)
            {//양수가 크다
                e--;
            }
            else if(map[index]+sum==0)
            {
                answer[0] = map[index];
                answer[1] = map[s];
                answer[2] = map[e];
                break;//0이면 그만봐도됨
            }
            else
            {//음수가 크다
                s++;
            }
        }


    }
    public static void main(String[] argse) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
        {        
            map[i]=Integer.parseInt(st.nextToken());
        }

        answer = new int[3];
        
        Arrays.sort(map);

        //map[i] 기준으로 sum이 가장작은 두 수를 찾는다
        for(int i=0;i<N;i++)
            func(i);

        Arrays.sort(answer);
        for(int i=0;i<3;i++)
            System.out.print(answer[i]+" ");//정렬한 뒤 출력

    }
}
