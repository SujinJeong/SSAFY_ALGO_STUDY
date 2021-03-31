import java.util.*;
import java.io.*;
class Main8983 {//사냥꾼
    static int L;
    static int M;
    static int[] arr;//사대
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);//사대 위치 정렬

        int[][] animal = new int[N][2];

        for(int i=0;i<N;i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            animal[i][0] = a;
            animal[i][1] = b;
        }

        int answer =0;
        // for(int m=0;m<M;m++)
        // {
        //     answer += func(arr[m]);
        // }//사대 위치로 하면 너무 많이 봐야하고 L*m

        //그 a좌표에 있는 동물중에 총맞는 거...
        //사대 아니 그 사대 위치.. 계산을..
        //사대 좌표 x  x-L ~ x+L
        //            x >= a                     x < a 
        // (a,b) x y  x-a + b <= L  x <= L+a-b     a-x + b<=L  a+b-L <= x
        // (a,b) 동물이 맞으려면 x의 위치가  a - (L-b) <= x <= a + L-b 
        //그림그려보면 쉽다..  

        for(int i=0;i<N;i++)
        {
            if(bsearch(animal[i][0],animal[i][1])==true)
                answer++;//잡은 동물 수
        }

        System.out.println(answer);
    }

    public static boolean bsearch(int x, int y)
    {
        int low = 0;
        int high = M-1;//사대 인덱스

        // 동물을 쏠 수 있는 사대위치 찾기
        // x - (L-y)  ~ x ~  x + (L-y)
        int mid=0;
        while(low<=high)
        {
            mid = (low+high+1)/2;

            if(arr[mid] < x -(L-y))
            {//사대 위치가 작으면
                low = mid +1;
            }
            else if(arr[mid] > x + (L-y))
            {//크면
                high = mid-1;
            }
            else
                return true;//쏠수있다
        }
        return false;
    }
}
