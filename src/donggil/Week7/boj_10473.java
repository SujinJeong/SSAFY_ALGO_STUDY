package donggil.Week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_10473 {
    //Logic
    //대포는 원하는 방향까지 50m를 날려줄 수 있음
    //즉 대포로 날아가서 + 뛰어가는거 or 대포로 날아가서 바로 다음 대포에 도착 or 그냥 뛰어가는거
    //우선순위 큐에는 시간이 짧은 순으로 정렬
    //해당 위치까지 가는데 걸리는 시간이 갱신 될 경우에만 우선순위 큐에 넣어주며 대포 날아가고 아니고 예외는 아래의 dijkstra 함수에 주석으로 작성
    //대포는 25m/s 뛰는거는 5m/s

    //풀이 시간 : 50분... 문제 잘 읽자ㅠㅠㅠ
    public static void main(String[] args) throws IOException {
        ArrayList<double[]> list = new ArrayList<>();
        int N = inputInfo(list);
        double[][] dist = new double[N + 2][N + 2]; //각 노드들 간에 거리 정보
        double[] answer = new double[N + 2]; //시간 정보를 담아야함

        init(dist, list, answer);
        Dijkstra(dist, answer);

        System.out.print((float)answer[answer.length - 1]);
    }

    private static class Info {
        int node;
        double time;

        public Info(int node, double time) {
            this.node = node;
            this.time = time;
        }
    }

    private static int inputInfo(ArrayList<double[]> list) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double start_x, start_y, end_x, end_y;
        StringTokenizer stk = new StringTokenizer(br.readLine());
        start_x = Double.parseDouble(stk.nextToken());
        start_y = Double.parseDouble(stk.nextToken());
        stk = new StringTokenizer(br.readLine());
        end_x = Double.parseDouble(stk.nextToken());
        end_y = Double.parseDouble(stk.nextToken());
        int N = Integer.parseInt(br.readLine());
        list.add(new double[]{start_x, start_y});
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            list.add(new double[]{Double.parseDouble(stk.nextToken()), Double.parseDouble(stk.nextToken())});
        }
        list.add(new double[]{end_x, end_y});
        return N;
    }

    private static void init(double[][] dist, ArrayList<double[]> list, double[] answer) {
        int length = list.size();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i != j) {
                    double width = Math.abs(list.get(i)[0] - list.get(j)[0]);
                    double height = Math.abs(list.get(i)[1] - list.get(j)[1]);

                    dist[i][j] = Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
                }
            }
        }
        Arrays.fill(answer, 987654321.0);
    }

    private static void Dijkstra(double[][] dist, double[] answer) {
        final double runAcc = 5.0, flyAcc = 25.0;
        PriorityQueue<Info> Q = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if (o1.time > o2.time) return 1;
                else if (o1.time == o2.time) return 0;
                else return -1;
            }
        });
        int length = dist.length;
        Q.add(new Info(0, 0.0));

        while (!Q.isEmpty()) {
            Info elem = Q.poll();

            if (answer[elem.node] < elem.time) continue;

            for (int i = 0; i < length; i++) {

                double nextTime = 0F;

                if (elem.node == 0) {//처음에는 대포를 탈 수 없음....문제 잘 읽자...
                    double runTime = dist[elem.node][i] / runAcc;
                    answer[i] = runTime;
                    if (i != 0)
                        Q.add(new Info(i, answer[i]));
                    continue;
                }

                if (dist[elem.node][i] >= 50) { //대포 반경 외에 있을 때는 대포로 50미터 날아가서 뛰어가거나
                    double runTime = (dist[elem.node][i] - 50) / runAcc;
                    nextTime = runTime + 2 + elem.time;
                } else { //대포 반경 내에 있을 경우에는 대포로 50미터 날아가서 뛰어가거나 그냥 뛰어가거나
                    double flyTime = 2.0 + ((50 - dist[elem.node][i]) / runAcc);
                    double runTime = dist[elem.node][i] / runAcc;

                    if (flyTime > runTime) nextTime = runTime + elem.time;
                    else nextTime = flyTime + elem.time;
                }
                if (answer[i] > nextTime) {
                    answer[i] = nextTime;
                    Q.add(new Info(i, answer[i]));
                }
            }
        }
    }
}
