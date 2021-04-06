package hoyeong.week9;

import java.util.ArrayList;

public class programerse_압축 {
	static int cnt=0;
	static ArrayList<String> list = new ArrayList<>(); // 사전
	public static void main(String[] args) {
		String msg = "ABABABABABABABAB";
		
		System.out.println(solution(msg));
	}
	static public int[] solution(String msg) {
        int[] answer = {}; // 결과값
        ArrayList<Integer> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder(); // stringbuilder의 delete 메소드 쓰기 위해
        sb.append(msg);
        
        String str="";
        int cnt=0;
        
		outloop:while (sb.length() != 0) {
			int i=sb.length();
			while (str.length() != 1) { // 문자 사전에 있는지 찾기
				str = sb.substring(0, i);
				if (list.contains(str)) { // 사전에 있다면
					result.add(27+list.indexOf(str));
					if(sb.length()>i) str = sb.substring(0,i+1); // 현재 문자열보다 한자리 긴 문자열 삽입
					list.add(str); 								// 마지막 문자열에서 i+1이 안먹힐 수 있으므로 조건 생성
					sb.delete(0, i); // 현재 문자열 제거
					cnt++;
					continue outloop;
				}
				i--;
			}
			if(sb.length()>=2) str = sb.substring(0,2); // 사전에 없는 경우 
			list.add(str);
			result.add((int)sb.charAt(0)-64);
			sb.delete(0,1);
			cnt++;
		}
        
        answer = new int [cnt];
        for(int i=0; i<cnt; i++)
        	answer[i] = result.get(i);
        	
        return answer;
    }

}
