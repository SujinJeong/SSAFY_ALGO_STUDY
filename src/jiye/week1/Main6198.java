package jiye.week1;

import java.util.*;

class Main6198 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        long answer = 0;//아닛
        int N = sc.nextInt();
        Stack<Integer> st = new Stack<Integer>();
        int[] arr = new int[N];
        for (int n = 0; n < N; n++)
            arr[n] = (sc.nextInt());

        st.push(arr[0]);// 맨처음껀 그냥 넣기
        for (int n = 1; n < N; n++) {
            while(st.size()!=0)
            {
                if(st.peek()<=arr[n])
                    st.pop();//arr[n] 안보이면 빼고
                else
                    break;
            }
            
            answer+=st.size();//arr[n]이 보이는 개수
            st.push(arr[n]);
        }

        System.out.println(answer);
        sc.close();
    }
}
