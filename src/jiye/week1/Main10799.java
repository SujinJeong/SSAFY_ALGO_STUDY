package jiye.week1;
import java.util.*;

class Main10799 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer =0;
        String str = sc.next();
        Stack<Character> stack = new Stack<Character>();
        boolean b = false;//이전에 뭐가 들어왔는지 판단

        /* 
        (다음에 바로 )나오면 레이저!
        레이저로 자르면 막대수만큼 더 생긴다
        막대 끝에서 막대수 추가
        */

        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)=='(')
            {//막대시작
                stack.push('(');
                b=false;
            }
            else{
                stack.pop();
                if(b==false)// () 레이저
                    answer+=stack.size();
                else//막대끝
                    answer+=1;
                b=true;
            }
            
        }
        System.out.println(answer);
        sc.close();
    }
    
}
