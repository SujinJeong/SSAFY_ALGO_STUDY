package jiye.week1;
import java.util.*;

class Main10799 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer =0;
        String str = sc.next();
        Stack<Character> stack = new Stack<Character>();
        boolean b = false;//이전에 뭐가 들어왔는지 판단
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)=='(')
            {
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
