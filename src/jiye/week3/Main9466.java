import java.util.*;
import java.io.*;
class Main9466 {//텀프로젝트
    static int N;
    static int[] arr;
    static boolean[] visited;
    static boolean[] visited2;
    static ArrayList<Integer> al;//가리키는 수 넣기
    static int cnt;//팀을 이룬 학생수

    public static void func(int i)
    {
        if(visited[i]==true)
        {//거쳤던 i다
            return;
        }

        // System.out.println(i);
        al.add(i);
        visited[i]=true;//이번에 거치는 것
        
        if(visited[arr[i]]==false)//거쳤던 적이 없는 수
            func(arr[i]);//가리키는 것으로 가면되고
        else
        {//arr[i]가 거쳐왔던 노드면
            if(visited2[arr[i]]==false)
            {//이전함수?에서 거쳤던게 아니고 이번에 거친거면
                for(int j=al.size()-1;j>=0;j--)
                {
                    if(al.get(j)==arr[i])
                    {//몇전꺼까지 포함하는지 센다
                        cnt++;
                        break;
                    }
                    cnt++;
                }
                // System.out.println("["+cnt);
            }
            //그게 아니면 이전에 팀에 속했는지 아닌지 아는 학생들
        }
        
        visited2[i]=true;//돌던거 탈출하고 거쳤다고 저장
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++)
        {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr = new int[N+1];
            visited = new boolean[N+1];
            visited2 = new boolean[N+1];
            cnt=0;
            for(int i=1;i<N+1;i++)
            {
                arr[i]= Integer.parseInt(st.nextToken());
            }//입력

// i -> arr[i]                   1 2 3 4 5 6 7      al
// 1 ->  3               visited t f f f f f f       1 
//       3 ->  3         visited t f t f f f f       1 3
//            visited[3]이 true니까  al에서 몇개전에 3나왔나 센다 ->cnt1개
//visited2[1] visited2[3] true됨
//
// 2 ->  1               visited t t t f f f f       2
//     visited[1]이 true  visited2[1]도 true ->이전에 1로 시작하는거 봤었음
//ifelse문 통과  visited2[2] true됨
//
// 3 visited[3] true라서 끝
//
// 4 ->  7                visited t t t t f f f       4 
//       7 ->  6          visited t t t t f f t       4 7
//             6 ->  4    visited t t t t f t t       4 7 6
//         visited[4]이 true니까  al에서 몇개전에 4나왔나 센다 ->cnt3개
//visited2[4] visited2[6] visited2[7] true됨
//
// 5 도 2처럼 통과
// 6 7 은 visited true라서 끝

            for(int i=1;i<N+1;i++)
            {
                al = new ArrayList<Integer>();
                func(i);//i가 가리키는거 끝날때까지
            }

            System.out.println(N-cnt);
        }
    }
    
}
