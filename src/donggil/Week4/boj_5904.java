package donggil.Week4;

import java.util.Scanner;

public class boj_5904 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[30];
        arr[0] = 3;
        int N = sc.nextInt(), idx = 0;

        for(int i = 1, k = 4; i < arr.length; i++, k++) {
            arr[i] = arr[i - 1] * 2 + k;
            if(arr[i] >= N) {
                idx = i;
                break;
            }
        }
        for(int i = idx; i > 0; i--) {
            if(arr[i - 1] + 1 == N) {
                System.out.println('m');
                return;
            } else {
                if(N > (arr[i - 1] + 1) && N < arr[i - 1] + (4 + i))  {
                    System.out.println('o');
                    return;
                } else if(N >= (arr[i - 1] + (4 + i))) {
                    N -= (arr[i - 1] + 3 + i);
                }
            }
        }

        if(N == 1) {
            System.out.println('m');
        } else {
            System.out.println('o');
        }
    }
}
