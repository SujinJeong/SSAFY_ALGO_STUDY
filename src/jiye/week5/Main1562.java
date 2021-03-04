import java.util.*;
import java.io.*;
class Main1562 {//계단수
    static int N;
    static int[][][] arr;
    public static int func(int n, int i, int status)
    {
        // System.out.print(n+" "+i+" "+Integer.toBinaryString(1024 | status));

        if(n==N)
        {
            // System.out.println(" "+status);
            if (status == 1023)
                return 1;//1023 = 111111111111   -> 0~9 다 사용했으면 개수1++
            return 0;
        }
    // System.out.println();

        //현재 상태 status 3번째 자리 4인 세자리수 234 func(3,4, )
        //9876543210
        //0000011100 234 2,3,4를 썼다
        // | 연산
        //0000011100 2343  2,3,4 썼다      func(4,3, ) 4번째자리 3인 네자리수 2343
        //0000111100 2345  2,3,4,5 썼다    func(4,5, ) 4번째자리 5인 네자리수 2345

        //n=5      n=6에서
        //98765
        //98767
        //98787 -- 7로 끝나고 status 1110000000
        //98789
        //98987 -- 얘를 안봄
        //98989

        if(arr[n][i][status]!=0)
        {//n자리 숫자가 i이고 (숫자 뭐썼는지)상태 --이전단계에서 본적이 있으면..dp...
            // System.out.println(n+" "+i+" "+Integer.toBinaryString(1024 | status) +" | "+status+" "+arr[n][i][status]);
            return arr[n][i][status];
        }

        if(i-1>=0)
            arr[n][i][status] += func(n+1,i-1,status | (1<<(i-1)));//뒤에 작은수를 붙인다
            //n+1자리 숫자가 i-1인것

        if(i+1<=9)
            arr[n][i][status] += func(n+1,i+1,status | (1<<(i+1)));//뒤에 큰 수를 붙인다
            //n+1자리 숫자가 i+1인 것

        arr[n][i][status]%=1000000000;

        return arr[n][i][status];
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());


        arr = new int[N + 1][10][1 << 10];// N자리수, 끝자리수i 0~9, 썼는지 안썼는지 상태

        int sum=0;
        // 한자리 숫자, 1자리 숫자가 1인, 0000000010   부터 시작
        for (int i = 1; i < 10; i++)
        {//0으로 시작하는거 x
            int a= func(1, i, 1 << i);
            sum += a;
            sum %= 1000000000;
            // System.out.println(a);
        }
        System.out.println(sum);
    }
}
