import java.util.*;
import java.io.*;
class Main10942 {//팰린드롬
    public static void main(String[] argse) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] map = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
        {        
            map[i]=Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for (int m = 0; m < M; m++)
        {        
            st = new StringTokenizer(br.readLine());
            int S=Integer.parseInt(st.nextToken())-1;
            int E=Integer.parseInt(st.nextToken())-1;

            boolean b=true;
            int s=S;
            int e=E;
            while(true)
            {
                if(e<=s)
                {
                    break;//다봤다
                }
                
                if(map[s]==map[e])
                {//같으면 다음칸본다
                    s++;//s는 뒤로
                    e--;//e는 뒤로
                }
                else
                {//팰린드롬 아니다
                    b=false;
                    break;
                }
            }

            if(b==true)
                sb.append("1\n");
            else
                sb.append("0\n");
        }//DP로 고쳐보기
        System.out.print(sb);
    }
}
