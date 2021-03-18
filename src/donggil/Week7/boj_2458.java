package donggil.Week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//Logic
//Floyd-Warshall 과 BFS로 해결할 수 있는 문제
//풀이 시간 : 30분
public class boj_2458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken()), M = Integer.parseInt(stk.nextToken()), answer = 0;
        boolean[][] arr = new boolean[501][501];
        int[] answerArr = new int[501];
        for(int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(stk.nextToken())][Integer.parseInt(stk.nextToken())] = true;
        }

        //Floyd-Warshall => O(N^3)
        //이 알고리즘으로 i부터 j까지 k를 거쳐서 갈 수 있는지 다 체크
        //결과적으로 i에서 갈 수 있는 노드의 개수를 다 체크해줄 수 있음
        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    if(!arr[i][k] || !arr[k][j]) continue;
                    arr[i][j] = true;
                }
            }
        }
        //BFS => O(N^2)
        for(int i = 1; i <= N; i++) {
            BFS(i, N, arr);
        }

        //행 하나 선택
        for(int i = 1; i <= N; i++) {
            //선택한 행에 대해서 열을 검증
            for(int j = 1; j <= N; j++) {
                //현재 i노드에서 갈 수 있는 노드 개수 + 어떤 노드로부터 i노드로 올 수 있는 개수
                //위 두 합이 N - 1(자기 자신 제외)이면 자신의 키 순서를 알 수 있는 학생
                if(arr[i][j]) answerArr[i]++;
                if(arr[j][i]) answerArr[i]++;
            }
        }
        for(int i = 1; i <= N; i++) {
            if(answerArr[i] == N - 1) answer++;
        }
        System.out.println(answer);
    }
    //BFS를 이용해서 start노드로부터 갈 수 있는 모든 노드를 check
    private static void BFS(int start, int N, boolean[][] arr) {
        boolean[] visited = new boolean[501];
        Queue<Integer> Q = new LinkedList<>();
        visited[start] = true;
        Q.add(start);

        while(!Q.isEmpty()) {
            int node = Q.poll();

            for(int i = 1; i <= N; i++) {
                if(!visited[i] && arr[node][i]){
                    arr[start][i] = true;
                    visited[i] = true;
                    Q.add(i);
                }
            }
        }
    }
}
