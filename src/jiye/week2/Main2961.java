import java.util.*;
import java.io.*;
class Main2961 {//도영이가 만든 맛있는 음식
    static int min=Integer.MAX_VALUE;

    public static int calc(int[] arrS, int[] arrB, int[] arr)
    {
        int S=1; int B=0;
        for(int i=0;i<arr.length;i++)
        {
            S*=arrS[arr[i]];
            B+=arrB[arr[i]];
        }
        return Math.abs(S-B);
    }
    public static void combi(int[] arrS, int[] arrB,int index, int a, int n, int[] arr)
    {//n개 조합
        if(index==n)
        {
            // System.out.println(Arrays.toString(arr) + calc(arrS, arrB, arr));
            if(min>calc(arrS, arrB, arr))
                min = calc(arrS, arrB, arr);
            return;
        }
        for(int j=a;j<arrS.length;j++)
        {
            arr[index]=j;
            combi(arrS,arrB,index+1,j+1,n,arr);
        }
    }
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] arrS = new int[N];
        int[] arrB = new int[N];
        for(int i=0;i<N;i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arrS[i]= Integer.parseInt(st.nextToken());
            arrB[i]= Integer.parseInt(st.nextToken());
        }


        // for(int i=1;i<=N;i++)
        // {
        //     combi(arrS, arrB, 0,0,i,new int[i]);
        // }
        
        func(0,arrS, arrB,1,0);
        System.out.println(min);
    }

    public static void func(int i, int[] arrS, int[] arrB,int s,int b)
    {
        if(b!=0)
        {
            System.out.println(i+" "+s+" "+b + " ."+Math.abs(s-b));
            if(min>Math.abs(s-b))
                min = Math.abs(s-b);
        }
        if(i==arrS.length)
            return;
        

        int S = s*arrS[i];
        int B = b+arrB[i];
        
        func(i+1,arrS,arrB,S,B);

        func(i+1,arrS,arrB,s,b);//이건 그럼 안넣은거
    }
}
//순열은 필요없구 넣는다 안넣는다 재귀 두개로 하면 된다구....