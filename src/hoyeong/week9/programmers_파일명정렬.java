package hoyeong.week9;

import java.util.Arrays;
import java.util.Comparator;

public class programmers_파일명정렬 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] files = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};

		for(String str : solution(files))
			System.out.println(str);
	}
	
	public static String[] solution(String[] files) {
        
        Arrays.sort(files, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String h1 = o1.split("[0-9]")[0];
				String h2 = o2.split("[0-9]")[0];
				
				int result = h1.toLowerCase().compareTo(h2.toLowerCase());
				
				if(result == 0) { // 같을 때
					result = search(h1,o1)-search(h2,o2);
				}
				return result;
			}        	
		});
		return files;
	}
	
	public static int search(String str, String o1) {
		o1 = o1.replace(str, "");
		String num = "";
		for(int i=0; i<o1.length(); i++) {
			if(Character.isDigit(str.charAt(i)) && num.length() < 5) { // character이 문자인지 판별
				num+=o1.charAt(i);
			}
			else break;
		}
		return Integer.parseInt(num);
	}
}