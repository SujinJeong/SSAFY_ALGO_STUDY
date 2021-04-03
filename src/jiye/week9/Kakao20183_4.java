import java.util.*;
class Solution3_4 {
    static class Text{
        String str;
        String head;
        int num;
        String tail;
        public Text(String str, String head, int num, String tail)
        {
            this.str = str;
            this.head = head;
            this.num = num;
            this.tail = tail;
        }
    }
    public String[] solution(String[] files) {
        
        PriorityQueue<Text> pq = new PriorityQueue<Text>(new Comparator<Text>(){
            public int compare(Text t1, Text t2)
            {
                if(t1.head.compareToIgnoreCase(t2.head)==0)
                {//같으면
                    // if(t1.num==t2.num)
                    // {//숫자도 같으면
                    //     return t1.tail.compareTo(t2.tail);
                    // }
                    // else
                        return t1.num - t2.num;//숫자 작은 순
                }
                else
                    return t1.head.compareToIgnoreCase(t2.head);//대소문자 구분없이 Head작은 순
            }
        });
        
        int N = files.length;//파일 개수
        String[] answer = new String[N];
        
        for(int n=0;n<N;n++)
        {
            String str = files[n];
            String str2 = str;
            int M = files[n].length();
            String head = "";
            int number=0;
            String tail="";
            int index=0;
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
                    break;
            }
            number = Integer.parseInt(str.substring(index,cnt+index));

            tail = str.substring(cnt+index,M);//끝까지

            System.out.println(head+" -- "+ number+" -- "+tail);
            pq.add(new Text(str2,head, number, tail));
        }
        
        int i=0;
        while(pq.size()!=0)
        {
            Text text = pq.poll();
            String str = text.str;
            answer[i] = str;
            i++;
        }

        System.out.println(Arrays.toString(answer));
        return answer;
    }
}