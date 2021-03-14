import java.util.*;
import java.io.*;
class Main2195 {//문자열 복사
    static String str1;
    static String str2;
    
    public static int find(int a)
    {
        int max=0;
        for(int i=0;i<str1.length();i++)
        {
            if(str1.charAt(i)==str2.charAt(a))
            {//같은문자 찾는다
                int cnt=0;
                int ii=i;
                int j=a;
                while(ii<str1.length() && j<str2.length())
                {
                    if(str1.charAt(ii)!=str2.charAt(j))
                        break;//틀릴때까지 뒤에 본다
                    ii++;
                    j++;
                    cnt++;
                }
                if(cnt>max)
                    max=cnt;//가장 많은 개수가 같은 것
            }
        }
        return max;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str1=br.readLine();
        str2=br.readLine();


        //aaabbbabbbaaa
        //0 2  5 7 9 12

        int index=0;
        int answer=0;
        while(index<str2.length())
        {
            //str2[i]를 찾는다
            //그 뒤가 같으면 계속 본다 
            // System.out.println(index);
            index += find(index);//그 다음 볼 인덱스
            answer++;
        }
        System.out.println(answer);
    }
}
