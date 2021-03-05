import java.util.*;
import java.io.*;
class Main9252 {//LCS 2
    public static void main(String[] argse) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        StringBuffer sb = new StringBuffer();

        //짧은 문자열 기준으로
        int[][] DP;
      
        if(str1.length()<=str2.length())
        {//str1기준
            DP= new int[str1.length()+1][str2.length()+1];

            for(int i=1;i<str1.length()+1;i++)
            {
                for(int j=1;j<str2.length()+1;j++)
                {
                    if(str1.charAt(i-1)==str2.charAt(j-1))
                    {
                        DP[i][j]=DP[i-1][j-1]+1;//대각선위+1
                    }
                    else
                        DP[i][j] = Math.max(DP[i-1][j],DP[i][j-1]);//두개중 최대값
                }
            }

            int max=DP[str1.length()][str2.length()];

            int x=str1.length();
            int y=str2.length();
            while(max>0)
            {
                for(int j=0;j<=y;j++)
                {//왼쪽으로 계속 간다
                    if(DP[x][y -j]!=max)
                    {//다를 때 까지
                        y=y-j+1;//그 전꺼
                        break;
                    }
                }
                for(int i=0;i<=x;i++)
                {//위로 올라간다
                    if(DP[x-i][y]!=max)
                    {//다를 때 까지
                        x=x-i+1;//그 전꺼
                        break;
                    }
                }

                sb.append(str1.charAt(x-1));
                max--;
                y--;
                x--;//대각선 위칸 으로
            }
        }
        else
        {//str2기준
            DP= new int[str2.length()+1][str1.length()+1];

            for(int i=1;i<str2.length()+1;i++)
            {
                for(int j=1;j<str1.length()+1;j++)
                {
                    if(str2.charAt(i-1)==str1.charAt(j-1))
                    {
                        DP[i][j]=DP[i-1][j-1]+1;//대각선위+1
                    }
                    else
                        DP[i][j] = Math.max(DP[i-1][j],DP[i][j-1]);//두개중 최대값
                }
            }

            int max=DP[str2.length()][str1.length()];

            int x=str2.length();
            int y=str1.length();
            while(max>0)
            {
                for(int j=0;j<=y;j++)
                {//왼쪽으로 계속 간다
                    if(DP[x][y -j]!=max)
                    {//다를 때 까지
                        y=y-j+1;//그 전꺼
                        break;
                    }
                }
                for(int i=0;i<=x;i++)
                {//위로 올라간다
                    if(DP[x-i][y]!=max)
                    {//다를 때 까지
                        x=x-i+1;//그 전꺼
                        break;
                    }
                }

                sb.append(str2.charAt(x-1));
                max--;
                y--;
                x--;//대각선 위칸 으로
            }
           
        }

  
        //lcs기본
        System.out.println(sb.length());    
        System.out.println(sb.reverse());
    }
}
