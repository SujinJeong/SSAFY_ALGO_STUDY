import java.util.*;
import java.io.*;
class Main16900 {//이름 정하기
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        int K = Integer.parseInt(st.nextToken());

        int N = str.length();

        int[] pi = new int[N];
        int s = 0;
        for(int j=1;j<N;j++)
        {
            while(s>0 && str.charAt(j)!=str.charAt(s))
            {
                s = pi[s-1];
            }
            if(str.charAt(j)==str.charAt(s))
                pi[j]=++s;
        }
        // System.out.println(Arrays.toString(pi));

        //ababcaba 3
        //[0, 0, 1, 2, 0, 1, 2, 3]
        //   8   +   (K-1) * (8-3)
        //ababc aba  bcaba  bcaba

        long answer = (long)(N-pi[N-1])*(K-1) + N;//long으로 해야한다....
        System.out.println(answer);
    }
}
