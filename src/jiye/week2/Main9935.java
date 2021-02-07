import java.util.*;
import java.io.*;
 class Main9935 {
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();//원래 문자열
        String frula = br.readLine();//폭발문자열

        StringBuilder sb = new StringBuilder();
        if(str.contains(frula)==false)
            System.out.println(str);
        else
        {
            while(str.contains(frula))
            {
                str=str.replaceAll(frula,"");
            }

            if(str.length()==0)
                System.out.println("FRULA");
            else
                System.out.println(str);
        }
    }
    
}
