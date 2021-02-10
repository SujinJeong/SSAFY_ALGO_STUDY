import java.io.*;
import java.util.*;
 class Main3584 {
    static int answer;
    static ArrayList<ArrayList<Integer>> al;
    static int[] arr1;
    static int[] arr2;

    public static void find(int target, int index)
    {
        if(al.get(target).size()==0)
            return;

        int a = al.get(target).get(0);//target의 부모
        arr1[index] = a;
        find(a, index+1);//target의 부모의 부모를 찾는다
    }

    public static void check(int target, int index)
    {
        if(al.get(target).size()==0)
            return;

        int a = al.get(target).get(0);
        arr2[index] = a;

        for(int i=0;i<arr1.length;i++)
        {
            if(arr1[i]==0)
                break;//뒤에 더 없음
            if(a ==arr1[i])
            {
                answer = a;//공통조상을 찾았다
                return;
            }
        }
        check(a, index+1);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++)
        {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st;
            // int[][] arr = new int [N-1][2];
            al = new ArrayList<ArrayList<Integer>>();
            for(int i=0;i<=N;i++)
                al.add(new ArrayList<Integer>());

            for(int i=0;i<N-1;i++)
            {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());//부모
                int b = Integer.parseInt(st.nextToken());//자식
                al.get(b).add(a);//자식 arraylist에 부모 넣는다 부모는 1개
            }
            
            st = new StringTokenizer(br.readLine());
            int target1 = Integer.parseInt(st.nextToken());
            int target2 = Integer.parseInt(st.nextToken());

            //순서대로 조상찾기
            arr1 = new int[N];
            arr2 = new int[N];
            arr1[0] = target1;
            find(target1,1);

            arr2[0] = target2;
            check(target2,1);

            System.out.println(Arrays.toString(arr1));
            System.out.println(Arrays.toString(arr2));

            System.out.println(answer);
        }
    }
    
}
