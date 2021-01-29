package jiye.week1;
import java.util.*;

class Main9012 {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for(int t=0;t<T;t++)
        {
            Stack<Integer> stack = new Stack<Integer>();
            String str = sc.next();
            boolean b = true;
            for(int i=0;i<str.length();i++)
            {
                if(str.charAt(i)=='(')
                {
                    stack.push(1);//스택에 넣는다
                }
                else
                {
                    if(stack.size()==0)
                    {
                        b=false;//안맞는경우
                        break;
                    }
                    else
                    {
                        stack.pop();//뺀다
                    }
                }
            }
            if(stack.size()!=0||b==false)
            {
                    sb.append("NO\n");
            }
                else
                    sb.append("YES\n");
        }
        System.out.println(sb);
    }
    
}
