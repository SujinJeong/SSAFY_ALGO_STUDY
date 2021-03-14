import java.util.*;
import java.io.*;
class Main11779 {//최소비용 구하기 2
    static int N;
    static int[][] map;
    static int[] arr;
    static boolean[] visited;

    public static int findMin(int s)
    {//arr에서 가장 작은 값 찾는다
        int min=987654321;
        int index=0;
        for(int i=0;i<N;i++)
        {
            if(i!=s && min > arr[i] && visited[i]==false)
            {//최소값 찾음 방문하지 않은 도시
                min=arr[i];
                index = i;
            }
        }
        return index;//가장 작은 값이 있는 인덱스 반환
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());//버스
        
        map = new int[N][N];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
                map[i][j] = 987654321;//못가는 도시는 무한으로 남아있다
        }
        StringTokenizer st;
        for(int i=0;i<M;i++)
        {
            st = new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken())-1;
            int b=Integer.parseInt(st.nextToken())-1;
            int c=Integer.parseInt(st.nextToken());//비용
            map[a][b] = Math.min(c,map[a][b]);//금액이 여러개일때
        }

        st = new StringTokenizer(br.readLine());
        int S=Integer.parseInt(st.nextToken())-1;//시작도시
        int E=Integer.parseInt(st.nextToken())-1;//도착도시


        arr = new int[N];
        visited = new boolean[N];//방문한 도시 확인
        int cnt=0;//방문한 도시 수
        int[] answer=new int[N];//도착 도시까지 거친 도시 저장

        for(int i=0;i<N;i++)
        {//출발 도시에서 각 도시로 갈수있는 금액
            arr[i] = map[S][i];
            answer[i]=-1;
        }
        arr[S]=0;//시작점은 0으로
        visited[S]=true;
        cnt++;
        
        while(cnt<N)
        {//모든 값을 다 볼때까지
            int next = findMin(S);//출발도시.. 최소값 인덱스 반환
            // System.out.println(next);
            visited[next]=true;
            cnt++;
            //그럼 또 다음도시로 가서 각 도시로 돌아가는 금액 갱신
            //S->next->...
            for(int i=0;i<N;i++)
            {
                if(map[next][i]!=987654321)
                {//못가는 경우가 아니라면
                    int temp = arr[next] + map[next][i];//S->next + next->i
                    if(arr[i]>temp)
                    {
                        arr[i] = temp;//S->i vs next 거쳐가는 값
                        answer[i] = next;//next도시를 거쳐서 i값이 갱신되었다
                    }
                }
            }
        }
        
        int[] al = new int[N];
        int j=0;
        int e=E;//도착도시
        al[j]=e+1;

        while(answer[e]!=-1)
        {//갱신된 적이 없을때까지
            e = answer[e];//거쳐온 도시 8->3->2->1
            j++;
            al[j]=(e+1);
        }
        j++;
        al[j]=(S+1);

        // System.out.println(Arrays.toString(al));

        System.out.println(arr[E]);
        int num = j+1;//도시 수
        System.out.println(num);
        for(int i=j;i>=0;i--)
            System.out.print(al[i]+" ");//거꾸로 출력
    }
}
