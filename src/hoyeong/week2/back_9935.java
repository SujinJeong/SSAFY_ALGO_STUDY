package hoyeong.week2;
/*package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class back_9935 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static Queue<String> q1 = new LinkedList<>();
	static Queue<String> q2 = new LinkedList<>();
	static String [] strArray;
	static String [] bomb; 
	static String[] save;
	
	public static void main(String[] args) throws IOException {
//		List <String> list = new ArrayList<>();
		String str = br.readLine();
		strArray = str.split("");
		
		String str1 = br.readLine();
		bomb = str1.split("");
		save = new String[bomb.length];
				
		
		if(d.size()!=0) {
			for(String s:q1) sb.append(s);
		}
		else System.out.println("FRULA");
		if(sb!=null)System.out.println(sb.toString());
	}
	
	private static void bomb(){
		int cnt=0;
		for(int i=0; i<q1.size(); i++) {
			if(q2.size()==bomb.length) {q2.clear(); cnt++;}
			
			if(q1.peek().equals(bomb[q2.size()])) {
				q2.add(q1.poll());
				continue;
			}
			
			if(!q2.isEmpty()){
				while(!q2.isEmpty())
					q1.add(q2.poll());
				i--;
				continue;
			}
			
			q1.add(strArray[i]);
		}
		
		
		
		int cnt=0;
		if(d.peek().equals(strArray[0]) && cnt>=strArray.length)
			
		if(d.peek().equals(bomb[0])) {
			
			if(!Arrays.equals(bomb, save)) {
				for(int i=bomb.length-1; i>0; i--) {
					d.addFirst(save[i]);
				}
				d.addLast(save[0]);
			}
			else cnt=0;
		}
		else {
			d.add(d.poll());
			cnt++;
		}
	}

}

int compare=0;
while(true) {
	int compare1=compare;
for(int i=0; i<list.size(); i++) {
	if(list.get(i).equals(bomb[0])) {
		int cnt=0;
		for(int j=i; j<i+bomb.length; j++) {
			save[cnt++] = list.get(j);
		}
		if(Arrays.equals(bomb, save)) {
			for(int j=i; j<i+bomb.length;j++) {
				list.remove(i);
			}
			compare1++;
		}
	}
}
if(compare!=compare1) continue;
else break;
}		
*/