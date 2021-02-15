package week3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class back_3584 {
	static int N, find1, find2;
	static LinkedList<Integer>[] list;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			
			N = Integer.parseInt(br.readLine());
			list = new LinkedList[N+1];
					
			for(int j=0; j<=N; j++) list[j] = new LinkedList<>();
			
			for(int j=0; j<N-1; j++) {
			st = new StringTokenizer(br.readLine());
			int par = Integer.parseInt(st.nextToken());
			int chil = Integer.parseInt(st.nextToken());
			
			list[chil].add(par);
			
			}
			st = new StringTokenizer(br.readLine());
			find1 = Integer.parseInt(st.nextToken());
			find2 = Integer.parseInt(st.nextToken());
			
			dfs();
		}
		System.out.println(sb.toString());
	
	}
	private static void dfs() {
		int deeper = cnt_node(find1) >= cnt_node(find2) ? find1 : find2;
		int deep = cnt_node(find1) < cnt_node(find2) ? find1 : find2;
		
		if (cnt_node(find1) != cnt_node(find2)) {
			
			for (int i = 0; i <= cnt_node(deeper) - cnt_node(deep); i++) {
				deeper = list[deeper].get(0);
			}
		}
            while (deeper != deep && list[deeper].size()!=0 && list[deeper].size()!=0 ) {
				deeper = list[deeper].get(0);
				deep = list[deep].get(0);
			}
			sb.append(deeper+"\n");
		
		
	}
	
	private static int cnt_node(int node) {
		int cnt=0;
		int cur= node;
		while(list[cur].size()!=0) {
			cur = list[cur].get(0);
			cnt++;
		}
		return cnt;
	}
	
}
