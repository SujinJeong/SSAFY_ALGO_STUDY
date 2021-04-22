package sujin.Week10.kakao_2018_3;

import java.util.ArrayList;
import java.util.HashMap;

/* 압축 - NZW 알고리즘 */
public class Q2 {
	public static ArrayList<String> solution(String str) {
	    // 사전으로 사용할 맵을 생성하고 기초데이터를 입력
	    HashMap dicMap = new HashMap<String, String>();
	    char c = 'A';
	    int n = 1;
	    while(dicMap.size() < 26) {
	        dicMap.put(String.valueOf(c++), String.valueOf(n++));
	    } 
	    
	    // 메인소스
	    ArrayList<String> retList = new ArrayList<String>();
	    while(!str.isEmpty()) {
	        for(int i = str.length(); i > 0; i--) {
	            if(dicMap.containsKey(str.substring(0,i))){
	                String key = str.substring(0, i);
	                String nextKey = str.length() > i+1 ? str.substring(i, i+1) : "";
	                retList.add((String) dicMap.get(key));
	                if(!nextKey.isEmpty() && !dicMap.containsKey(key+nextKey)) { 
	                    dicMap.put(key+nextKey, String.valueOf(dicMap.size()+1));
	                }
	                str = str.substring(key.length());
	                break;
	            }
	        }
	    }
	    return retList;
	}
}
