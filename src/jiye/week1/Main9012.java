package jiye.week1;
import java.util.*;

class Main9012 {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();


        //(는 넣고 )등장하면 뺀다
        //(가 없는데 )가 등장하는 경우는 틀린거니까 바로 땡
        //다 돌고나서 스택에 들어있는게 없으면 ()잘맞는것
        //음 별거 없음..

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

        sc.close();
    }
}
