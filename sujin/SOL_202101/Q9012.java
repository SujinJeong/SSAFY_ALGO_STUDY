package sujin.SOL_202101;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
/*
6
(())())
(((()())()
(()())((()))
((()()(()))(((())))()
()()()()(()()())()
(()((())()(

3
((
))
())(()
*/
public class Q9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Stack<Character> st = new Stack<Character>(); // '(' 저장
        boolean isLast = false;

        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
        	//입력 
            String s = br.readLine();
            
            //풀이
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) =='(')
                    st.push(s.charAt(j));
            
                else if (s.charAt(j) == ')') {
                    if (st.isEmpty()) { // ')' 더 많은 경우
                        isLast = false;
                        break;
                    }
                    else { // 스택이 안비어있고 '('가 스택에 남아있는 경우
                        st.pop();
                    }

                    // 만약 마지막 인덱스인 경우 = 드디어 올바른 문자열
                    if (j == (s.length()-1))
                        isLast = true;
                }
            }
            
            // 출력
            if (isLast)
                if(st.empty() == true) {
                    bw.write("YES");
                    bw.newLine();
                }
                // '(' 더 많은 경우
                else {
                	bw.write("NO");
                    bw.newLine();
                }
            else {
            	bw.write("NO");
                bw.newLine();
            }
            	
            st.clear();
        }
        bw.flush();
    }
}
