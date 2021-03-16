import java.util.*;
import java.io.*;
class Main16916 {//부분 문자열
    static String str1;
    static String str2;
    static int[] map;

    public static int check(int index, int m)
    {
        int cnt=0;
        for(int i=m;i<str2.length();i++)
        {
            if(index+i >= str1.length() || str1.charAt(index+i) != str2.charAt(i))
            {//str1뒤를 더 못보거나 다른 문자 나오면
                break;
            }
            else
                cnt++;//맞았다
        }

        return cnt;//맞은 개수 반환
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str1=br.readLine();
        str2=br.readLine();

        if(str1.length()<str2.length())
        {//str2가 더 길면 부분문자열일 수 없음
            System.out.println(0);
            return;
        }

        map = new int[str2.length()];//접두사 접미사 같은 길이 -- KMP알고리즘..
        // a   a b    a b a     a b a b    a b a b c     a b a b c b    a b a b c b a
        // 0   0 0    0 0 1     0 0 1 2    0 0 1 2 0     0 0 1 2 0 0    0 0 1 2 0 0 1
        int s=0;//앞에서부터 (접두사)
        for(int i=1;i<str2.length();i++)
        {//문자열 0~i까지
            while(s>0 && str2.charAt(i)!=str2.charAt(s))
            {//str2[s]랑 다르니까 그 전칸에서 같았던 개수만큼으로 돌아감..
                s=map[s-1];
            }

            if(str2.charAt(i)==str2.charAt(s))
            {
                s++;
                map[i]=s;//s개 같다
            }        
        }
        // System.out.println(Arrays.toString(map));

        boolean b=false;
        int i=0;
        int m=0;//str2
        while(i < str1.length())
        {//i는 str1을 앞에서부터 보는 인덱스
            int n = m + check(i,m);//m부터 비교해서 몇개 맞았는지
            if(n==str2.length())
            {//찾았다
                b=true;
                break;
            }

            if(n==0)
            {
                i+=1;//그냥 다음칸 보면 된다..
                m=0;//처음부터 봐야한다
            }
            else
            {
                i += n - map[n-1];//건너뛰고 볼 수 있다... 
                m = map[n-1];//여기부터 비교하면 됨
            }
        }

        if(b==true)
        System.out.println(1);
        else
        System.out.println(0);
    }
    
}
