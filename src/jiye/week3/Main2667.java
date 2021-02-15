import java.util.*;
import java.io.*;
class Main2667 {//단지 번호 붙이기
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int count;//단지 수

    public static void func(int x, int y)
    {
        visited[x][y]=true;
        count++;

        if(x+1<N && map[x+1][y]==1 && visited[x+1][y]==false)
        {//아래
            func(x+1,y);
        }
        if(x-1>=0 && map[x-1][y]==1 && visited[x-1][y]==false)
        {//위
            func(x-1,y);
        }
        if(y+1<N && map[x][y+1]==1 && visited[x][y+1]==false)
        {//오른쪽
            func(x,y+1);
        }
        if(y-1>=0 && map[x][y-1]==1 && visited[x][y-1]==false)
        {//왼쪽
            func(x,y-1);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0;i<N;i++)
        {
            String str = br.readLine();
            for(int j=0;j<N;j++)
            {
                map[i][j] = str.charAt(j)-'0';
            }
        }//입력

        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(map[i][j]==1 && visited[i][j]==false)
                {
                    func(i,j);
                    al.add(count);//단지 수 넣기
                    count=0;
                }
            }
        }
        Collections.sort(al);//오름차순 정렬

        StringBuilder sb = new StringBuilder();
        sb.append(al.size()+"\n");
        for(int i=0;i<al.size();i++)
            sb.append(al.get(i)+"\n");

        System.out.print(sb);
    }
    
}
