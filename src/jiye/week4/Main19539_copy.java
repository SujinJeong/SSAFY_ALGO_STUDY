import java.util.*;
import java.io.*;
class Main19539_copy {//사과나무
    static int[] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N];

        int num=0;
        int sum=0;//총합

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
        {
            int tree = Integer.parseInt(st.nextToken());
            map[i]=tree;

            sum+=tree;
            num+=tree/2;//2를 최대 몇번 뿌릴 수 있는지
        }

        //1물뿌리개 2물뿌리개 짝이 맞아야하니까 3의배수
        //3의배수라고 다 되는 건 아니고
        //2를 못뿌리는 경우를 생각...
        //(전체합/3) 일 걸린다
        //그만큼 2물뿌리개를 뿌릴 수 있는지!

        String answer="NO";

         if(sum%3==0)
        {
            if(num < sum/3)
            {
                answer="NO";
            }
            else
                answer="YES";
        }

        System.out.println(answer);
    }
}
