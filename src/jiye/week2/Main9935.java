import java.util.*;
import java.io.*;
class Main9935 {//문자열 폭발
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();//원래 문자열
        String frula = br.readLine();//폭발문자열
 

        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<str.length();i++)
        {
            sb.append(str.charAt(i));//일단 더하고
            int index = sb.length();//sb에 마지막 추가한 index
            if(sb.length()>=frula.length())
            {
                if(sb.substring(index-frula.length(),index).equals(frula))
                {//같으면 
                    sb.delete(index-frula.length(),index);
                }
            }
        }

            if(sb.length()==0)
                System.out.println("FRULA");
            else
                System.out.println(sb);
        
    }
    
}
