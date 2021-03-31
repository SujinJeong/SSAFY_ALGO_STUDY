import java.util.*;
import java.io.*;

class Main1477{//휴게소 세우기
    public static int Count(int[] map, int temp)
    {//temp간격으로 휴게소 세웠을때 구간별로 세울 수 있는 개수
        int count=0;
        for(int i=0;i<map.length;i++)
        {
            if(map[i]%temp==0)
                count += map[i]/temp-1;//200 100 이면 두개가 아니고 한개 세움
            else
                count += map[i]/temp;
        }
        return count;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+2];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)//휴게소 N개
            arr[i] = Integer.parseInt(st.nextToken());

        arr[N]=0;//시작부분
        arr[N+1]=L;//끝부분

        Arrays.sort(arr);//정렬한다

        int[] map = new int[N+1];
        for(int i=0;i<N+1;i++)
        {
            map[i]=(arr[i+1]-arr[i]);
        }//휴게소가 없는 구간 저장
        Arrays.sort(map);//이것도 정렬한다

        int count=0;
        int n=N;
        
        int high = map[n];//맨위에꺼 빼러고...
        int low = 0;
        int mid = (high+low+1)/2;
        while(low<=high)
        {
            mid = (high+low+1)/2;//이 간격으로 휴게소를 세운다
            // System.out.print(high+"     "+low+"     "+mid);
            
            count = Count(map,mid);
            // System.out.println("-----"+count);
            if(count<=M)
            {//더 좁은 간격으로 세워야 한다
                //M이 나와도 작은게 되나 봐야함
                high = mid-1;
            }
            else
            {
                low = mid+1;//그냥 하나...
            }
        }
        System.out.println(low);
    }

}