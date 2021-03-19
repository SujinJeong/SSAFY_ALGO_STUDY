package donggil.Week2;

import java.io.*;

public class boj_9935 {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringBuilder str = new StringBuilder(br.readLine());
        String bomb = new String(br.readLine());
        char[] S = new char[1000001];
        int S_idx = 0;

        for(int i = 0; i < str.length(); i++) {
            S[S_idx++] = str.charAt(i);
            //문자열 탐색하다가 폭탄 문자열의 끝을 만나게 되는 경우
            //스택을 뒤져서 맨 끝 제외하고 모두 문자열이 맞는지 확인
            if(str.charAt(i) == bomb.charAt(bomb.length() - 1)) {
                boolean isBomb = true;
                int tmp_idx = S_idx - 1;
                for(int idx = bomb.length() - 1; idx >= 0; idx--, tmp_idx--) {
                    if(S_idx < bomb.length() - 1) {
                        isBomb = false;
                        break;
                    }
                    if(S[tmp_idx] != bomb.charAt(idx)) {
                        isBomb = false;
                        break;
                    }
                }
                if(isBomb) {
                    S_idx = tmp_idx + 1;
                }
            }
        }

        if(S_idx == 0) {
            sb.append("FRULA");
        } else {
            sb.append(String.valueOf(S, 0, S_idx));
        }
        sb.append("\n");
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
