import java.util.*;
class Solution {//자동완성
    static int answer = 0;
    
    public int solution(String[] words) {
        Arrays.sort(words);
        int s = 0;
        int S = 0;
        int e = 0;
        int E = words.length;
//         while(true)
//         {
//             int c = 0;//c번째 글자
//             while(c < words[s].length())
//             {
//                 while(e<E)
//                 {//같을때까지
//                     if(words[s].charAt(c) == words[e].charAt(c))
//                     {//같으면
//                         System.out.println(target);
//                         answer++;//쓴다
//                         e++;//뒤로간다
//                     }
//                     else
//                     {//다른거 나오면
//                         // answer++;//쓴다
//                         s=e;//이제 이거 안본다
//                     }
//                 }
                
//                 System.out.println(e);
//                 E=e;

//                 c++;//그다음글자 본다
//             }
            
//         }
        func(words, 0,0,words.length);
        return answer;
    }
    
    public static void func(String[] words, int c, int s, int E)
    {//s부터 이전의 E까지 c번째 글자를 본다
        if(c==words[s].length())
            return;//다봤다
        
        int e=s;
        while(e<E)
        {//같을때까지
            if(words[s].charAt(c) == words[e].charAt(c))
            {//같으면
                System.out.println(c+" -- s"+s+" e"+e);
                answer++;//쓴다
            }
            else
            {//다른거 나오면
                func(words,c+1,s,e);
                // func(words,c,e,E);//e부터 보는거
                s=e-1;
                System.out.println(s+"  "+E);
            }
            e++;//뒤로간다
        }
        
    }
}