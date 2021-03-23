import java.util.*;
import java.io.*;
class Main1701 {//Cubeditor
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String STR = br.readLine();
        int N = STR.length();
        int max=0;
        
        for(int start=0;start<N;start++)
        {//한번 pi를 구하는게 아니라 start~N까지 봐야한다
            String str = STR.substring(start);
            // System.out.println(str);
            int s=0;
            int[] pi = new int[N-start];
            for (int i = 1; i < str.length(); i++) {
                while (s > 0 && str.charAt(i) != str.charAt(s)) {
                    s = pi[s - 1];
                }
    
                if (str.charAt(i) == str.charAt(s)) {
                    pi[i] = ++s;
                }
            }
    
            // System.out.println(Arrays.toString(pi));
            Arrays.sort(pi);
            if(max<pi[N-start-1])
                max = pi[N-start-1];//그중에 최대
        }
        System.out.println(max);
    }
}
