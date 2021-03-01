import java.util.*;
import java.io.*;
class Main17073 {//나무위의 빗물
    static int N;
    static ArrayList<ArrayList<Integer>> al;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        al = new ArrayList<>();
        for(int i=0;i<N+1;i++)
        {
            al.add(new ArrayList<>());
        }

        for(int i=0;i<N-1;i++)
        {
            st  = new StringTokenizer(br.readLine());
            int a =Integer.parseInt(st.nextToken());
            int b =Integer.parseInt(st.nextToken());
            al.get(a).add(b);
            al.get(b).add(a);
        }

        // Pi가 0보다 큰 정점들에 대해서 Pi들의 평균이라서
        //20/5가 아니라 20/3
        // 1   2   3   4   5
        // 0  10  10 
        // 0  10   0   5   5  -> 20/3


        int cnt=0;
        for(int i=2;i<N+1;i++)
        {//1은 무조건 자식이 있음
            if(al.get(i).size()==1)
            {//자식이 없는 노드
                cnt++;
            }
        }
        System.out.println((double)W/cnt);
    }
    
}
