package sujin.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10476 {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int K = Integer.parseInt(st.nextToken());
      int[][] arr = new int[N+1][2];
      
      for (int i = 1; i <= N; i++) {
         st = new StringTokenizer(br.readLine());
         arr[i][0] = Integer.parseInt(st.nextToken());
         arr[i][1] = Integer.parseInt(st.nextToken());
      }
      
      int[][][] dp = new int[N+1][K+1][3];
      
// 초기화 아래와 같은 식으로 하고 dp 2번째 인자 크기를 k+1로 하면 오류나는 이유는 만약 k==0일때 dp[1][1]에 접근할 수 없어서 인덱스 오류
//      dp[1][1][0] = arr[1][1];
//      dp[1][1][1] = arr[1][0];
//      dp[1][0][2] = arr[1][0] + arr[1][1];

   // 0 : 1번 닫기 1: 2번 닫기 2: 모두 안 닫기
      for (int i = 1; i <= N; i++) {
         for (int j = 0; j <= K; j++) {
            if(j >= 1) {
               dp[i][j][0] = Math.max(dp[i - 1][j - 1][0], dp[i - 1][j - 1][2]) + arr[i][1];
               dp[i][j][1] = Math.max(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]) + arr[i][0];
            }
            // 이 경우는 앞에까지 하나씩은 차지하기 때문에 절대 두자리 다 빌 수가 없음
            // 만약 k가 0(즉, 닫는 문이 없을때) dp 끝까지 이것만 계속 계산! k=0일때 처리 안하면 틀림
            if (i != j) 
            	dp[i][j][2] = Math.max(dp[i - 1][j][0], Math.max(dp[i - 1][j][1], dp[i - 1][j][2]))
            	+ arr[i][0] + arr[i][1];
         }
      }
      System.out.println(Math.max(dp[N][K][0], Math.max(dp[N][K][1], dp[N][K][2])));
   }
}