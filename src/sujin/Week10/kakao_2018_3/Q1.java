package sujin.Week10.kakao_2018_3;
/* N진수게임 */
public class Q1 {
	public String solution(int n, int t, int m, int p) {
		// n:진법, t:구할 숫자의 개수, m:게임인원, p:튜브순서
        char[] changeN = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        String numberLen = "";        //답지
        int nCnt = 0;          //0부터 진수로 변환 시작
 
        // 총 횟수 : t*m만큼 반복
        while(numberLen.length() < t * m) {
            int N = nCnt;
            int B = n;
            String tempString = "";
            
            while(N / B != 0) {
                tempString = changeN[N%B]+ tempString;     //역순으로 넣어주는 이유는 진법 계산을 참고
                N /= B;                                        //N을 진수로 나눈 몫으로 업데이트
            }
            
            tempString = changeN[N%B] + tempString;        //몫이 0이되서 나머지를 따로 추가해 
            numberLen += tempString;                        //진수로 변환 시킨 것을 답지에 추가해주기
            nCnt++;                                    //다음 계산할 수 ++
        }
        
        String answer = "";
        for(int i = p-1; i < t*m; i +=m) {                    
            answer += numberLen.charAt(i);
        }        
        return answer;
    }
	
}
