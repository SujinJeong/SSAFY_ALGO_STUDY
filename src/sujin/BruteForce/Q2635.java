package sujin.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q2635 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int max = Integer.MIN_VALUE;
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<>();
		ArrayList<Integer> clone = new ArrayList<>();
		for (int i = n; i >=n/2; i--) {
			
			// 0, 1 집어넣기
			arr.add(n);
			arr.add(i);
			
			// sol
			while (true) {
				int tmp = arr.get(arr.size()-2)-arr.get(arr.size()-1);
				if (tmp < 0) break;
				arr.add(tmp);
			}
			if (max < arr.size()) {
				max = arr.size();
				clone = (ArrayList<Integer>) arr.clone();
			}
			arr.removeAll(arr);
		}
		
		System.out.println(max);
		for (int i : clone)
			System.out.print(i + " ");

	}

}
