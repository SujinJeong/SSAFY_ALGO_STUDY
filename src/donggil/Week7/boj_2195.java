package donggil.Week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Logic
//코드 내에 주석 달아놓음
//풀이 시간 : 30분
public class boj_2195 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String S = br.readLine();
        String P = br.readLine();
        int pLength = P.length(), cnt = 0;

        for(int i = 0; i < pLength; i++, cnt++) {
            boolean flag = true;    //S문자열 전체가 P에 포함되어지는 경우가 존재할 수 있으므로

            for(int j = i; j < pLength; j++) {
                //하나씩 잘라서 StringBuilder에 넣음
                sb.append(P.charAt(j));
                //S문자열에 원하는 부분 문자열이 존재하는지 확인
                if(!S.contains(sb.toString())) {
                    //없다면 현재 위치에서 다음에 잘라야할 i인덱스를 조작해주고
                    //flag를 false로 처리 => S자체가 P의 부분 문자열이 아님
                    flag = false;
                    i = j - 1;
                    break;
                }
            }
            if(flag)
                i += pLength;
            sb.setLength(0); //P를 잘라서 넣을 StringBuilder
        }
        System.out.println(cnt);
    }
}
