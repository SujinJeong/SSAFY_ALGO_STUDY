package donggil.Week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//Logic

//1. 도착하는 마을 순으로 박스들을 1차 정렬해주고, 2차 우선순위로는 출발 마을순으로 정렬해준다.
//2. 박스를 꺼내서 각 마을지점에서의 박스 개수 배열인 arr에 대해 값 변경을 시작해준다
//  2-1. 박스를 꺼낸 뒤 시작마을과 끝마을구간에서 최대 박스값을 가져온다 => 트럭이 실을 수 있는 무게에서 빼야하기 때문
//  2-2. 하지만 해당 구간에 트럭 최대 하중과 동일한 박스 무게를 지닌 구간이 존재한다면 해당 구간에 현재 꺼낸 박스를 실을 수는 없음
//  2-3. 2-2가 아닐경우에는 각 구간에 최대값 - 트럭 하중을 다 더해준다. 그리고 박스을 실었다는 뜻으로 정답을 1 증가

//3. 그리디하게 각 구간에 최대한으로 집어 넣을 수 있는 박스 무게를 넣어주는 것이다.
//    박스 정렬 기준은 현재 위치가 어떻던지 간에 가장 빠르게 내려놓을 수 있는 목표,, 즉 도착마을이 가장 빠른 순이며
//    또한 그렇게만 정렬하면 답이없다... 시작지점이 뒤죽박죽이기에 시작지점도 오름차순으로 정렬해준다.

public class boj_8980 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] list;
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken()) , C = Integer.parseInt(stk.nextToken());
        int[] arr = new int[N + 1];
        int M = Integer.parseInt(br.readLine()), answer = 0;
        list = new int[M][3];

        for(int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            list[i][0] = Integer.parseInt(stk.nextToken());
            list[i][1] = Integer.parseInt(stk.nextToken());
            list[i][2] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                } else return o1[1] - o2[1];
            }
        });

        for(int[] tmp : list) {
            boolean flag = false;
            int max = 0;
            for(int idx = tmp[0]; idx < tmp[1]; idx++) {
                if(arr[idx] >= C) {
                    flag = true;
                }
                if(max < arr[idx]) max = arr[idx];
            }

            if(!flag) {//더 쪼개서 실을 수 없는 구간이 없는 경우
                int rem = C - max;
                if(rem > tmp[2]) rem = tmp[2];
                answer += rem;

                for(int idx = tmp[0]; idx < tmp[1]; idx++) {
                    arr[idx] += rem;
                }
            }
        }
        System.out.println(answer);
    }
}
