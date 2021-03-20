package donggil.Week3;

import java.io.*;
import java.util.StringTokenizer;

//전위, 중위 표기법을 가지고 후위 표기법으로 나타내는 문제
//상당히 오래걸렸던 문제이다

//Logic
//재귀로 풀 수 있는 문제
//전위의 루트를 중위에서 찾으면 해당 위치의 왼쪽 오른쪽은 서브 트리로 나누어지게됨
//1. 전위 표기법의 루트를 가지고 중위 표기법에서 해당 위치를 찾아준다
//2. 왼쪽, 오른쪽 서브트리로 분기한다.
//  2-1. 왼쪽 서브트리의 루트 노드는 전위 표기법에서 상위 트리의 루트위치 + 1이다
//  2-2. 오른쪽 서브트리의 루트 노드는 전위 표기법에서 상위 트리의 루트위치 + 중위 표기법에서 해당 루트노드와 동일한 idx - 탐색하기 시작한 위치 + 1
//3. 2-2의 로직을 생각해내는데 계속 복잡하게 인덱싱을 조작하면서 더 꼬이게 되어 글로 풀어써보고 작성하니 잘 풀렸다.
//4. 이 문제의 핵심은 문제에서 주어지는 수도코드를 보고 이해하여 코드에 적용시키는 것이라고 생각한다.
//      => 이를 통해 글로 풀어써보고 인덱싱해주면 깔끔하게 풀린다

public class boj_4256 {
    private static int[] pre;
    private static int[] in;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int TestCase = Integer.parseInt(br.readLine());
        StringTokenizer stk;

        while(TestCase --> 0) {
            int N = Integer.parseInt(br.readLine());

            pre = new int[N];
            in = new int[N];

            stk = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                pre[i] = Integer.parseInt(stk.nextToken());
            }

            stk = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                in[i] = Integer.parseInt(stk.nextToken());
            }
            post(0, N, 0);
            sb.append("\n");
        }
        bw.write(String.valueOf(sb));
        bw.close();
        br.close();
    }
    private static void post(int start, int end, int root) {
        for(int i = start; i < end; i++) {
            if(pre[root] == in[i]) {
                post(start, i, root + 1);
                post(i + 1, end, root + i - start + 1);
                sb.append(in[i]).append(" ");
            }
        }
    }
}
