import java.util.*;
import java.io.*;
class Main14719 {//빗물
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] arr = new int[W];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<W;i++)
            arr[i] = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[H][W];
        for(int i=0;i<W;i++)
        {
            for(int h=0;h<arr[i];h++)
            {
                map[h][i]=true;//벽
            }
        }
            
        int answer=0;
        for(int i=0;i<H;i++)
        {
            int temp=-1;
            int cnt=0;
            for(int j=0;j<W;j++)
            {
                if(map[i][j]==true)
                {
                    if(temp>=0)
                    {
                        cnt += j - temp -1;//물이 찬 칸
                    }
                    temp=j;//그다음 벽
                }
            }
            answer += cnt;
        }

        System.out.println(answer);
    }
}
