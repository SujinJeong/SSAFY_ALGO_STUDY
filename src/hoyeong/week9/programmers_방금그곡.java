package hoyeong.week9;

import java.util.StringTokenizer;

public class programmers_방금그곡 {

    public static void main(String[] args) {
        String m = "ABC";
        String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        System.out.println(solution(m,musicinfos));
    }

    public static String solution(String m, String[] musicinfos) {
    	StringTokenizer st;
    	StringBuilder sb;
    	String answer = "(None)";
    	int save_time=0;
    	
    	m = makestring(m); // m 변환
    	int [] table = maketable(m);
    	
        String tmp, title;
        for(String str : musicinfos) {
        	st = new StringTokenizer(str,",");
        	tmp = st.nextToken();
        	int start = Integer.parseInt(tmp.substring(0,2)) * 60 + Integer.parseInt(tmp.substring(3,5));
        	tmp = st.nextToken();
        	int end = Integer.parseInt(tmp.substring(0,2)) * 60 + Integer.parseInt(tmp.substring(3,5));
        	
        	title = st.nextToken();
        	tmp = st.nextToken();
        	tmp = makestring(tmp);
        	int time = end-start;
        	
    		sb = new StringBuilder();
			for (int i = 0; i < time / tmp.length(); i++) {
				sb.append(tmp);
			}
			sb.append(tmp.substring(0, time % tmp.length()));
        	
        	
        	if(KMP(sb,m,table) && save_time < time) {
        		save_time = time;
        		answer = title;
        	}
        }
        return answer;
    }
    static String makestring(String m) { // 문자열 변환
    	m = m.replaceAll("C#", "c");
    	m = m.replaceAll("D#", "d");
    	m = m.replaceAll("F#", "f");
    	m = m.replaceAll("G#", "g");
    	m = m.replaceAll("A#", "a");
    	
    	return m;
    }
    
    static int [] maketable(String m) {
    	int len = m.length();
    	int [] table = new int[len];
    	int j=0;
    	for(int i=1; i<len; i++) {
    		while(j>0 && m.charAt(i)!=m.charAt(j))
    			j = table[j-1];
    		if(m.charAt(i)==m.charAt(j)) {
    			table[i] = ++j;
    		}
    	}
    	return table;
    }
    
    static boolean KMP(StringBuilder tmp, String m, int [] table) {
    	int tmp_len = tmp.length();
    	int j=0;
    	for(int i=0; i<tmp_len; i++) {
    		while(j>0 && tmp.charAt(i)!=m.charAt(j))
    			j = table[j-1];
    		if(tmp.charAt(i)==m.charAt(j)) {
    			if(j == m.length()-1) {
    				return true;
    			}
    			else ++j;
    		}
    	}
    	return false;
    }
}
