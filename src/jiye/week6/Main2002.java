import java.util.*;
import java.io.*;
class Main2002 {//추월
    public static void main(String[] argse) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String,Integer> in = new HashMap<String,Integer>();
        for(int i=0;i<N;i++)
        {
            String str = br.readLine();
            in.put(str,i);//키 이름 값 번호
        }

        Queue<Integer> out = new LinkedList<>();
        for(int i=0;i<N;i++)
        {
            String str = br.readLine();
            out.add(in.get(str));//그 이름에 해당하는 번호 큐에 넣기
        }

        // in  1 2 3 4                   1 2 3 4 5 6
        //out  4 1 2 3                   5 1 3 4 2 6
        //번호를 큐에 넣고
        //i번 '나올때까지' 뺀다 -> 개수++ 먼저나온차 visited true
        //이미 나온차는 넘어감
        //끝까지

        boolean[] visited=new boolean[N];//차가 나왔는지
        int i=0;//찾을 차 번호
        int answer=0;//먼저 나온 차 수

        while(out.size()>0)
        {
            if(visited[i]==true)
            {//이미 터널을 나온 차
                i++;
                continue;
            }

            int num = out.poll();

            if(num==i)
            {//순서에 맞으면
                visited[i]=true;
                i++;//그다음 차를 찾는다
            }
            else
            {//다른차가 먼저 나왔으면
                answer++;
                visited[num]=true;//나왔다고 체크
            }
        }
        System.out.println(answer);
    }
}
