package hoyeong.week8;
//값이 너무 크니까 완전탐색은 안됨
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
// 동물이 좌표 값으로 나타나므로 사대 -> 동물 찾기는데 시간이 많이 걸림
// 동물 -> 사대(1차원 배열)

class Dot implements Comparable<Dot>{
	int x,y;
	boolean check;

	public Dot(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Dot o) {
		return this.x - o.x;
	}
}
public class back_8983 {
	static int N,M,result;
	static long L;
	static int [] arr;
	static Dot[] animal; // 실행 시간 : Array > 808, Arraylist > TLE, PriorityQueue > 918 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Long.parseLong(st.nextToken());
		arr = new int[N];
		animal = new Dot[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); // 사대
		}
		
		Arrays.sort(arr); // 정렬
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			animal[i] = new Dot(x,y);
		}
		
		for(int i=0; i<M; i++) {
			Dot d = animal[i];
			int x = d.x;
			int y = d.y;
			int low = 0, high = N-1;
			while (low <= high) {
				int mid = (low + high) / 2; // 선택 사로
				if(Math.abs(x-arr[mid])+y<=L) { // 사냥 가능
					result++;
					break;
				}
				else { // 사냥 불가능
					if(x<arr[mid]) { // x값 기준으로 옮기기
						high = mid-1;
					}
					else if(x>arr[mid]) {
						low = mid+1;
					}
					else break; // x값이 같을 때 사냥이 불가능하다면 불가능한것
				}
			}
		}
		System.out.println(result);
	}

}
