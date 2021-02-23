import java.util.*;
import java.io.*;
class Main19539 {//사과나무
    static int[] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
        {
            int tree = Integer.parseInt(st.nextToken());
            map[i]=tree;
        }

        Arrays.sort(map);//정렬하고

        String answer="YES";

        for(int i=0;i<N;i++)
        {
            // System.out.println(i+"i "+map[i]);
            for(int k=0;k<N;k++)
                System.out.print(map[k]+" ");
            System.out.println();

            int rem= map[i]%3;//1또는 2의 물뿌리개
            map[i] = rem;//0, 1, 2
            
            map[i]-=rem;//1 또는 2 물뿌리개 씀 ->0됨
            
            if(rem!=0)
            {
                boolean b=false;

                if(i+1<N && map[i+1]>=(3-rem))
                {
                    map[i+1] -=(3-rem);
                }
                else
                {
                    answer="NO";
                    break;
                }

                // for(int j=i+1;j<N;j++)
                // {//뒤에 나무부터 본다
                //     if (map[j] >= (3-rem))                    
                //     {//뿌릴수있는 가장 먼저 만나는 나무
                //         map[j] -= (3-rem);//물뿌리개를 썼다 2이거나 1빼줌
                //         b=true;//물뿌리개 쓸수있다
                //         break;
                //     }
                // }

                // if(b==false)
                // {//물뿌리개 못썼다
                //     answer="NO";
                //     break;
                // }
            }
        }

        System.out.println(answer);
    }
}
