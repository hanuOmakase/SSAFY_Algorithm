import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 가로 M, 세로 N, 배추 개수 K
// 배추 위치 저장할 2차원 배열, 탐색 여부 저장할 2차원 배열 필요
// 배열 한 칸씩 접근해서 상하좌우 탐색
// 만약 해당 칸의 상하좌우가 1이면 큐에 담기
// 큐에 담긴 칸으로 이동해서 다시 탐색하고, 방문하지 않은 칸이면서 1이면 큐에 담기

// 메모리 초과
// 큐에서 뺄 때 방문체크하는 것이 아니라, 큐에 넣을 때 방문체크

public class Main_1012 { // 1012. 유기농 배추

	private static int M; // 가로
	private static int N; // 세로
	private static int[][] arr; // 배추밭
	private static boolean[][] check; // 방문여부 체크
	private static Queue<int[]> queue = new ArrayDeque<int[]>();
	private static int worms; // 필요한 지렁이
	
	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			arr = new int[N][M];
			check = new boolean[N][M];
			worms = 0;
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr[y][x] = 1;
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == 1 && !check[i][j]) {
						check[i][j] = true;
						bfs(i, j);
					}
				}
			}
			
			sb.append(worms).append("\n");

		} // end of for testCase
		
		System.out.println(sb);

	} // end of main

	private static void bfs(int i, int j) {
		
		for (int d = 0; d < 4; d++) {
			int r = i + dr[d];
			int c = j + dc[d];
			
			// 범위를 벗어나지 않으면서, 배추가 있고, 아직 탐색하지 않은 곳이면
			if (r >= 0 && r < N && c >= 0 && c < M && arr[r][c] == 1 && !check[r][c]) {
				check[r][c] = true;
				queue.offer(new int[] { r, c });
			}
		}
		
		if (queue.isEmpty()) {
			worms++;
			return;
		}
		
		int[] next = queue.poll();
		bfs(next[0], next[1]);
		
	}
	
}
