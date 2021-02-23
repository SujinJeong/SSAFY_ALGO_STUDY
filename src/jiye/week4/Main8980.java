import java.util.*;
import java.io.*;
class Box{
    int to;
    int weight;
    public Box(int to, int weight)
    {
        this.to=to;
        this.weight=weight;
    }
}


class Main8980 {//택배
    static int N;
    static int C;
    static int M;
    static ArrayList<ArrayList<Box>> al;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());//마을 수
        C = Integer.parseInt(st.nextToken());//용량

        al = new ArrayList<ArrayList<Box>>();
        for(int i=0;i<N;i++)
            al.add(new ArrayList<Box>());

        M = Integer.parseInt(br.readLine());//박스 정보 수
        for(int i=0;i<M;i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            al.get(a).add(new Box(b,c));//보내는 마을에 box정보 담음
        }
        for(int i=0;i<N;i++)
        {
            Collections.sort(al.get(i),new Comparator<Box>(){
                @Override
                public int compare(Box o1, Box o2) {
                    return o1.to - o2.to;
                }
            });
        }
        //2 10, 3 20, 4 30순으로 정렬되어들어감 받는 마을 순

        PriorityQueue<Box> truck = new PriorityQueue<Box>(new Comparator<Box>(){
            @Override
            public int compare(Box o1, Box o2) {
                return o1.to - o2.to;
            }
        });
        //트럭에 담을 때 2 10, 3 20, 4 30순으로 정렬되어들어감

        int truckWeight=0;//현재 트럭 용량
        int answer=0;
        for(int i=1;i<N;i++)
        {
            //트럭에서 박스 내린다
            int size=truck.size();//트럭에 든개수
            for(int j=0;j<size;j++)//트럭에 뺄게 있으면
            {
                if(i==truck.peek().to)
                {//마을번호에 맞는 박스면
                    Box b= truck.poll();//맞는 박스 뺀다
                    answer+=b.weight;
                    truckWeight-=b.weight;
                    // System.out.println("- "+b.to+" "+b.weight);
                }
                else
                    break;//맨위에꺼가 안맞으면 볼 필요 없음
            }
            // System.out.println("빼고나서 현재 "+truckWeight);

            //트럭에 넣을만큼 넣는다
            for(int j=0;j<al.get(i).size();j++)//보낼 박스가 있으면
            {
                //트럭에 C보다 이하로 넣는다
                Box b = al.get(i).get(j);
                // System.out.println(b.to+" "+b.weight);
                if(truckWeight+b.weight<=C)
                {//안넘으면 다 넣는다
                    truck.add(b);
                    truckWeight+=b.weight;//트럭용량 증가
                }
                else//트럭용량 넘으면
                {
                    int ww=C-truckWeight;//남는 용량만
                    if(ww!=0)
                        truck.add(new Box(b.to,ww));
                    truckWeight+=ww;
                }
            }

            // System.out.println("넣고나서 현재 "+truckWeight);
        }

          //마지막 집 트럭에서 박스 내린다
          int size=truck.size();//트럭에 든개수
          for(int j=0;j<size;j++)//트럭에 뺄게 있으면
          {
              if(N==truck.peek().to)
              {//마을번호에 맞는 박스면
                  Box b= truck.poll();//맞는 박스 뺀다
                  answer+=b.weight;
                  truckWeight-=b.weight;
                //   System.out.println("- "+b.to+" "+b.weight);
              }
              else
                  break;//맨위에꺼가 안맞으면 볼 필요 없음
          }
        //   System.out.println("현재 "+truckWeight);
          System.out.println(answer);
    }
}
