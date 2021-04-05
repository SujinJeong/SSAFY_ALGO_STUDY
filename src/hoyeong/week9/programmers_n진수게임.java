package hoyeong.week9;

public class programmers_n진수게임 {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(16,16,2,1));
	}
	public static String solution(int n, int t, int m, int p) {
		StringBuilder result = new StringBuilder();
        String answer = "";
        for(int i=0; i<t*m; i++) {
        	change(n,i);
        }
        
        for(int i=0; i<sb.length(); i++) {
        	if(i%m == p-1) result.append(sb.charAt(i));
        	if(result.length()==t) break;
        }
        
        return result.toString();
    }
	public static void change(int n, int num) {
		StringBuilder ch = new StringBuilder();
		do {
			int r = num % n;
			if(r < 10) ch.append(r);
			else {
				if(r ==10) ch.append("A");
				else if(r == 11) ch.append("B");
				else if(r == 12) ch.append("C");
				else if(r == 13) ch.append("D");
				else if(r == 14) ch.append("E");
				else if(r == 15) ch.append("F");
			}
			num = num/n;
		}while(num>0);
		sb.append(ch.reverse().toString());
	}
}
