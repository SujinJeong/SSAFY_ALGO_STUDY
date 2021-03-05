import java.util.*;
import java.io.*;
class Main15565{//귀여운 라이언
    public static void main(String[] argse) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        ArrayList<Integer> al = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
        {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i]==1)
                al.add(i);//라이언의 위치
        }

        
        if(al.size()<K)
            System.out.println(-1);//라이언이 K만큼 없다
        else
        {
            int min=987654321;

            //i번째 라이언 위치에서 K개까지의 위치 중 가장 작은것
            //가장 작은 연속된 인형들의 집합의 크기라고 했으니깐 K개여야함

            // for(int i=0;i+K-1<al.size();i++)
            // {
            //     if(al.get(i+K-1)-al.get(i)+1<min)
            //         min = al.get(i+K-1)-al.get(i)+1;
            // }
            // System.out.println(min);

            int s=0;
            int e=0;
            int num=0;
            while(true)
            {//투포인터...
                if(num>=K)
                {
                    s++;
                    num--;
                }
                else if(e==al.size())
                {
                    break;
                }
                else
                {
                    num++;
                    e++;
                }

                if(num==K)
                {
                    if((al.get(e-1)-al.get(s)+1)<min)
                        min = (al.get(e-1)-al.get(s))+1;
                }
            }
            System.out.println(min);
        }
     }
}