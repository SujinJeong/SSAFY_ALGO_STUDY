import java.util.*;
class Solution3_5 {//n진수 게임
    public String solution(int n, int t, int m, int p) {
        String answer = "";

        char[] arr = new char[t*m];
        int num=0;
        int index=0;
        while(index < t*m)
        {
            int a = 0;
            while(true)
            {
                if(Math.pow(n,a) > num)
                    break;
                a++;
            }
            //a자리 수
            
            if(a==0)
            {
                arr[index]='0';
                index++;
                num++;
                continue;
            }
            
            char[] temp = new char[a];
            int nnum = num;
            int mm = num;//몫
            int nn =0;//나머지
            for(int c=0;c<a;c++)
            {
                mm = nnum/n;//몫
                nn = nnum - mm*n;//나머지
                char cc = Character.forDigit (nn, n);
                temp[c] = cc;
                nnum=mm;
            }
            // System.out.println(index+" "+num+" - "+Arrays.toString(temp));
            
            for(int c=a-1;c>=0;c--)
            {//뒤에서부터
                if(index>=t*m)
                    break;
                arr[index] = temp[c];
                index++;
            }
            num++;
        }
        
        for(int i=0;i<t;i++)
            answer+=arr[i*m+(p-1)];
        
        answer=answer.toUpperCase();
        return answer;
    }
}