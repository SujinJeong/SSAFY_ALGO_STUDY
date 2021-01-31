package study_0125;

import java.io.*;
import java.util.*;

public class BOJ_1966 {
	static Queue<Printer> printer = new LinkedList<Printer>();
	static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	static int TC, N, M;
	static StringTokenizer stk = null;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = Integer.parseInt(br.readLine());
		while (TC-- > 0) {
			stk = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(stk.nextToken());
			M = Integer.parseInt(stk.nextToken());
			
			String[] list = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				printer.add(new Printer(i, Integer.parseInt(list[i])));
				pq.add(Integer.parseInt(list[i]));
			}
			int seq = 0;
			while (!pq.isEmpty()) {
				if (printer.peek().getImportance() == pq.peek()) {
					pq.poll();
					seq++;
					if (printer.peek().getIndex() == M) {
						System.out.println(seq);
						printer.clear();
						pq.clear();
						break;
					}
					printer.poll();

				} else {
					printer.add(printer.peek());
					printer.poll();
				}
			}
		}
	}
}

class Printer {
	private int index;
	private int importance;

	public Printer(int index, int importance) {
		super();
		this.index = index;
		this.importance = importance;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getImportance() {
		return importance;
	}

	public void setImportance(int importance) {
		this.importance = importance;
	}

}