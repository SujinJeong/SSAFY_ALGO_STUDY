import java.util.*;
class Solution3_1 {//방금그곡
    static int[] arr;//임시배열
    static int[] map;//곡
    static int[] target;//들은 음악
    static int J;//들은 음악 길이
    static int time;//노래 재생 시간

    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int max=0;

        int M = m.length();
        arr = new int[M];
        
        J = change(m,M);//들은 음악 길이 J
        int[] target = new int[J];
        for(int i=0;i<J;i++)
            target[i] = arr[i];//target에 옮긴다

        int[] pi = new int[J];
        int s = 0;
        for(int j=1;j<J;j++)
        {
            while(s>0 && arr[s]!=arr[j])
            {
                s = pi[s-1];
            }
            if(arr[s]==arr[j])
                pi[j]=++s;
        }
        // System.out.println(Arrays.toString(pi));//얘만 있으면 되나..
        
        int N = musicinfos.length;
        for(int n=0;n<N;n++)
        {
            StringTokenizer st = new StringTokenizer(musicinfos[n],",");
            String str = st.nextToken();
            int start = Integer.parseInt(str.substring(0,2)) * 60 + Integer.parseInt(str.substring(3,5));
            str = st.nextToken();
            int finish = Integer.parseInt(str.substring(0,2)) * 60 + Integer.parseInt(str.substring(3,5));
            time = finish - start;//노래 길이
            if(time<J)
                continue;//노래길이가 들은거보다 짧으면 땡이지

            String title = st.nextToken();

            String melody = st.nextToken();
            int mm = melody.length();//패턴 길이..
            arr =  new int[mm];
            int P = change(melody,mm);//패턴 숫자로 arr에

            map = new int[time];//재생시간만큼 돈 음악... 
            if (time < P)
            {//재생시간까지 자르기
                for(int i=0;i<time;i++)
                {
                    map[i] = arr[i];
                }
            }
            else
            {//재생시간동안 반복하기
                int tt = time/P;//tt번 반복
                for(int i=0;i<tt;i++)
                {
                    for(int j=0;j<P;j++)
                    {
                        map[i*P+j] = arr[j];
                    }
                }
                for(int j=0;j<time-(tt*P);j++)
                    map[tt*P +j] = arr[j];
            }
            // System.out.println(Arrays.toString(map));

            boolean b= false;//맞는걸 찾았는지
            s=0;
            for(int j = 0; j < time; j++)
            {
                while(s>0 && map[j] != target[s])
                {
                    s = pi[s-1];
                }
                if(map[j]==target[s])
                {
                    if(s==J-1)
                    {//찾았으면
                        b=true;
                        break;
                    }
                    else
                        s++;
                }
            }

            if(b==true)
            {
                if(max < time)//재생시간이 긴 음악제목 반환
                {
                    answer=title;
                    max = time;
                }//break하면 다음꺼 못봄
            }
        }
            
        return answer;
    }

    public static int change(String m, int M)
    {//코드를 숫자로 변환
        int J=0;
        for(int i=0;i<M;i++)
        {
            char c= m.charAt(i);
            switch(c)
            {
                case 'B':
                    arr[J]=12;
                    break;
                case 'E':
                    arr[J]=5;
                    break;
                case 'A':
                    if(i+1<M && m.charAt(i+1)=='#')
                    {
                        arr[J]=11;
                        i++;
                    }
                    else
                        arr[J]=10;
                    break;
                case 'C':
                     if(i+1<M && m.charAt(i+1)=='#')
                     {
                         arr[J]=2;
                         i++;
                     }
                    else
                        arr[J]=1;
                    break;
                case 'D':
                     if(i+1<M && m.charAt(i+1)=='#')
                     {
                         arr[J]=4;
                        i++;
                     }
                    else
                        arr[J]=3;
                    break;
                case 'F':
                     if(i+1<M && m.charAt(i+1)=='#')
                     {
                         arr[J]=7;
                         i++;
                     }
                    else
                        arr[J]=6;
                    break;
                case 'G':
                     if(i+1<M && m.charAt(i+1)=='#')
                     {
                         arr[J]=9;
                         i++;
                     }
                    else
                        arr[J]=8;
                    break;
            }
            J++;
        }
        // System.out.println(Arrays.toString(arr));

        return J;//바꾸고난 배열 길이 반환
    }
}