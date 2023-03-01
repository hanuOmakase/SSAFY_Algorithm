import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

// 익은 토마토 -> 위, 아래, 왼쪽, 오른쪽, 앞, 뒤 토마토에 영향
// 익은 토마토(1), 익지 않은 토마토(0), 빈 칸(-1)

/*

0 -1 0 0 0
-1 -1 0 1 1
0 0 0 1 1

빈 칸으로 둘러싸인 공간에 익지 않은 토마토 -> 절대 익지 않음
익지 않은 토마토 개수, 익은 토마토 개수 체크


(H*N x M)
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 1 0 0
0 0 0 0 0
익은 토마토(4, 2)

1일째
0 0 0 0 0
0 0 1 0 0
0 0 0 0 0
0 0 1 0 0
0 1 1 1 0
0 0 1 0 0
익은 토마토(i, j)
상하좌우 한 칸씩 + (1, 2)((i-N), j)
-> 만약 높이가 3이였으면 아래칸(7, 2)((i+N), j)
-> i-N, i+N 이 배열 범위 안인지 체크

2일째
0 0 1 0 0
0 1 1 1 0
0 0 1 0 0
0 1 1 1 0
1 1 1 1 1
0 1 1 1 0

3일째
0 1 1 1 0
1 1 1 1 1 
0 1 1 1 0
1 1 1 1 1
1 1 1 1 1
1 1 1 1 1

4일째
다익음

 */
public class Main_7569 { // 7569. 토마토
	
	static int M;
	static int N;
	static int H;
	static int newN;
	static int[][] box;
	static int day; // 모든 토마토가 익는 날짜 (출력값)
	static int zeroCnt; // 익지 않은 토마토 개수
	
	static Queue<Integer[]> queue = new ArrayDeque<Integer[]>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		newN = N * H;
		box = new int[newN][M];
		
		for (int i = 0; i < box.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < box[i].length; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 0) { zeroCnt++; } 
				else if (box[i][j] == 1) { queue.offer(new Integer[] { i, j }); }
			}
		}
		
		if (zeroCnt == 0) { // 이미 모든 토마토가 익어있는 상태
			System.out.println(0);
			return;
		}
		
		while(zeroCnt != 0 && !queue.isEmpty()) { // 익지 않은 토마토가 없거나, 큐가 비면 반복문 종료
			
			day++;
			int size = queue.size();
			while(size-- > 0) {
				Integer[] tomato = queue.poll();
				find(tomato[0], tomato[1]);
			
			}
			
//			System.out.println(day + "일차");
//			for (int i = 0; i < box.length; i++) {
//				System.out.println(Arrays.toString(box[i]));
//			}
		}
		
		if (zeroCnt != 0) { // 익지 않은 토마토가 남아있는 경우
			System.out.println(-1);
		} else {
			System.out.println(day);
		}
		
	}

	private static void find(int r, int c) {
		// 상
		if (r - 1 >= 0 && box[r - 1][c] == 0) {
			if (r % N != 0) { // 한 층의 가장 위쪽이 아니라면
				box[r - 1][c] = 1;
				zeroCnt--;
				queue.offer(new Integer[] { r - 1, c });				
			}
		}
		// 하
		if (r + 1 < newN && box[r + 1][c] == 0) {
			if (r % N != N - 1) { // 한 층의 가장 아래쪽이 아니라면
				box[r + 1][c] = 1;
				zeroCnt--;
				queue.offer(new Integer[] { r + 1, c });
			}
		}
		// 좌
		if (c - 1 >= 0 && box[r][c - 1] == 0) {
			box[r][c - 1] = 1;
			zeroCnt--;
			queue.offer(new Integer[] { r, c - 1 });
		}
		// 우
		if (c + 1 < M && box[r][c + 1] == 0) {
			box[r][c + 1] = 1;
			zeroCnt--;
			queue.offer(new Integer[] { r, c + 1 });
		}
		// 앞
		if (r - N >= 0 && box[r - N][c] == 0) {
			box[r - N][c] = 1;
			zeroCnt--;
			queue.offer(new Integer[] { r - N, c });
		}
		// 뒤
		if (r + N < newN && box[r + N][c] == 0) {
			box[r + N][c] = 1;
			zeroCnt--;
			queue.offer(new Integer[] { r + N, c });
		}
	}
}
