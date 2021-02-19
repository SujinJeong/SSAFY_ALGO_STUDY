package hoyeong.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class back_2437 {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		int sum=0;	
			for (int i = 0; i < N; i++) {
				if (arr[i] > sum+1) { // 합보다 1 크면 바로 이어받기 때문에 2가 커야한다
					break;
					}
				sum+=arr[i];
			}
			System.out.println(sum+1);
		}
	}

/*
1 1 2 >> 1 2 3 4
이후에 3이 왔을 때 >> 1 2 3 4 (2+3) (3+3) (4+3)

이후에 8이 오면 바로 이어 받아서 만들수 있는 수가 이어지기 때문에 sum+1보다 큰 수가 와야함
*/
