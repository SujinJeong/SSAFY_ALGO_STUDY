import java.util.*;
import java.io.*;
class Main20055 {//컨베이어 벨트 위의 로봇
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] map = new int[N*2];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<2*N;i++)
        {
            map[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] visited = new boolean[N];//로봇 위치
        int C=0;//단계

        while(true)
        {
            C++;//시작할때 단계++
            //1. 회전
            int temp=map[2*N-1]; 
            for(int i=2*N-1;i>0;i--)
            {
                map[i] = map[i-1];
            }
            map[0] = temp;

            for(int i=N-1;i>0;i--)
            {//로봇도 같이 옮긴다
                visited[i] = visited[i-1];
            }
            visited[0]=false;//옆으로 옮겼으니까
            if(visited[N-1]==true)
            {//내려가는 위치에 로봇이 왔으면
                visited[N-1]=false;//바로 내린다
            }


            //2. 로봇의 이동
            //맨끝칸에는 없을 것이다 맨 앞칸도
            for(int i=N-2;i>=0;i--)
            {//가장 먼저 벨트에 올라간 로봇 부터
                if(visited[i]==true)
                {//칸에 로봇이 있으면
                    if(map[i+1]>=1 && visited[i+1]==false)
                    {//다음칸에 로봇이 없고 내구도가 1이상 남아있어야
                        visited[i+1]=true;
                        map[i+1]--;
                        visited[i]=false;//원래 있던 자리
                    }
                    //이동못하면 가만히 있는다
                }
            }
            if(visited[N-1]==true)
            {//내려가는 위치에 로봇이 왔으면
                visited[N-1]=false;//바로 내린다
            }

            //3. 로봇 올리기
            if(visited[0]==false)
            {//올라가는 칸에 없으면
                if(map[0]>=1)
                {//올릴 수 있으면
                    map[0]--;//내구도 깎아
                    visited[0]=true;
                }
            }

            //4. 내구도 0인 칸 개수
            int cnt=0;
            for(int i=0;i<2*N;i++)
            {
                if(map[i]==0)
                    cnt++;
            }

            if (cnt >= K)
            {
                System.out.println(C);
                break;
                //끝
            }
        }

    }
}
