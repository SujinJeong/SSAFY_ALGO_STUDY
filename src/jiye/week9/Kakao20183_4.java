import java.util.*;
class Solution3_4 {//파일명 정렬
    static class Text{
        int index;//들어온 순서
        String str;//원래 문자열
        String head;
        int num;
        public Text(int index, String str, String head, int num)
        {
            this.index = index;
            this.str = str;
            this.head = head;
            this.num = num;
        }
    }
    public String[] solution(String[] files) {
        
        PriorityQueue<Text> pq = new PriorityQueue<Text>(new Comparator<Text>(){
            public int compare(Text t1, Text t2)
            {
                if(t1.head.compareToIgnoreCase(t2.head)==0)
                {//같으면
                    if(t1.num==t2.num)
                        return t1.index - t2.index;//먼저 들어온 순
                    return t1.num - t2.num;//숫자 작은 순
                }
                else
                    return t1.head.compareToIgnoreCase(t2.head);//대소문자 구분없이 Head작은 순
            }
        });
        
        int N = files.length;//파일 개수
        String[] answer = new String[N];
        
        for(int n=0;n<N;n++)
        {//pq에 넣어준다
            String str = files[n];
            int M = files[n].length();
            String head = "";
            int number=0;
            int index=0;//숫자부분 시작 인덱스
            for(int i=0;i<M;i++)
            {
                int a = str.charAt(i)-'0';
                if(a>=0 && a<=9)
                {//숫자가 처음으로 나오면
                    head = str.substring(0,i);//여기까지 잘라
                    index=i;
                    break;
                }
            }

            int cnt=0;
            for(int i=index;i<M;i++)
            {//숫자부터
                int a = str.charAt(i)-'0';
                if(a>=0 && a<=9)
                {//숫자가 나오면
                    cnt++;
                }
                else
                {//아닌게 나오면
                    break;
                }
                if(cnt==5)
                    break;//5까지만
            }
            number = Integer.parseInt(str.substring(index,cnt+index));

            System.out.println(head+"|"+ number);
            pq.add(new Text(n, str, head, number));
        }
        
        int i=0;
        while(pq.size()!=0)
        {//순서대로 answer에 저장
            Text text = pq.poll();
            String str = text.str;
            answer[i] = str;
            i++;
        }

        // System.out.println(Arrays.toString(answer));
        return answer;
    }
}