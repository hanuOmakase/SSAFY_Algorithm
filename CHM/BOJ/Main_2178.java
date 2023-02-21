
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 미로 : 1(이동가능), 0(이동불가)
// 상하좌우로 이동 가능
// 최소 칸 수로 이동 -> 최소라는 걸 어떻게 보장?? -> 전부 다 돌아보고 최소 찾기
// 만약 찾은 길의 칸 수가 N + M - 1 이면 가능한 최소 칸수 이므로 종료

// 상하좌우 칸을 탐색하면서, 1이면 큐에 넣기
// 큐는 int[] { 좌표값x, 좌표값y, 출발지에서 현재위치까지의 칸 수 } 저장
// 만약 현재 칸의 좌표가 N-1, M-1이면 탐색 종료 -> min값과 현재까지 누적된 칸 수 비교해서 더 적은 값을 min으로 업데이트

public class Main_2178 { // 2178. 미로 탐색

	private static int N;
	private static int M;
	private static char[][] arr;
	private static boolean[][] isVisited; // 방문체크
	private static int min = Integer.MAX_VALUE; // 최소 칸 
	private static Queue<int[]> queue = new ArrayDeque<int[]>();
	
	private static int[] dr = { 1, 0, -1, 0 };
	private static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		isVisited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			arr[i] = row.toCharArray();
		}
		
		bfs();
		System.out.println(min);
	}

	private static void bfs() {
		
		queue.offer(new int[] {0, 0, 1}); // 시작위치
		isVisited[0][0] = true;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			if (cur[0] == N - 1 && cur[1] == M - 1) { // 도착위치이면
				min = cur[2] < min ? cur[2] : min; // 최소 칸 수 비교
				if (min == N + M - 1) { return; } // 가능한 최소 칸 수이면 더 탐색하지 않고 종료
				continue;
			}
			
			for (int k = 0; k < 4; k++) {
				int r = cur[0] + dr[k];
				int c = cur[1] + dc[k];
				
				if (r >= 0 && r < N && c >= 0 && c < M && arr[r][c] == '1' && !isVisited[r][c]) {
					queue.offer(new int[] { r, c, cur[2] + 1 });
					isVisited[r][c] = true;
				}
			}
		}
	}
	
}
